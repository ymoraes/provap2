/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.p2.controle;


import br.rj.macae.femass.p2.dao.TipoDAO;
import br.rj.macae.femass.p2.entidade.Tipo;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Ymoraes
 */
public class TipoControle{
    public void gravar(Tipo c)throws SQLException{
        TipoDAO dao = new TipoDAO();
        try{
        if(c.getId()==null || c.getId()<=0)
            dao.cadastrar(c);
        else
            dao.alterar(c);
        }catch(SQLException ex){
            throw new SQLException("Erro ao salvar as informações: \n"+ex.getMessage());
        }
    }

  
    public void atualizarLista(JTable tabela) throws SQLException{
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        TableColumnModel modeloDaColuna = tabela.getColumnModel();
        modeloDaColuna.getColumn(0).setMaxWidth(25);

        //limpa as linhas da tabela.
        model.setNumRows(0);
        TipoDAO dao = new TipoDAO();
        List clientes = dao.listarTodos();

        //Adiciona as linhas
        for (Object o : clientes){
            Tipo c = (Tipo) o;
            
            model.addRow(new Object[]{c.getId(),c.getNome(),c.getDescricao()});
            
        }
        
        
    }

    public Tipo getCategoriaPorId(int id) throws SQLException {
        TipoDAO dao = new TipoDAO();
        Tipo c = (Tipo)dao.listarPorId(id);
        return c;       
    }
}
