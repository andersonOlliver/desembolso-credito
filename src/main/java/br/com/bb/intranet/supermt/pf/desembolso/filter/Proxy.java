/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.filter;

/**
 *
 * @author Olliver
 */
public abstract class Proxy {
    
    public static final String PROTOCOLO = "http";
    public static final String DOMINIO_LOGIN = "login.intranet.bb.com.br";
    public static final String PORTA = "8080";
    public static final String NOME_COOKIE_SSO = "BBSSOToken";
    public static final String NOME_COOKIE_ACR = "ssoacr";
    public static final String URL_LOGIN = PROTOCOLO + "://" + DOMINIO_LOGIN + "/distAuth/UI/Login?goto=";
    public static final String SERVIDOR_SSO_PADRAO = "sso.intranet.bb.com.br";
    
}
