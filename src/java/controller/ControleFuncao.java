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
import dao.DaoFuncao;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Funcao;

/**
 *
 * @author edilson
 */
public class ControleFuncao {
     dao.DaoFuncao daoFuncao = new DaoFuncao();
    
    public void cadastrar(Funcao o) throws SQLException {
        daoFuncao.cadastrar(o);
        
    }
    
    public void excluir (Integer o)  throws SQLException {
        daoFuncao.excluir(o);
    
    }
    
    public void alterar(Funcao o) throws SQLException {
        daoFuncao.alterar(o);
    
    }
     
    public List listar() throws SQLException{
        return daoFuncao.listarTodos();
    
    }
    
    public void createPdf(String filename) throws DocumentException, FileNotFoundException, SQLException{


    TypedQuery<Funcao> consulta = DaoConexao.getConnection().createQuery("Select f from Funcao f",Funcao.class);
    List<Funcao> funcaes = consulta.getResultList();
    Document document = new Document();        
    PdfWriter.getInstance(document, new FileOutputStream(filename));        
    document.open();        
    document.add(new Paragraph("Pedido: "+ funcaes.size()));      
    for(Funcao f : funcaes){
        document.add(new Paragraph(f.getNome()+": Sálario: "+f.getSalario() + " Metragem: " + f.getMetro()));                  
    }                
    document.close();       
}
}
