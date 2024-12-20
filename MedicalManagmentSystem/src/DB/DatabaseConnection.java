package DB;
import com.sun.source.util.DocTrees;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;


public class DatabaseConnection {
    
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=MedicalClinic;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "sa";
    private static final String PASSWORD = "12345";
    private static Connection connection;
    private static DatabaseConnection instance;
    
    private DatabaseConnection (){
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            System.out.println("Database connection established!");
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static DatabaseConnection getInstance(){
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
    
    public void test(){
        String query = "INSERT INTO users (Username, Password, Role) VALUES (?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "test");
            preparedStatement.setString(2, "test");
            preparedStatement.setString(3, "test");
            preparedStatement.setInt(4, 1);
            preparedStatement.setString(5, "test");
            preparedStatement.setInt(6, 1);

            int rowsInserted = preparedStatement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("true");;
            } else {
                System.out.println("flase");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
