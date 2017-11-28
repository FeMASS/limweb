/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.DaoEmpregado;
import java.sql.SQLException;
import java.util.List;
import model.Empregado;

/**
 *
 * @author edilson
 */
public class ControleEmpregado {
     dao.DaoEmpregado DaoEmpregado = new DaoEmpregado();
    
    public void cadastrar(Empregado o) throws SQLException {
        DaoEmpregado.cadastrar(o);
        
    }
    
    public void excluir (Integer o)  throws SQLException {
        DaoEmpregado.excluir(o);
    
    }
    
    public void alterar(Empregado o) throws SQLException {
        DaoEmpregado.alterar(o);
    
    }
     
    public List listarTodos() throws SQLException{
        return DaoEmpregado.listarTodos();
    
    }
}
