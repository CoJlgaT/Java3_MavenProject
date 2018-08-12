package lesson2;


import java.sql.*;
import java.util.Scanner;

public class Main {

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String[] args) throws SQLException {

        createTableGoods();
        fillTableGoods();
//        dropTableGoods();


        Scanner scanner = new Scanner(System.in);


    }

    private static void fillTableGoods() throws SQLException {


        try {
            connect();
            stmt.executeUpdate("DELETE FROM goods");
            PreparedStatement ps = connection.prepareStatement("INSERT INTO goods (id, prodid, title, cost) VALUES (?, ?, ?, ?)");
            connection.setAutoCommit(false);
            for (int i = 0; i < 10000; i++) {
                ps.setInt(1, i);
                ps.setInt(2, i);
                ps.setString(3, "товар" + i);
                ps.setInt(4, i);
                ps.addBatch();
            }
            ps.executeBatch();
            connection.setAutoCommit(true);

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

    public static void dropTableGoods() {
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

    public static void createTableGoods() {
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

