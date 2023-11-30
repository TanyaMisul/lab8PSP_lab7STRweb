<%@ page language="java" contentType="text/html; charset=utf-8"
import="controller.Book"
 import="java.util.ArrayList"
  pageEncoding="utf-8"%>

<html>
<body>
<style>
body {
    font-family: Arial, sans-serif;
    background-color: #9e6eba;
    padding: 20px;
}

h2 {
    text-align: center;
    color: #333;
}

a {
    text-decoration: none;
    color: #5d118a;
}

form {
    width: 500px;
    margin: 0 auto;
    background-color: #fff;
    border: 5px solid #ccc;
    padding: 20px;
    border-radius: 5px;
    box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
}

label {
    display: block;
    margin-bottom: 10px;
    color: #555;
}

input[type="text"],
input[type="date"],
input[type="number"] {
    width: 100%;
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 3px;
    box-sizing: border-box;
    margin-bottom: 20px;
}

input[type="submit"] {
    background-color: #5d118a;
    color: #fff;
    border: none;
    padding: 10px 20px;
    border-radius: 15px;
    cursor: pointer;
    font-size: 16px;
}

input[type="submit"]:hover {
    background-color: #862fba;
}

table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
}

thead th {
    background-color: #5d118a;
    color: #fff;
    padding: 10px;
    text-align: left;
}

tbody td {
    border-bottom: 1px solid #ccc;
    padding: 10px;
}

tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

tbody tr:hover {
    background-color: #eaeaea;
}
</style>

<h2 style="margin-bottom:5px">Admin page</h2>
<a style="display:flex;justify-content:center" href="login">Exit</a><br><br>

<h2>Add new book</h2>
<form action="addBook" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br>

    <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br>

    <label for="date">Date:</label>
    <input type="date" id="date" name="date" required><br>

    <label for="pages_count">Count of pages:</label>
    <input type="number" id="pages_count" name="pages_count" required><br>

    <label for="count">Count:</label>
    <input type="number" id="count" name="count" required><br>

    <input type="submit" value="Add book">
</form>

<table>
        <thead>
            <tr>
                <th>Name</th>
                <th>Author</th>
                <th>Date</th>
                <th>Count of pages</th>
                <th>Count</th>
            </tr>
        </thead>
        <tbody>

            <% ArrayList <Book> books = (ArrayList<Book>)request.getAttribute("books"); %>
            <% for (Book book : books) { %>
                <tr>
                    <td><%= book.getName() %></td>
                    <td><%= book.getAuthor() %></td>
                    <td><%= book.getDate() %></td>
                    <td><%= book.getPages_count() %></td>
                    <td><%= book.getCount() %></td>
                </tr>
            <% } %>
        </tbody>
    </table>

</body>
</html>
