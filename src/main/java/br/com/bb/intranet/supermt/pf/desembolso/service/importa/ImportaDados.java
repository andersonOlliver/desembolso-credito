package br.com.bb.intranet.supermt.pf.desembolso.service.importa;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.com.bb.intranet.supermt.pf.desembolso.model.Desembolso;
import br.com.bb.intranet.supermt.pf.desembolso.repository.Desembolsos;
import br.com.bb.intranet.supermt.pf.desembolso.service.NegocioException;
import br.com.bb.intranet.supermt.pf.desembolso.util.Transactional;
import java.io.Serializable;
import java.math.BigDecimal;
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
     * @throws br.com.bb.intranet.supermt.pf.desembolso.service.NegocioException
     */
    public void processaPlanilha(Planilha planilha) throws NegocioException {
        List<Desembolso> dadosParaSalvar = new ArrayList<>();
        
        int linha = 0;
        Double d;
        try {

            //cria um workbook = planilha toda com todas as abas
            XSSFWorkbook workbook = new XSSFWorkbook(planilha.getFile());

            //recuperamos apenas a aba mandada
            XSSFSheet sheet = workbook.getSheetAt(planilha.getNumeroDaPlanilha() - 1);

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

                Desembolso desembolso = new Desembolso();
                //varremos todas as celulas da linha atual
                while (cellIterator.hasNext()) {
                    //criamos uma celula
                    cell = cellIterator.next();

                    //TODO O CÓDIGO DE PERSISTENCIA AQUI!!
                    switch (coluna) {
                        case ColunasDesembolso.GRUPO:
                            desembolso.setGrupo(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.PREFIXO_SUPER_INTENDENCIA:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setPrefixoSuperintendencia(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.NOME_SUPER_INTENDENCIA:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setNomeSuperintendencia(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.PREFIXO_REGIONAL:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setPrefixoRegional(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.NOME_AGENCIA:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setNomeAgencia(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.ORCAMENTO_PROPOSTO_ACUMULADO:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setOrcamentoPropostoAcumulado(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.REALIZADO_ATUAL:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setRealizadoAtual(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.PERCENTUAL_ATINGIMENTO_UM:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setPercentualAtingimentoUm(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.REALIZADO_D_MENOS_UM:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setRealizadoDmenosUm(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.NECESSIDADE_DIA_MENOS_UM:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setNecessidadeDiaDmenosUm(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.META_CONTATOS_ACUMULADA:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setMetaContatosAcumulada(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.REALIZADO_CONTATOS_MES:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setRealizadoContatosMes(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.PERCENTUAL_ATINGIMENTO_CONTATOS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setPercentualAtingimentoContatos(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.CONTATOS_D_MENOS_UM:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setContatosDmenosUm(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.CONTATOS_D_MENOS_DOIS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setContatosDmenosDois(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.PREFIXO_REPETE:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setPrefixoRepete(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.AGENCIA_REPETE:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setAgenciaRepete(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.CODIDGO_CARTEIRA:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setCodigoCarteira(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.CARTEIRA:
                            cell.setCellType(Cell.CELL_TYPE_STRING);
                            desembolso.setCarteira(cell.getStringCellValue());
                            break;
                        case ColunasDesembolso.ORCAMENTO_PROPORCIONAL_ACUMULADO_DOIS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setOrcamentoProporcionalAcumuladoDois(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.REALIZADO_ATUAL_DOIS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setRealizadoAtualDois(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.PERCENTUAL_ATINGIMENTO_DOIS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setPercentualAgintimentoDois(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.META_CONTATOS_ACUMULADA_DOIS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setMetaContatosAcumuladaDois(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.REALIZADO_CONTATOS_MES_DOIS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setRealizadoContatosMesDois(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                        case ColunasDesembolso.PERCENTUAL_ATINGIMENTO_CONTATOS_DOIS:
                            cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                            desembolso.setPercentualAtingimentoContatosDois(this.doubleToBigDecimal(cell.getNumericCellValue()));
                            break;
                    }

                    System.out.println("valor = " + cell.toString());

                    coluna++;
                }
                dadosParaSalvar.add(desembolso);
            }
            this.salvar(dadosParaSalvar);

        } catch (FileNotFoundException ex) {
            throw new NegocioException("Arquivo com Erro Tente novamente!!");
        } catch (IOException ex) {
            throw new NegocioException("Arquivo com Erro Tente novamente!!");
        }
    }

    @Transactional
    public void salvar(List<Desembolso> desembolsos) {
        for (Desembolso desembolso : desembolsos) {
            this.desembolsoRepository.adicionar(desembolso);
        }
    }

    private BigDecimal doubleToBigDecimal(double valor) {
        return new BigDecimal(valor);
    }

}
