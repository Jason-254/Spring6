package org.example.di;

public class Book {
    private String bname;
    private String author;

    public Book() {
    }

    @Override
    public String toString() {
        return "Book{" +
                "bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public String getBname() {
        return bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public void setBname(String bname) {
        this.bname = bname;
    }


    public Book(String bname, String author) {
        this.bname = bname;
        this.author = author;
    }


}
