package lesson2;


import java.sql.*;

public class Main {

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String[] args) {

//        createTableGoods();
        dropTableGoods();

    }

    public static void dropTableGoods(){
        try {
            connect();
            stmt.executeUpdate("DROP TABLE goods");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void createTableGoods(){
        try {
            connect();
            stmt.executeUpdate("CREATE TABLE goods (\n" +
                    "    id     INTEGER     PRIMARY KEY,\n" +
                    "    prodid INTEGER     UNIQUE,\n" +
                    "    title  STRING (50),\n" +
                    "    cost   INTEGER\n" +
                    ");\n");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                disconnect();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:lesson2_DB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() throws SQLException {
        connection.close();
    }


}

