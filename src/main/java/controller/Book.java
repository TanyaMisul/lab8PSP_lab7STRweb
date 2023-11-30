package controller;

public class Book {
    private int book_id;
    private String name;
    private String author;
    private String date;
    private String pages_count;
    private String count;

    public Book() {
    }

    public Book(int book_id, String name, String author, String date, String pages_count, String count) {
        this.book_id = book_id;
        this.name = name;
        this.author = author;
        this.date = date;
        this.pages_count = pages_count;
        this.count = count;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPages_count() {
        return pages_count;
    }

    public void setPages_count(String pages_count) {
        this.pages_count = pages_count;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}
