import java.sql.*;
import javax.swing.JOptionPane;

public class koneksiDatabase {
    private static java.sql.Connection conn;
    
    public static java.sql.Connection getKoneksi()
    {
        if (conn == null) {
            try {
                String url = "jdbc:mysql://localhost:3306/rpl";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi Berhasil");
        } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e);
        }
        } 
        return conn;
    }
    
    public static void main(String[] args) {
        getKoneksi();
    }
}
