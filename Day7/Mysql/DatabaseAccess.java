import java.sql.*;
public class DatabaseAccess {
    private String dbHost = "jdbc:mysql://localhost:3306";
    private String dbName = "java";
    private String dbUser = "root";
    private String dbPassword = "";
    private Connection connection;

    public DatabaseAccess(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbHost + "/" + dbName, dbUser, dbPassword);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public void close(){
        try {
            connection.close();
        } catch (SQLException e) {
            System.out.println("Failed to close the connection");
        }
    }
    public Connection getConnection(){
        return connection;
    }
}
