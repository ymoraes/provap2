

package br.rj.macae.femass.p2.dao;


import br.rj.macae.femass.p2.dao.FabricaConexao;
import br.rj.macae.femass.p2.dao.IDAO;
import br.rj.macae.femass.p2.entidade.Categoria;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author YMoraes
 */
public class CategoriaDAO implements IDAO {
    
    @Override
    public void cadastrar(Object o) throws SQLException {
        
        
            Categoria c = (Categoria)o;
            EntityManager em = FabricaConexao.getConexao().createEntityManager();
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
            em.close();
            
//            String sql = "insert into categoria (nome,descricao) "
//                    + "values (?,?)";
//            PreparedStatement stmt = conn.prepareStatement(sql);
//            // preenche os valores         
//            stmt.setString(1, categoria.getNome());
//            stmt.setString(2, categoria.getDescricao());
//            
//            
//            stmt.executeUpdate();
//            stmt.close();
//            conn.close();
        
    }

     @Override
    public void alterar(Object o) throws SQLException {
        Categoria categoria = (Categoria) o;               
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        em.merge(categoria);
        em.getTransaction().commit();
        em.close();
      
           
    }

     @Override
    public void excluir(Object o) throws SQLException {
        Categoria categoria = (Categoria) o;               
        EntityManager em = FabricaConexao.getConexao().createEntityManager();
        em.getTransaction().begin();
        categoria = em.merge(categoria);
        em.remove(categoria);
        em.getTransaction().commit();
        em.close();
        
    }

     @Override
    public List listarTodos() throws SQLException {
        
        try {
            EntityManager em = FabricaConexao.getConexao().createEntityManager();
            TypedQuery<Categoria> consulta = em.createQuery("SELECT c FROM Categoria c",Categoria.class);
            List<Categoria> categorias = consulta.getResultList();
            em.close();
            return categorias;
                        
        } catch (Exception e) {
            throw new SQLException("Eroo ao tentar listar a categoria. \n" + e.getMessage());
        }
        
    }

     @Override
    public Object listarPorId(int id) throws SQLException {
        Connection conn = null;
        return null;

    }
   
    
}
