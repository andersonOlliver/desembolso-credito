/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.controller;

import br.com.bb.intranet.supermt.pf.desembolso.service.importa.ImportaDados;
import br.com.bb.intranet.supermt.pf.desembolso.service.importa.Planilha;
import java.io.IOException;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author Olliver
 */
@Named(value = "importaDadosPlanilha")
@ViewScoped
public class ImportaPlanilhaDesembolsoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private ImportaDados importa;
    private Planilha planilha;

    public void preparaPlanilha() {
        this.planilha = new Planilha();
    }

    public void processaPlanilha(FileUploadEvent event) {
        try {

            planilha.setFile(event.getFile().getInputstream());

            System.out.println(this.planilha.toString());

            //CHAMAR O METODO PRA PERSISTIR A TABELA
            FacesMessage message = new FacesMessage("Tudo Certo!", "Os dados foram armazenados.");
            FacesContext.getCurrentInstance().addMessage(null, message);

        } catch (IOException ex) {
            FacesMessage mensagem = new FacesMessage("Tudo Errado Sas bodegas!");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            FacesContext.getCurrentInstance().addMessage(null, mensagem);
        }
    }

    public Planilha getPlanilha() {
        return planilha;
    }

    public void setPlanilha(Planilha planilha) {
        this.planilha = planilha;
    }

}
