/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author edilson
 */
public interface IDAO {
    public void cadastrar(Object o)throws SQLException;
    public void alterar(Object o)throws SQLException;
    public void excluir(Integer id)throws SQLException;
    public List listarTodos()throws SQLException;
}
