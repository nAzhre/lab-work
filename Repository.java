package com.example.demo7.Repository;

import com.example.demo7.Items;
import com.example.demo7.Persons;

import javax.ejb.Stateful;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Stateful
public class Repository {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "";
    static final String PASS = "";

//    public static List<Persons> getAllPersons() throws SQLException, ClassNotFoundException {
//        Connection conn = null;
//        Statement stmt = null;
//        List<Persons> persons = new ArrayList<>();
//        // STEP 1: Register JDBC driver
//        Class.forName(JDBC_DRIVER);
//        System.out.println("repository is ");
//
//        // STEP 2: Open a connection
//        System.out.println("Connecting to database...");
//        conn = DriverManager.getConnection(DB_URL, USER, PASS);
//
//        // STEP 3: Execute a query
//        System.out.println("Connected database successfully...");
//        stmt = conn.createStatement();
//        String sql = "SELECT * FROM PERSON";
//        ResultSet rs = stmt.executeQuery(sql);
//
//        // STEP 4: Extract data from result set
//        while (rs.next()) {
//            // Retrieve by column name
//            LocalDate birth = rs.getDate("BIRTHDAY");
//            BigDecimal balance = rs.getBigDecimal("BALANCE");
//            Persons persons1 = new Persons(birth,balance);
//            persons.add(persons1);
//        }
//        // STEP 5: Clean-up environment
//        rs.close();
//
//        return persons;
//    }

    public static List<Items> getAllItems() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        List<Items> allItems = new ArrayList<>();
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);
        System.out.println("repository is ");

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // STEP 3: Execute a query
        System.out.println("Connected database successfully...");
        stmt = conn.createStatement();
        String sql = "SELECT * FROM ITEMS";
        ResultSet rs = stmt.executeQuery(sql);

        // STEP 4: Extract data from result set
        while (rs.next()) {
            // Retrieve by column name
            int id  = rs.getInt("ID");
            String name = rs.getString("NAME");
            int price = rs.getInt("PRICE");
            int amount = rs.getInt("AMOUNT");
            Items items = new Items(id,name,price,amount);
            allItems.add(items);
        }
        // STEP 5: Clean-up environment
        rs.close();

        return allItems;
    }
    public static String addItems(Items items) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        String phrase="";
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);
        System.out.println("repository is ");

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // STEP 3: Execute a query
        System.out.println("Connected database successfully...");
        String sql = "INSERT INTO ITEMS (ID,NAME,PRICE,AMOUNT) VALUES (?,?,?,?)";
        PreparedStatement PreparedStatement = conn.prepareStatement(sql);
        PreparedStatement.setInt(1, items.getId());
        PreparedStatement.setString(2, items.getName());
        PreparedStatement.setInt(3, items.getPrice());
        PreparedStatement.setInt(4, items.getAmount());

        PreparedStatement.executeUpdate();
        PreparedStatement.close();

        phrase = "Inserted records into the table...";

        conn.close();

        return phrase;
    }
    public static String updateItemsById(Items items) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);
        System.out.println("repository is ");

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // STEP 3: Execute a query
        System.out.println("Connected database successfully...");
        String sql = "UPDATE ITEMS set NAME=?, PRICE=?, AMOUNT=? where ID =?";
        PreparedStatement PreparedStatement1 = conn.prepareStatement(sql);
        PreparedStatement1.setString(1, items.getName());
        PreparedStatement1.setDouble(2, items.getPrice());
        PreparedStatement1.setInt(3, items.getAmount());
        PreparedStatement1.setInt(4, items.getId());
        PreparedStatement1.executeUpdate();
        PreparedStatement1.close();

        conn.close();
        return "Product info is updated";
    }
    public static String deleteItemsById(Items items) throws SQLException, ClassNotFoundException {
        Connection conn = null;
        Statement stmt = null;
        // STEP 1: Register JDBC driver
        Class.forName(JDBC_DRIVER);
        System.out.println("repository is ");

        // STEP 2: Open a connection
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);

        // STEP 3: Execute a query
        System.out.println("Connected database successfully...");
        String sql = "delete from ITEMS where ID =?";
        PreparedStatement PreparedStatement1 = conn.prepareStatement(sql);
        PreparedStatement1.setInt(1, items.getId());
        PreparedStatement1.executeUpdate();
        PreparedStatement1.close();

        conn.close();
        return "Product is deleted";
    }
}