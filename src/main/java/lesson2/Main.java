package lesson2;


import java.sql.*;
import java.util.Scanner;

public class Main {

    private static Connection connection;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String[] args) throws SQLException {

//        createTableGoods();
//        fillTableGoods();
//        System.out.println(findCostByTitle("товар666"));
//        System.out.println(changeCostByTitle("товар1", 100));
//        showTitlesFromCostRange(100, 600);
//        dropTableGoods();


        String comand;


        Scanner scanner = new Scanner(System.in);

        comand = scanner.nextLine();
        while (!comand.equals("exit")) {
            if (comand.startsWith("/")) {
                System.out.println("это команда, сейчас я ее проверю");
                processComand(comand);
            } else {
                System.out.println("это не команда, попробуй ещё");
            }
            comand = scanner.nextLine();
        }


    }

    private static void processComand(String comand) throws SQLException {
        String[] tokens = comand.split(" ");
        String firstToken = tokens[0];

        if (comand.equals("/создатьтаблицу")) {
            createTableGoods();
        } else if (comand.equals("/удалитьтаблицу")) {
            dropTableGoods();
        } else if (comand.equals("/заполнитьтаблицу")) {
            fillTableGoods();
        } else if (comand.equals("/очиститьтаблицу")) {
            clearTable();
        } else if (firstToken.equals("/цена") && tokens.length == 2) {
            System.out.println(findCostByTitle(tokens[1]));
        } else if (firstToken.equals("/сменитьцену") && tokens.length == 3) {
            System.out.println(changeCostByTitle(tokens[1], Integer.parseInt(tokens[2])));
        } else if (firstToken.equals("/товарыпоцене") && tokens.length == 3) {
            showTitlesFromCostRange(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
        } else System.out.println("команда неправильная, попробуй ещё");

    }

    private static void showTitlesFromCostRange(int fromCost, int toCost) {

        try {
            connect();
            ResultSet rs = stmt.executeQuery("SELECT title FROM goods WHERE cost BETWEEN " +
                    fromCost + " AND " + toCost);
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }

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


    private static boolean changeCostByTitle(String title, int cost) {
        try {
            connect();
            if (stmt.executeUpdate("UPDATE goods SET cost = " + cost +
                    " WHERE title = \"" + title + "\"") > 0) {
                return true;
            }

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
        return false;
    }

    private static String findCostByTitle(String title) {
        try {
            connect();
            ResultSet rs = stmt.executeQuery("SELECT cost FROM goods WHERE title = \"" + title + "\"");
            return rs.getString(1);

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
        return "Такого товара нет";
    }

    private static void fillTableGoods() throws SQLException {
        try {
            connect();
            stmt.executeUpdate("DELETE FROM goods");
            PreparedStatement ps =
                    connection.prepareStatement("INSERT INTO goods (id, prodid, title, cost) VALUES (?, ?, ?, ?)");
            connection.setAutoCommit(false);
            for (int i = 1; i <= 10000; i++) {
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

    private static void clearTable() throws SQLException {
        try {
            connect();
            stmt.executeUpdate("DELETE FROM goods");
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

