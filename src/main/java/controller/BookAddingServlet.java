package controller;

import java.sql.*;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import static java.lang.Integer.parseInt;

public class BookAddingServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Book> books = JDBC.getBooksFromDB();
        req.setAttribute("books", books);
        req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String author = req.getParameter("author");
        String date = req.getParameter("date");
        String pages_count = req.getParameter("pages_count");
        String count = req.getParameter("count");


        ArrayList<Book> books = JDBC.getBooksFromDB();
        int id = 1;
        for (Book book : books) {
            if (book.getName().equals(name) && book.getAuthor().equals(author) && book.getDate().equals(date) && book.getPages_count().equals(pages_count) && book.getCount().equals(count)) {
                req.getRequestDispatcher("WEB-INF/JSP/admin.jsp").forward(req, resp);
            }
            else {
                id++;
            }
        }
        insertBook(id, name, author, date, pages_count, count);
        resp.sendRedirect("/lab8/addBook");
    }

    public void insertBook(int bookId, String name, String author, String date, String pages_count, String count) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/lab8", "root", "root");
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO books (book_id, name, author, date, pages_count, count) VALUES (?, ?, ?, ?, ?, ?)")) {


            statement.setLong(1, bookId);
            statement.setString(2, name);
            statement.setString(3, author);
            statement.setString(4, date);
            statement.setString(5, pages_count);
            statement.setString(6, count);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
