/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.p2.controle;


import br.rj.macae.femass.p2.dao.CategoriaDAO;
import br.rj.macae.femass.p2.entidade.Categoria;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JList;

/**
 *
 * @author YMoraes
 */
public class CategoriaControle {
    
    public void gravar(Categoria r, JList listaCategorias) throws SQLException{
        if(r.getId()<=0){
            cadastrar(r, listaCategorias);
        }else{
            alterar(r, listaCategorias);
        }
    }
    private void cadastrar(Categoria r, JList listaCategorias) throws SQLException{
        CategoriaDAO dao = new CategoriaDAO();
        dao.cadastrar(r);
        List categorias = dao.listarTodos();
        listaCategorias.setListData(categorias.toArray());
    }
    private void alterar(Categoria r, JList listaCategorias) throws SQLException{
        CategoriaDAO dao = new CategoriaDAO();
        dao.alterar(r);
        List categorias = dao.listarTodos();
        listaCategorias.setListData(categorias.toArray());
    }
    public void excluir(Categoria r, JList listaCategorias) throws SQLException{
        CategoriaDAO dao = new CategoriaDAO();
        dao.excluir(r);
        List categorias = dao.listarTodos();
        listaCategorias.setListData(categorias.toArray());
    }
    public void atualizarListaCategorias(JList listaCategorias) throws SQLException{
        CategoriaDAO dao = new CategoriaDAO();        
        List categorias = dao.listarTodos();
        listaCategorias.setListData(categorias.toArray());
    }
    
    
}
