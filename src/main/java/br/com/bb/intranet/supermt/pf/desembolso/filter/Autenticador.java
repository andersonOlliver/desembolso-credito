package br.com.bb.intranet.supermt.pf.desembolso.filter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author t1071932
 */
import br.com.bb.intranet.supermt.pf.desembolso.model.Acesso;
import br.com.bb.intranet.supermt.pf.desembolso.model.Usuario;
import br.com.bb.intranet.supermt.pf.desembolso.repository.Acessos;
import br.com.bb.intranet.supermt.pf.desembolso.service.NegocioException;
import br.com.bb.intranet.supermt.pf.desembolso.service.cadastro.CadastroUsuarios;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@ManagedBean
//@WebFilter(filterName = "LoginCheckFilter", urlPatterns = "*.super")
public class Autenticador implements Filter {

    @Inject
    private CadastroUsuarios cadastroUsuario;

    @Inject
    private Acessos acessoRepository;

    @ManagedProperty(value = "#{usuario}")
    private static Usuario usuario = null;

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public boolean login(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession httpSession = req.getSession();
        usuario = (Usuario) httpSession.getAttribute("usuario");
//        System.out.println("Chave-" + usuario.getChave());
        if (usuario == null) {
            Cookie cookies[] = req.getCookies();
            if (cookies != null) {
                String tokenId = getCookieValue(cookies, Proxy.NOME_COOKIE_SSO);
                if (tokenId == null) {
                    enviaPaginaLogin(req, resp);
                    return false;
                } else {
                    String servidor = getCookieValue(cookies, Proxy.NOME_COOKIE_ACR);
                    if (servidor == null) {
                        servidor = Proxy.SERVIDOR_SSO_PADRAO;
                    }
                    usuario = getAtributosUsuario(servidor, tokenId);
                    if (usuario == null) {
                        resetCookies(resp, Proxy.NOME_COOKIE_SSO, Proxy.NOME_COOKIE_ACR);
                        enviaPaginaLogin(req, resp);
                        return false;
                    }
                    httpSession.setAttribute("usuario", usuario);
                    this.registraNavegacao(req, resp);
                }
            }
        } else {
            this.registraNavegacao(req, resp);
        }
        return true;
    }

    private void registraNavegacao(HttpServletRequest req, HttpServletResponse resp) {
        if (!req.getRequestURI().regionMatches(1, "javax", 0, 5)) {
            Acesso acesso = new Acesso();
            acesso.setHorario(new Date());
            acesso.setPagina(req.getRequestURI());
            acesso.setUsuario(usuario);

            this.acessoRepository.adicionar(acesso);
        }

    }

    private void resetCookies(HttpServletResponse response, String... names) {
        for (String name : names) {
            Cookie cookie = new Cookie(name, "");
            cookie.setDomain("bb.com.br");
            cookie.setMaxAge(0);
            cookie.setPath("/");
            cookie.setComment("EXPIRING COOKIE at " + System.currentTimeMillis());
            response.addCookie(cookie);
        }
    }

    public void enviaPaginaLogin(HttpServletRequest httpServletRequest, HttpServletResponse response) {
        try {
            response.sendRedirect(getLoginUrl(httpServletRequest));
        } catch (IOException e) {
        }

    }

    public String getLoginUrl(HttpServletRequest req) {
        String url = req.getRequestURL().toString();
        String query = req.getQueryString();
        if (query != null && query.length() > 0) {
            url += ("?" + query);
        }
        try {
            url = URLEncoder.encode(url, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
        }
        return Proxy.URL_LOGIN + url;
    }

    public void logout(HttpServletRequest req, HttpServletResponse resp) {
        Cookie cookies[] = req.getCookies();
        String tokenId = getCookieValue(cookies, Proxy.NOME_COOKIE_SSO);
        String servidor = getCookieValue(cookies, Proxy.NOME_COOKIE_ACR);
        if (servidor == null) {
            servidor = Proxy.SERVIDOR_SSO_PADRAO;
        }
        get(Proxy.PROTOCOLO + "://" + servidor + "/sso/identity/logout?subjectid=" + tokenId);
        HttpSession s = req.getSession();
        s.removeAttribute("usuario");
        s.removeAttribute("tokenId");
        Cookie cookie = new Cookie(Proxy.NOME_COOKIE_ACR, "");
        cookie.setDomain("bb.com.br");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        resp.addCookie(cookie);
        cookie = new Cookie(Proxy.NOME_COOKIE_SSO, "");
        cookie.setDomain("bb.com.br");
        cookie.setMaxAge(0);
        cookie.setPath("/");
        resp.addCookie(cookie);
    }

    public String getCookieValue(Cookie[] cookies, String nomeCookie) {
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(nomeCookie)) {
                return (cookie.getValue());
            }
        }
        return null;
    }

    public Usuario getAtributosUsuario(String servidor, String tokenId) {
        String url = Proxy.PROTOCOLO + "://" + servidor + "/sso/identity/attributes?subjectid=" + tokenId;
        String response = get(url);
        if (response != null) {
            int index2 = response.indexOf("userdetails.attribute.name=");
            String atributos = response.substring(index2, response.length());
            StringTokenizer st = new StringTokenizer(atributos, "\n");
            Map<String, String> map = new HashMap<>();
            while (st.hasMoreElements()) {
                try {
                    String key = (String) st.nextElement();
                    String value = (String) st.nextElement();
                    if (value.startsWith("userdetails.attribute.name=")) {
                        key = value;
                        value = (String) st.nextElement();
                    }
                    map.put(key.substring(27, key.length()), value.substring(28, value.length()));
                } catch (NoSuchElementException nsee) {
                }
            }
            usuario = new Usuario();
            usuario.setChave(getAttribute(map, "chaveFuncionario", "uid", "ibm-nativeid", "cd-idgl-usu").toUpperCase());
            usuario.setPrefixo(getAttribute(map, "cd-pref-depe")); // "prefixoDependencia",
            usuario.setNomeCompleto(getAttribute(map, "nomeFuncionario", "nm-idgl", "sn").toUpperCase());
            usuario.setApelido(getAttribute(map, "nomeGuerra", "displayname", "nomeFuncionario", "nm-idgl", "sn").toUpperCase());

            this.salvaUsuario(usuario);
            return usuario;
        }
        return null;
    }

    public void salvaUsuario(Usuario Usuario) {
        try {
            this.cadastroUsuario.salvar(Usuario);
        } catch (NegocioException e) {
            
        }
    }

    private String getAttribute(Map<String, String> map, String... ss) {
        for (String s : ss) {
            String a = getAttribute(map, s);
            if (a != null && a.length() > 0) {
                return a;
            }
        }
        return null;
    }

    private String get(String url) {
        URLConnection connection;
        try {
            connection = new URL(url).openConnection();
            connection.setRequestProperty("Request-Method", "GET");
            connection.setConnectTimeout(1000);
            connection.setReadTimeout(1000);
            connection.setDoInput(true);
            connection.setDoOutput(false);
            // 36ms
            connection.connect();
            StringBuffer newData;
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
                newData = new StringBuffer(10000);
                String s = "";
                while (null != ((s = br.readLine()))) {
                    newData.append(s);
                    newData.append("\n");
                }
            }

            return newData.toString();

        } catch (Exception e) {
            return null;
        }
    }

    private String getAttribute(Map<String, String> map, String string) {
        String o = map.get(string);
        if (o != null) {
            return o;
        }
        return map.get(string.toLowerCase());
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request,
            ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        if (this.login((HttpServletRequest) request, (HttpServletResponse) response) == true) {
            if ("/logout.super".equals(((HttpServletRequest) request).getRequestURI())) {
                this.logout((HttpServletRequest) request, (HttpServletResponse) response);
                ((HttpServletResponse) response).sendRedirect("/");
            }
            chain.doFilter(request, response);
        }
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
//        session = HibernateUtil.getSessionFactory().openSession();
    }

}
