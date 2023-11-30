package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class UserBookViewerServlet extends HttpServlet {

    private String name = "name";
    private String author = "author";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = JDBC.findBookFromDB(name, author);
        req.setAttribute("book", book);
        req.getRequestDispatcher("WEB-INF/JSP/user.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        name = req.getParameter("name");
        author = req.getParameter("author");

        resp.sendRedirect("/lab8/userViewBook");
    }

}
