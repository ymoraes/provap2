/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rj.macae.femass.p2.controle;


import br.rj.macae.femass.p2.dao.ImovelDAO;
import br.rj.macae.femass.p2.dao.TipoDAO;
import br.rj.macae.femass.p2.entidade.Imovel;
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
public class ImovelControle{
    public void gravar(Imovel c)throws SQLException{
        ImovelDAO dao = new ImovelDAO();
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
        ImovelDAO dao = new ImovelDAO();
        List clientes = dao.listarTodos();

        //Adiciona as linhas
        for (Object o : clientes){
            Imovel c = (Imovel) o;
            
            model.addRow(new Object[]{c.getId(),c.getNome(),c.getDescricao(),c.getAreaconst(),c.getAreatotal(),c.getTipo()});
            
        }
        
        
    }

    public Imovel getImovelPorId(int id) throws SQLException {
        ImovelDAO dao = new ImovelDAO();
        Imovel c = (Imovel)dao.listarPorId(id);
        return c;       
    }
    
    public List listarTipo() throws SQLException {
        TipoDAO dao = new TipoDAO();
        return dao.listarTodos();
    }
}
