/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.service.importa;

import java.io.InputStream;

/**
 *
 * @author Olliver
 */
public class Planilha {
    
    private InputStream file;
    private Integer numeroDaPlanilha;
    private Integer primeiraLinha;
    private Integer ultimaLinha;

    public InputStream getFile() {
        return file;
    }

    public void setFile(InputStream file) {
        this.file = file;
    }

    public Integer getNumeroDaPlanilha() {
        return numeroDaPlanilha;
    }

    public void setNumeroDaPlanilha(Integer numeroDaPlanilha) {
        this.numeroDaPlanilha = numeroDaPlanilha;
    }

    public Integer getPrimeiraLinha() {
        return primeiraLinha;
    }

    public void setPrimeiraLinha(Integer primeiraLinha) {
        this.primeiraLinha = primeiraLinha;
    }

    public Integer getUltimaLinha() {
        return ultimaLinha;
    }

    public void setUltimaLinha(Integer ultimaLinha) {
        this.ultimaLinha = ultimaLinha;
    }

    
   

    @Override
    public String toString() {
        return "Planilha{" + "file=" + file + ", numeroDaPlanilha=" + numeroDaPlanilha + ", primeiraLinha=" + primeiraLinha + ", ultimaLinha=" + ultimaLinha + '}';
    }
    
    
}
