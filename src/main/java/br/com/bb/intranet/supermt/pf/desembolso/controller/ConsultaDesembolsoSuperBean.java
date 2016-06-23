/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.controller;

import br.com.bb.intranet.supermt.pf.desembolso.model.Desembolso;
import br.com.bb.intranet.supermt.pf.desembolso.repository.Desembolsos;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Olliver
 */
@Named
@ViewScoped
public class ConsultaDesembolsoSuperBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private Desembolsos repository;

    private List<Desembolso> dados;
    private String grupo;

    public void consultar() {
        
        this.dados = this.repository.todas();
        
    }

    public List<Desembolso> getDados() {
        return dados;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
