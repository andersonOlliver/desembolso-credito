package br.com.bb.intranet.supermt.pf.desembolso.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "desembolsoCreditoPFeContatos")
public class Desembolso implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "grupo", length = 2)
    private String grupo;

    @NotEmpty
    @Size(max = 5)
    @Column(length = 5)
    private String prefixoSuperintendencia;

    @NotEmpty
    @Size(max = 150)
    @Column(length = 150)
    private String nomeSuperintendencia;

    @NotEmpty
    @Size(max = 5)
    @Column(length = 5)
    private String prefixoRegional;

    @NotEmpty
    @Size(max = 150)
    @Column(length = 150)
    private String nomeRegional;

    @NotEmpty
    @Size(max = 5)
    @Column(length = 5)
    private String prefixoAgencia;

    @NotEmpty
    @Size(max = 150)
    @Column(length = 150)
    private String nomeAgencia;

    @Column(precision = 20, scale = 2)
    private String orcamentoPropostoAcumulado;

    @Column(precision = 20, scale = 2)
    private String realizadoAtual;

    @Column(precision = 20, scale = 2)
    private String percentualAtingimentoUm;

    @Column(precision = 20, scale = 2)
    private String realizadoDmenosUm;

    @Column(precision = 20, scale = 2)
    private String necessidadeDiaDmenosUm;

    @Column(precision = 20, scale = 2)
    private String metaContatosAcumulada;

    @Column(precision = 20, scale = 2)
    private String realizadoContatosMes;

    @Column(precision = 20, scale = 2)
    private String percentualAtingimentoContatos;

    @Column(precision = 20, scale = 2)
    private String contatosDmenosUm;

    @Column(precision = 20, scale = 2)
    private String contatosDmenosDois;

    @NotEmpty
    @Size(max = 5)
    @Column(length = 5)
    private String prefixoRepete;

    @NotEmpty
    @Size(max = 150)
    @Column(length = 150)
    private String agenciaRepete;

    @Column(length = 10)
    private String codigoCarteira;

    @Column(length = 80)
    private String carteira;

    @Column(precision = 20, scale = 2)
    private String orcamentoProporcionalAcumuladoDois;

    @Column(precision = 20, scale = 2)
    private String realizadoAtualDois;

    @Column(precision = 20, scale = 2)
    private String percentualAgintimentoDois;

    @Column(precision = 20, scale = 2)
    private String metaContatosAcumuladaDois;

    @Column(precision = 20, scale = 2)
    private String realizadoContatosMesDois;

    @Column(length = 5)
    private Integer percentualAtingimentoContatosDois;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getPrefixoSuperintendencia() {
        return prefixoSuperintendencia;
    }

    public void setPrefixoSuperintendencia(String prefixoSuperintendencia) {
        this.prefixoSuperintendencia = prefixoSuperintendencia;
    }

    public String getNomeSuperintendencia() {
        return nomeSuperintendencia;
    }

    public void setNomeSuperintendencia(String nomeSuperintendencia) {
        this.nomeSuperintendencia = nomeSuperintendencia;
    }

    public String getPrefixoRegional() {
        return prefixoRegional;
    }

    public void setPrefixoRegional(String prefixoRegional) {
        this.prefixoRegional = prefixoRegional;
    }

    public String getNomeRegional() {
        return nomeRegional;
    }

    public void setNomeRegional(String nomeRegional) {
        this.nomeRegional = nomeRegional;
    }

    public String getPrefixoAgencia() {
        return prefixoAgencia;
    }

    public void setPrefixoAgencia(String prefixoAgencia) {
        this.prefixoAgencia = prefixoAgencia;
    }

    public String getNomeAgencia() {
        return nomeAgencia;
    }

    public void setNomeAgencia(String nomeAgencia) {
        this.nomeAgencia = nomeAgencia;
    }

    public String getOrcamentoPropostoAcumulado() {
        return orcamentoPropostoAcumulado;
    }

    public void setOrcamentoPropostoAcumulado(String orcamentoPropostoAcumulado) {
        this.orcamentoPropostoAcumulado = orcamentoPropostoAcumulado;
    }

    public String getRealizadoAtual() {
        return realizadoAtual;
    }

    public void setRealizadoAtual(String realizadoAtual) {
        this.realizadoAtual = realizadoAtual;
    }

    public String getPercentualAtingimentoUm() {
        return percentualAtingimentoUm;
    }

    public void setPercentualAtingimentoUm(String percentualAtingimentoUm) {
        this.percentualAtingimentoUm = percentualAtingimentoUm;
    }

    public String getRealizadoDmenosUm() {
        return realizadoDmenosUm;
    }

    public void setRealizadoDmenosUm(String realizadoDmenosUm) {
        this.realizadoDmenosUm = realizadoDmenosUm;
    }

    public String getNecessidadeDiaDmenosUm() {
        return necessidadeDiaDmenosUm;
    }

    public void setNecessidadeDiaDmenosUm(String necessidadeDiaDmenosUm) {
        this.necessidadeDiaDmenosUm = necessidadeDiaDmenosUm;
    }

    public String getMetaContatosAcumulada() {
        return metaContatosAcumulada;
    }

    public void setMetaContatosAcumulada(String metaContatosAcumulada) {
        this.metaContatosAcumulada = metaContatosAcumulada;
    }

    public String getRealizadoContatosMes() {
        return realizadoContatosMes;
    }

    public void setRealizadoContatosMes(String realizadoContatosMes) {
        this.realizadoContatosMes = realizadoContatosMes;
    }

    public String getPercentualAtingimentoContatos() {
        return percentualAtingimentoContatos;
    }

    public void setPercentualAtingimentoContatos(String percentualAtingimentoContatos) {
        this.percentualAtingimentoContatos = percentualAtingimentoContatos;
    }

    public String getContatosDmenosUm() {
        return contatosDmenosUm;
    }

    public void setContatosDmenosUm(String contatosDmenosUm) {
        this.contatosDmenosUm = contatosDmenosUm;
    }

    public String getContatosDmenosDois() {
        return contatosDmenosDois;
    }

    public void setContatosDmenosDois(String contatosDmenosDois) {
        this.contatosDmenosDois = contatosDmenosDois;
    }

    public String getPrefixoRepete() {
        return prefixoRepete;
    }

    public void setPrefixoRepete(String prefixoRepete) {
        this.prefixoRepete = prefixoRepete;
    }

    public String getAgenciaRepete() {
        return agenciaRepete;
    }

    public void setAgenciaRepete(String agenciaRepete) {
        this.agenciaRepete = agenciaRepete;
    }

    public String getCodigoCarteira() {
        return codigoCarteira;
    }

    public void setCodigoCarteira(String codigoCarteira) {
        this.codigoCarteira = codigoCarteira;
    }

    public String getCarteira() {
        return carteira;
    }

    public void setCarteira(String carteira) {
        this.carteira = carteira;
    }

    public String getOrcamentoProporcionalAcumuladoDois() {
        return orcamentoProporcionalAcumuladoDois;
    }

    public void setOrcamentoProporcionalAcumuladoDois(String orcamentoProporcionalAcumuladoDois) {
        this.orcamentoProporcionalAcumuladoDois = orcamentoProporcionalAcumuladoDois;
    }

    public String getRealizadoAtualDois() {
        return realizadoAtualDois;
    }

    public void setRealizadoAtualDois(String realizadoAtualDois) {
        this.realizadoAtualDois = realizadoAtualDois;
    }

    public String getPercentualAgintimentoDois() {
        return percentualAgintimentoDois;
    }

    public void setPercentualAgintimentoDois(String percentualAgintimentoDois) {
        this.percentualAgintimentoDois = percentualAgintimentoDois;
    }

    public String getMetaContatosAcumuladaDois() {
        return metaContatosAcumuladaDois;
    }

    public void setMetaContatosAcumuladaDois(String metaContatosAcumuladaDois) {
        this.metaContatosAcumuladaDois = metaContatosAcumuladaDois;
    }

    public String getRealizadoContatosMesDois() {
        return realizadoContatosMesDois;
    }

    public void setRealizadoContatosMesDois(String realizadoContatosMesDois) {
        this.realizadoContatosMesDois = realizadoContatosMesDois;
    }

    public Integer getPercentualAtingimentoContatosDois() {
        return percentualAtingimentoContatosDois;
    }

    public void setPercentualAtingimentoContatosDois(Integer percentualAtingimentoContatosDois) {
        this.percentualAtingimentoContatosDois = percentualAtingimentoContatosDois;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Desembolso other = (Desembolso) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

}
