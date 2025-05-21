
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class conectaDAO {
    
   private Connection conn;

    public Connection getConn() {
        return conn;
    }

   

    public Connection conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11", "root", "rfgrz1515");
            System.out.println("Conexão estabelecida com sucesso!");
            return conn; 
        } catch (ClassNotFoundException ex) {
            System.out.println("O Driver não está disponível na biblioteca.");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar ao banco de dados: " + ex.getMessage());
        }
        return null;
    }
     public Statement criarStatement() {
        if (conn == null) {
            System.out.println("A conexão ainda não foi estabelecida.");
            return null;
        }
        try {
            Statement stmt = (Statement) conn.createStatement();
            System.out.println("Pronto para execução de comandos SQL.");
            return stmt;
        } catch (SQLException sqle) {
            System.out.println("Erro no acesso ao Banco de Dados: " + sqle.getMessage());
            return null;
        }
    
}
}
