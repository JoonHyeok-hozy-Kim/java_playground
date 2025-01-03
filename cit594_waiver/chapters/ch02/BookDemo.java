package cit594_waiver.chapters.ch02;

import java.util.Set;
import java.util.TreeSet;

public class BookDemo {
    public static void main(String[] args) {
        Book homeMR = new Book("Home", "238942398", "Marilynne Robinson");
        Book homeTM = new Book("Home", "923402393", "Toni Morrison");
        Book things = new Book("Things to Come and Go", "28423892", "Bette Howland");

        Set<Book> defaultOrder = new TreeSet<>();
        defaultOrder.add(homeMR);
        defaultOrder.add(homeTM);
        defaultOrder.add(things);
        System.out.printf("DEFAULT ORDER (compareTo):%n%s%n", defaultOrder);

        Set<Book> titleOrder = new TreeSet<>(new BookTitleComparer());
        titleOrder.add(homeMR);
        titleOrder.add(homeTM);
        titleOrder.add(things);
        System.out.printf("TITLE ORDER (compareTo):%n%s%n", titleOrder);

        Set<Book> authorOrder = new TreeSet<>(new BookAuthorComparer());
        authorOrder.add(homeMR);
        authorOrder.add(homeTM);
        authorOrder.add(things);
        System.out.printf("AUTHOR ORDER (compareTo):%n%s%n", authorOrder);


    }
}
