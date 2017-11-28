/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Cliente;

/**
 *
 * @author edilson
 */
public class DaoCliente implements IDAO {

    public void CloseConnection() throws SQLException {
        DaoConexao.getConnection().close();
    }

    @Override
    public void cadastrar(Object o) throws SQLException {
        DaoConexao.getConnection().getTransaction().begin();
        DaoConexao.getConnection().persist(o);
        DaoConexao.getConnection().getTransaction().commit();

    }

    @Override
    public void alterar(Object o) throws SQLException {

        DaoConexao.getConnection().getTransaction().begin();
        DaoConexao.getConnection().merge(o);
        DaoConexao.getConnection().getTransaction().commit();

    }

    @Override
    public void excluir(Integer o) throws SQLException {

        DaoConexao.getConnection().getTransaction().begin();
        Cliente c = DaoConexao.getConnection().find(Cliente.class, o);
        DaoConexao.getConnection().remove(c);
        DaoConexao.getConnection().getTransaction().commit();

    }

    @Override
    public List listarTodos() throws SQLException {

        TypedQuery<Cliente> query = DaoConexao.getConnection().createQuery("SELECT c FROM Cliente c", Cliente.class);
        List<Cliente> lista = query.getResultList();
        return lista;
    }
}
    
    
                    
     
