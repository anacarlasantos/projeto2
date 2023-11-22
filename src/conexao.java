import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexao {

    // Definição das informações de conexão com o banco de dados
    private static final String USUARIO = "root";                // Nome de usuário do banco de dados
    private static final String SENHA = "1234";                  // Senha de acesso ao banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/Estoque";
    // URL de conexão com o banco de dados (no caso, MySQL)

    private static Connection adega = null;  // Inicializa uma conexão nula

    // Método para abrir uma conexão com o banco de dados
    public static Connection abrir() {
        try {
            // Verifica se a conexão já está aberta ou se está fechada
            if (adega == null || adega.isClosed()) {
                // Se a conexão estiver nula ou fechada, cria uma nova conexão
                adega = DriverManager.getConnection(URL, USUARIO, SENHA);
            }
            // Retorna a conexão (pode ser uma nova ou a existente)
            return adega;
        } catch (SQLException e) {
            // Em caso de exceção (erro), imprime o erro e retorna nulo
            e.printStackTrace();
            return null;
        }
    }

    // Método para fechar a conexão com o banco de dados
    public static void fechar() {
        try {
            // Verifica se a conexão não é nula e se não está fechada
            if (adega != null && !adega.isClosed()) {
                // Se a conexão estiver aberta, fecha-a
                adega.close();
            }
        } catch (SQLException e) {
            // Em caso de exceção (erro), imprime o erro
            e.printStackTrace();
        }
    }
}

