/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import dao.DaoConexao;
import dao.DaoServico;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Servico;

/**
 *
 * @author edilson
 */
public class ControleServico {
     dao.DaoServico daoServico = new DaoServico();
    
    public void cadastrar(Servico o) throws SQLException {
        daoServico.cadastrar(o);
        
    }
    
    public void excluir (Integer o)  throws SQLException {
        daoServico.excluir(o);
    
    }
    
    public void alterar(Servico o) throws SQLException {
        daoServico.alterar(o);
    
    }
     
    public List listarTodos() throws SQLException{
        return daoServico.listarTodos();
    
    }
    
    public void createPdf(String filename) throws DocumentException, FileNotFoundException, SQLException{


    TypedQuery<Servico> consulta = DaoConexao.getConnection().createQuery("Select f from Servico f",Servico.class);
    List<Servico> servico = consulta.getResultList();
    Document document = new Document();        
    PdfWriter.getInstance(document, new FileOutputStream(filename));        
    document.open();        
    document.add(new Paragraph("Funções: "+ servico.size()));      
    for(Servico f : servico){
        document.add(new Paragraph( "Descricão: " + f.getDescricao()+": Valor metro: " + f.getValormetro()+ " Empregado Responsável: " + f.getEmpregado() + " Pedido: " + f.getPedido()));                  
    }                
    document.close();   
}
}
