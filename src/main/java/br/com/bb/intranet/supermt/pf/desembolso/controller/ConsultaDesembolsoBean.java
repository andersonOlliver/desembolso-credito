/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.controller;

import br.com.bb.intranet.supermt.pf.desembolso.model.DesembolsoCreditoPFeContatos;
import br.com.bb.intranet.supermt.pf.desembolso.repository.Acessos;
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
public class ConsultaDesembolsoBean implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final String VALORPADRAO = "A";

    @Inject
    private Acessos repository;

    private List<DesembolsoCreditoPFeContatos> dados;
    private String grupo;

    public void consultar() {
//        if(grupo == null){
        this.dados = this.repository.todas();
//        }

//        try {
//            this.dados = this.repository.porGrupo(this.grupo);
//
//        } catch (NullPointerException e) {
//            this.dados = this.repository.porGrupo(VALORPADRAO);
//        } catch (IllegalArgumentException e) {
//            this.dados = this.repository.porGrupo(VALORPADRAO);
//        }
    }

    public List<DesembolsoCreditoPFeContatos> getDados() {
        return dados;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

}
