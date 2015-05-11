import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    public static Connection getConnection() {
        Connection con = null;
        Properties props = new Properties();
        InputStream fis = null;

        try {
            fis = DBConnection.class.getResourceAsStream("db.properties");
            props.load(fis);

            // load the Driver Class
            Class.forName(props.getProperty("DB_DRIVER_CLASS"));

            // create the connection now
            String dbURL = props.getProperty("DB_URL");
            String username = props.getProperty("DB_USERNAME");
            String password = props.getProperty("DB_PASSWORD");

            con = DriverManager.getConnection(dbURL, username, password);
        } catch (IOException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
