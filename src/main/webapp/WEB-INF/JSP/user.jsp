<%@ page language="java" contentType="text/html; charset=utf-8"
import="controller.Book"
 import="java.util.ArrayList"
  pageEncoding="utf-8"%>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #9e6eba;
            padding: 150px;
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
            width: 300px;
            margin: 0 auto;
            background-color: #fff;
            border: 1px solid #ccc;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: inline-block;
            vertical-align: top;
        }

        label {
            display: block;
            margin-bottom: 10px;
            color: #555;
        }

        input[type="text"] {
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

        .book-info {
            display: inline-block;
            vertical-align: top;
            margin-left: 20px;
            padding: 10px;
            background-color: #f9f9f9;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .book-info h5 {
            margin-bottom: 10px;
            color: #333;
        }
    </style>
</head>
<body>
<h2 style="margin-bottom:5px">User page</h2>
<a style="display:flex;justify-content:center" href="login">Exit</a><br><br>

<div class="book-form" style="display: inline-block;">
    <h2>View book</h2>
    <form action="userViewBook" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="author">Author:</label>
        <input type="text" id="author" name="author" required><br>

        <input type="submit" value="Find book">
    </form>
</div>

<div class="book-info" style="width:750px;height:230px;margin-top:68px">
    <% Book book = (Book)request.getAttribute("book"); %>
    <% if(book != null ){ %>
            <h5>Name: <%= book.getName() %></h5>
            <h5>Author: <%= book.getAuthor() %></h5>
            <h5>Date: <%= book.getDate() %></h5>
            <h5>Count of pages: <%= book.getPages_count() %></h5>
            <h5>Count: <%= book.getCount() %></h5>
    <% } %>
</div>

</body>
</html>
