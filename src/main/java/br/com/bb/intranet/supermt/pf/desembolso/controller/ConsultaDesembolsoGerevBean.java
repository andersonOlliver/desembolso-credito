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
public class ConsultaDesembolsoGerevBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Desembolsos acessoRepository;
    
    private List<Desembolso> dados;
    
    public void consultar(){
        this.dados = this.acessoRepository.todas();
    }

    public List<Desembolso> getDados() {
        return dados;
    }
    
}
