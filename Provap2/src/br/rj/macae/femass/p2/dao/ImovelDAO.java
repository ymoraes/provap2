/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.p2.dao;


import br.rj.macae.femass.p2.entidade.Imovel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author anamm
 */
public class ImovelDAO implements IDAO{

    @Override
    public void cadastrar(Object o) throws SQLException {
        
        
            Imovel c = (Imovel)o;
            EntityManager em = FabricaConexao.getConexao().createEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            em.close();
        
    }

     @Override
    public void alterar(Object o) throws SQLException {
        Imovel cliente = (Imovel) o;               
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        em.merge(cliente);
        em.getTransaction().commit();
        em.close();
      
           
    }



     @Override
    public List listarTodos() throws SQLException {
        
        try {
            EntityManager em = FabricaConexao.getConexao().createEntityManager();
            TypedQuery<Imovel> consulta = em.createQuery("SELECT c FROM Imovel c",Imovel.class);
            List<Imovel> clientes = consulta.getResultList();
            em.close();
            return clientes;
                        
        } catch (Exception e) {
            throw new SQLException("Eroo ao tentar listar o imovel. \n" + e.getMessage());
        }
        
    }

     @Override
    public Object listarPorId(int id) throws SQLException {
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        Imovel r = em.find(Imovel.class, new Integer(id));        
        em.close();
        return r;

    }
    
}
