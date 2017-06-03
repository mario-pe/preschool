package utils.listenres; /**
 * Created by mario on 28.05.2017.
 */

import dao.GrupaDao;
import dao.PersonDao;
import dao.PracownikDao;
import dao.ZajeciaDao;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebListener()
public class DBConfig implements ServletContextListener{
    private static Connection connection;
    // Public constructor is required by servlet spec
    public DBConfig() {

    }

    public static Connection getConnection() {
        try {
            Driver driver = new com.mysql.jdbc.Driver();
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/przedszkole?user=root&password=root");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        connection = getConnection();

        PersonDao personDao = new PersonDao(connection);
        GrupaDao grupaDao = new GrupaDao(connection);
        PracownikDao pracownikDao = new PracownikDao(connection);
        ZajeciaDao zajeciaDao = new ZajeciaDao(connection);

        sc.setAttribute("personDao", personDao);
        sc.setAttribute("grupaDao", grupaDao);
        sc.setAttribute("pracownikDao", pracownikDao);
        sc.setAttribute("zajeciaDao", zajeciaDao);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}