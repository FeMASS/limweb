/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoCliente;
import java.sql.SQLException;
import java.util.List;
import model.Cliente;

/**
 *
 * @author edilson
 */
public class ControleCliente {
     dao.DaoCliente daoCliente = new DaoCliente();
    
    public void cadastrar(Cliente o) throws SQLException {
        daoCliente.cadastrar(o);
        
    }
    
    public void excluir (Integer o)  throws SQLException {
        daoCliente.excluir(o);
    
    }
    
    public void alterar(Cliente o) throws SQLException {
        daoCliente.alterar(o);
    
    }
     
    public List listarTodos() throws SQLException{
        return daoCliente.listarTodos();
    
    }
}
