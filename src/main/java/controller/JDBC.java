package controller;

import java.sql.*;
import java.util.ArrayList;

public class JDBC {

    public static Connection connection = null;

    public static Book findBookFromDB(String name, String author) {
        Book Book = new Book();

        try {
            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                if(name.equals(resultSet.getString("name")) && author.equals(resultSet.getString("author"))) {
                    Book.setBook_id(resultSet.getInt("book_id"));
                    Book.setName(resultSet.getString("name"));
                    Book.setAuthor(resultSet.getString("author"));
                    Book.setDate(resultSet.getString("date"));
                    Book.setPages_count(resultSet.getString("pages_count"));
                    Book.setCount(resultSet.getString("count"));
                }
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }

        return Book;
    }

    public static ArrayList<Book> getBooksFromDB() {
        ArrayList<Book> books = new ArrayList<>();
        try {
            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM books";
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                Book book = new Book();
                book.setBook_id(resultSet.getInt("book_id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                book.setDate(resultSet.getString("date"));
                book.setPages_count(resultSet.getString("pages_count"));
                book.setCount(resultSet.getString("count"));
                books.add(book);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
        return books;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
//                System.out.println("Closing connection");
            }
        } catch (SQLException e) {
            System.out.println("Failed to close connection!");
        }
    }

    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
//            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            throw new SQLException();
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost/lab8", "root", "root");
        if (connection == null) {
            throw new SQLException();
        } else {
//            System.out.println("Successfully connected");
        }
    }

    public static ArrayList<User> getUsersFromDB() {
        ArrayList<User> users = new ArrayList<>();
        try {
            JDBC.connect();

            Statement statement = JDBC.connection.createStatement();

            String exampleQuery1 = "SELECT * FROM users";
//            System.out.println("users:");
            ResultSet resultSet = statement.executeQuery(exampleQuery1);

            while (resultSet.next()) {
                User user = new User();
                user.setUser_id(resultSet.getLong("user_id"));
                user.setLogin(resultSet.getString("login"));
                user.setPassword(resultSet.getString("password"));
                user.setRole(resultSet.getString("role"));
                users.add(user);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            JDBC.close();
        }
        return users;
    }
}
