import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.*;


public class TestTask3 {

    private static Connection connection;
    private static Statement stmt;
    private static int maxID;

    @Before
    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:lesson6_DB.db");
        stmt = connection.createStatement();
        maxID = stmt.executeQuery("SELECT MAX(id) FROM students").getInt(1);
    }

    @Test
    public void TestSelect() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        Assert.assertTrue(rs.next() == true);
    }

    @Test
    public void TestSelect1() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students WHERE id = 4");
        Assert.assertFalse(rs.next() == true);
    }

    @Test
    public void TestInsertRemove() throws SQLException {
        Assert.assertTrue(stmt.executeUpdate("INSERT INTO students VALUES(" + (maxID + 1) + ", 'romanoff_test_qwerty', 500)")==1);
        Assert.assertTrue(stmt.executeUpdate("DELETE FROM students WHERE id = " + maxID)==1);
    }

    @Test
    public void TestInsert() throws SQLException {
        Assert.assertTrue(stmt.executeUpdate("INSERT INTO students VALUES(" + (maxID + 1) + ", 'romanoff_test_qwerty', 500)")==1);

    }

    @Test
    public void TestDeleteAll() throws SQLException {

        Assert.assertFalse(stmt.executeUpdate("DELETE FROM students WHERE family = 'romanoff_test_qwerty'")==0);

    }


    @After
    public void disconnect() throws SQLException {
        connection.close();
    }
}
