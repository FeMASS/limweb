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
import model.Pedido;

/**
 *
 * @author edilson
 */
public class DaoPedido implements IDAO {

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
        Pedido p = DaoConexao.getConnection().find(Pedido.class, o);
        DaoConexao.getConnection().remove(p);
        DaoConexao.getConnection().getTransaction().commit();

    }

    @Override
    public List listarTodos() throws SQLException {

        TypedQuery<Pedido> query = DaoConexao.getConnection().createQuery("SELECT p FROM Pedido p", Pedido.class);
        List<Pedido> lista = query.getResultList();
        return lista;
    }
}
    
    
                    
     
