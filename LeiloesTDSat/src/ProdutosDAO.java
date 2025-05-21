
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public boolean cadastrarProduto(ProdutosDTO produto) {
    String sql = "INSERT INTO produtos(nome, valor, status) VALUES(?, ?, ?)";

    try {
        conectaDAO dao = new conectaDAO(); 
        Connection conn = dao.conectar(); 

        if (conn == null) {
            throw new Exception("Conexão nula");
        }

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, produto.getNome());
        ps.setInt(2, produto.getValor());
        ps.setString(3, produto.getStatus());
        ps.executeUpdate();

        return true;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Erro, produto não foi cadastrado: " + e.getMessage());
        return false;
    }

}
        
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
}   
    
    
        


