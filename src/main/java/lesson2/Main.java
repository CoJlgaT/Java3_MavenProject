package lesson2;


import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;


    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:lesson2_DB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }


}

