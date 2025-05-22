
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;


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
        
    public ArrayList<ProdutosDTO> listarProdutos() {
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    String sql = "SELECT * FROM produtos";

    try {
        conectaDAO dao = new conectaDAO();
        Connection conn = dao.conectar();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            ProdutosDTO produto = new ProdutosDTO();
            produto.setId(rs.getInt("id"));
            produto.setNome(rs.getString("nome"));
            produto.setValor(rs.getInt("valor"));
            produto.setStatus(rs.getString("status"));
            listagem.add(produto);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
    }

    return listagem;
}
}   
    
    
        


