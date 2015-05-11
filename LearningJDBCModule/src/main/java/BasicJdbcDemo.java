import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * A sample program that demonstrates how to execute SQL SELECT statement
 * using JDBC.
 *
 *
 * The program is really simple, first we are reading database configuration details from the property file and then loading
 * the JDBC driver and using DriverManager to create the connection. Notice that this code use only Java JDBC API classes and
 * there is no way to know that it’s connecting to which type of database
 *
 * http://www.journaldev.com/2471/jdbc-example-tutorial-drivers-connection-statement-resultset
 */
public class BasicJdbcDemo {

    public static void main(String[] args) {

        try (Connection conn = DBConnection.getConnection()) {

            String sql = "SELECT * FROM Users";

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);

            int count = 0;

            while (result.next()){
                String name = result.getString(2);
                String pass = result.getString(3);
                String fullname = result.getString("fullname");
                String email = result.getString("email");

                String output = "User #%d: %s - %s - %s - %s";
                System.out.println(String.format(output, ++count, name, pass, fullname, email));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }


}