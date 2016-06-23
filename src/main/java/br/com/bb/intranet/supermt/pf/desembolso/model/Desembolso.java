package br.com.bb.intranet.supermt.pf.desembolso.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
    private BigDecimal orcamentoPropostoAcumulado;

    @Column(precision = 20, scale = 2)
    private BigDecimal realizadoAtual;

    @Column(precision = 20, scale = 2)
    private BigDecimal percentualAtingimentoUm;

    @Column(precision = 20, scale = 2)
    private BigDecimal realizadoDmenosUm;

    @Column(precision = 20, scale = 2)
    private BigDecimal necessidadeDiaDmenosUm;

    @Column(precision = 20, scale = 2)
    private BigDecimal metaContatosAcumulada;

    @Column(precision = 20, scale = 2)
    private BigDecimal realizadoContatosMes;

    @Column(precision = 20, scale = 2)
    private BigDecimal percentualAtingimentoContatos;

    @Column(precision = 20, scale = 2)
    private BigDecimal contatosDmenosUm;

    @Column(precision = 20, scale = 2)
    private BigDecimal contatosDmenosDois;

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
    private BigDecimal orcamentoProporcionalAcumuladoDois;

    @Column(precision = 20, scale = 2)
    private BigDecimal realizadoAtualDois;

    @Column(precision = 20, scale = 2)
    private BigDecimal percentualAgintimentoDois;

    @Column(precision = 20, scale = 2)
    private BigDecimal metaContatosAcumuladaDois;

    @Column(precision = 20, scale = 2)
    private BigDecimal realizadoContatosMesDois;

    @Column(length = 5)
    private BigDecimal percentualAtingimentoContatosDois;

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

    public BigDecimal getOrcamentoPropostoAcumulado() {
        return orcamentoPropostoAcumulado;
    }

    public void setOrcamentoPropostoAcumulado(BigDecimal orcamentoPropostoAcumulado) {
        this.orcamentoPropostoAcumulado = orcamentoPropostoAcumulado;
    }

    public BigDecimal getRealizadoAtual() {
        return realizadoAtual;
    }

    public void setRealizadoAtual(BigDecimal realizadoAtual) {
        this.realizadoAtual = realizadoAtual;
    }

    public BigDecimal getPercentualAtingimentoUm() {
        return percentualAtingimentoUm;
    }

    public void setPercentualAtingimentoUm(BigDecimal percentualAtingimentoUm) {
        this.percentualAtingimentoUm = percentualAtingimentoUm;
    }

    public BigDecimal getRealizadoDmenosUm() {
        return realizadoDmenosUm;
    }

    public void setRealizadoDmenosUm(BigDecimal realizadoDmenosUm) {
        this.realizadoDmenosUm = realizadoDmenosUm;
    }

    public BigDecimal getNecessidadeDiaDmenosUm() {
        return necessidadeDiaDmenosUm;
    }

    public void setNecessidadeDiaDmenosUm(BigDecimal necessidadeDiaDmenosUm) {
        this.necessidadeDiaDmenosUm = necessidadeDiaDmenosUm;
    }

    public BigDecimal getMetaContatosAcumulada() {
        return metaContatosAcumulada;
    }

    public void setMetaContatosAcumulada(BigDecimal metaContatosAcumulada) {
        this.metaContatosAcumulada = metaContatosAcumulada;
    }

    public BigDecimal getRealizadoContatosMes() {
        return realizadoContatosMes;
    }

    public void setRealizadoContatosMes(BigDecimal realizadoContatosMes) {
        this.realizadoContatosMes = realizadoContatosMes;
    }

    public BigDecimal getPercentualAtingimentoContatos() {
        return percentualAtingimentoContatos;
    }

    public void setPercentualAtingimentoContatos(BigDecimal percentualAtingimentoContatos) {
        this.percentualAtingimentoContatos = percentualAtingimentoContatos;
    }

    public BigDecimal getContatosDmenosUm() {
        return contatosDmenosUm;
    }

    public void setContatosDmenosUm(BigDecimal contatosDmenosUm) {
        this.contatosDmenosUm = contatosDmenosUm;
    }

    public BigDecimal getContatosDmenosDois() {
        return contatosDmenosDois;
    }

    public void setContatosDmenosDois(BigDecimal contatosDmenosDois) {
        this.contatosDmenosDois = contatosDmenosDois;
    }

    public BigDecimal getOrcamentoProporcionalAcumuladoDois() {
        return orcamentoProporcionalAcumuladoDois;
    }

    public void setOrcamentoProporcionalAcumuladoDois(BigDecimal orcamentoProporcionalAcumuladoDois) {
        this.orcamentoProporcionalAcumuladoDois = orcamentoProporcionalAcumuladoDois;
    }

    public BigDecimal getRealizadoAtualDois() {
        return realizadoAtualDois;
    }

    public void setRealizadoAtualDois(BigDecimal realizadoAtualDois) {
        this.realizadoAtualDois = realizadoAtualDois;
    }

    public BigDecimal getPercentualAgintimentoDois() {
        return percentualAgintimentoDois;
    }

    public void setPercentualAgintimentoDois(BigDecimal percentualAgintimentoDois) {
        this.percentualAgintimentoDois = percentualAgintimentoDois;
    }

    public BigDecimal getMetaContatosAcumuladaDois() {
        return metaContatosAcumuladaDois;
    }

    public void setMetaContatosAcumuladaDois(BigDecimal metaContatosAcumuladaDois) {
        this.metaContatosAcumuladaDois = metaContatosAcumuladaDois;
    }

    public BigDecimal getRealizadoContatosMesDois() {
        return realizadoContatosMesDois;
    }

    public void setRealizadoContatosMesDois(BigDecimal realizadoContatosMesDois) {
        this.realizadoContatosMesDois = realizadoContatosMesDois;
    }

    public BigDecimal getPercentualAtingimentoContatosDois() {
        return percentualAtingimentoContatosDois;
    }

    public void setPercentualAtingimentoContatosDois(BigDecimal percentualAtingimentoContatosDois) {
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
