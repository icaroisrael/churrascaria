package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Produto;

/**
 *
 * @author Israel
 */
public class ProdutoDAO extends ExecuteSQL{
    public ProdutoDAO(Connection con){
        super(con);
    }
    
    public String salvar(Produto produto){
        String sql = "INSERT INTO PRODUTO VALUES(0,?)";
        try {
            PreparedStatement ps = getCon().prepareStatement(sql);            
            ps.setString(1, produto.getDescricao());
            if(ps.executeUpdate() > 0){
                return "Produto Inserido com sucesso";
            }else{
                return "Erro ao Inserir";
            }
        } catch (SQLException e) {
            return e.getMessage();
        }
    }
    
}
