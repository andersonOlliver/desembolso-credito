/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bb.intranet.supermt.pf.desembolso.service.importa;


import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.bb.intranet.supermt.pf.desembolso.model.Desembolso;
import br.com.bb.intranet.supermt.pf.desembolso.repository.Desembolsos;
import br.com.bb.intranet.supermt.pf.desembolso.util.Transactional;
import java.io.Serializable;
import javax.inject.Inject;

/**
 *
 * @author Olliver
 */
public class ImportaDados implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Desembolsos desembolsoRepository;
    /**
     *
     * @param planilha objeto do tipo Planilha que contém todos os dados 
     * necessários para facilitar a operação na planilha
     */
    public void processaDados(Planilha planilha) {
        List<Desembolso> dadosParaSalvar = new ArrayList();
        int linha = 0;
        Double d;
        try {

            //cria um workbook = planilha toda com todas as abas
            HSSFWorkbook workbook = new HSSFWorkbook(planilha.getFile());

            //recuperamos apenas a aba mandada
            HSSFSheet sheet = workbook.getSheetAt(planilha.getNumeroDaPlanilha() - 1);

            //retorna todas as linhas da planilha selecioada 
            Iterator<Row> rowIterator = sheet.iterator();

            //varre todas as linhas da planilha selecionada
            while (rowIterator.hasNext() && linha < planilha.getUltimaLinha()) {
                linha++;

                //recebe cada linha da planilha
                Row row = rowIterator.next();

                //andar as linhas que serão ignoradas no início
                if (row.getRowNum() < planilha.getUltimaLinha()) {
                    continue;
                }

                //pegamos todas as celulas desta linha
                Iterator<Cell> cellIterator = row.iterator();
                
                //responsavel por definir qual coluna esta sendo trabalhada no intante
                int coluna = 1;

                Cell cell;
                //varremos todas as celulas da linha atual
                while (cellIterator.hasNext()) {
                    //criamos uma celula
                    cell = cellIterator.next();
                    
                    //TODO O CÓDIGO DE PERSISTENCIA AQUI!!
                    
                    System.out.println("valor"+ cell.toString());

                    
                    //inserir dentro do dadosParaSalvar
                    coluna++;
                }

            }
            
            // 
            
        } catch (FileNotFoundException ex) {
            System.out.println("Erro 01");
        } catch (IOException ex) {
            System.out.println("Erro 02");
        }
    }
    
    @Transactional
    public void salvar(List<Desembolso> desembolsos){
        for(Desembolso desembolso: desembolsos){
            this.desembolsoRepository.adicionar(desembolso);
        }
    }
}
