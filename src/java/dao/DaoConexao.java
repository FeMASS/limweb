/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.SQLException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author edilson
 */
public class DaoConexao {

    private static EntityManager jpaconexao = null;

    private DaoConexao() throws SQLException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("limappPU");
        DaoConexao.jpaconexao = emf.createEntityManager();
    }

    public static EntityManager getConnection() throws SQLException {
        if (DaoConexao.jpaconexao == null) {
            new DaoConexao();
            return DaoConexao.jpaconexao;
        } else {
            return DaoConexao.jpaconexao;
        }
    }
}
