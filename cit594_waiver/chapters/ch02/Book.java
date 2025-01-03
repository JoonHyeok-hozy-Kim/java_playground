package cit594_waiver.chapters.ch02;

import java.util.Comparator;

public class Book implements Comparable<Book> {

    private String title;
    private String author;
    private String isbn;

    public Book(String title, String isbn, String author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Book)) {
            return false;
        }
        Book otherAsBook = (Book) other;
        return isbn.equals(otherAsBook.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public int compareTo(Book other) {
        if (this == other || this.equals(other)) {
            return 0;
        }
        return isbn.compareTo(other.isbn);
    }

    @Override
    public String toString() {
        return String.format("%s (%s), ISBN #%s", title, author, isbn);
    }
}

class BookAuthorComparer implements Comparator<Book> {
    public int compare(Book one, Book two) {
        if (one.getAuthor().equals(two.getAuthor())) {
            return one.getTitle().compareTo(two.getTitle());
        } else {
            return one.getAuthor().compareTo(two.getAuthor());
        }
    }
}

class BookTitleComparer implements Comparator<Book> {
    public int compare(Book one, Book two) {
        if (one.getTitle().equals(two.getTitle())) {
            return one.getAuthor().compareTo(two.getAuthor());
        } else {
            return one.getTitle().compareTo(two.getTitle());
        }
    }
}
