package model;


public class Book {

    private String no;
    private String name;
    private String author;

    private String isbn;
    private String description;

    private String lent;
    public Book() {
    }

    public Book(String no, String name, String author, String isbn, String description, String lent) {
        this.no = no;
        this.name = name;
        this.author = author;
        this.isbn = isbn;
        this.description = description;
        this.lent = lent;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLent() {
        return lent;
    }

    public void setLent(String lent) {
        this.lent = lent;
    }
}
