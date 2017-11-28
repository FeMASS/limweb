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
import dao.DaoPedido;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.TypedQuery;
import model.Pedido;
import model.Pedido;

/**
 *
 * @author edilson
 */
public class ControlePedido {
     dao.DaoPedido daoPedido = new DaoPedido();
    
    public void cadastrar(Pedido o) throws SQLException {
        daoPedido.cadastrar(o);
        
    }
    
    public void excluir (Integer o)  throws SQLException {
        daoPedido.excluir(o);
    
    }
    
    public void alterar(Pedido o) throws SQLException {
        daoPedido.alterar(o);
    
    }
     
    public List listarTodos() throws SQLException{
        return daoPedido.listarTodos();
    
    }
    
    public void createPdf(String filename) throws DocumentException, FileNotFoundException, SQLException{


    TypedQuery<Pedido> consulta = DaoConexao.getConnection().createQuery("Select f from Pedido f",Pedido.class);
    List<Pedido> funcaes = consulta.getResultList();
    Document document = new Document();        
    PdfWriter.getInstance(document, new FileOutputStream(filename));        
    document.open();        
    document.add(new Paragraph("Funções: "+ funcaes.size()));      
    for(Pedido f : funcaes){
        document.add(new Paragraph( "Data: " + f.getData()+": Metragem: "+f.getMetragem()+ " Cliente: " + f.getCliente()));                  
    }                
    document.close();       
}
}
