package com.shteydle.top.homeWork11;

// Класс Книги содержит сведения о книгах: автор, название, учетный номер
import java.util.HashMap;

public class Books {
    private int numberOfBook;
    private String autor;
    private String nameOfBook;

    private static HashMap<Integer, String> listOfBooks = new HashMap<>();

    public Books(int numberOfBook, String autor, String nameOfBook) {
        this.numberOfBook = numberOfBook;
        this.autor = autor;
        this.nameOfBook = nameOfBook;
        listOfBooks.put(numberOfBook, autor + ": " + "\"" + nameOfBook + "\"");
    }
    // Распечатать список книг в библиотеке
    public static void printListOfBooks() {
        for (Integer i : listOfBooks.keySet()) {
            String key = i.toString();
            String value = listOfBooks.get(i).toString();
            System.out.println(key + " " + value);
        }
    }
    // Получить сведения о книге
    public static String getBook(int key) {
        return listOfBooks.get(key);
    }

    public int getNumberOfBook() {
        return numberOfBook;
    }

    public void setNumberOfBook(int numberOfBook) {
        this.numberOfBook = numberOfBook;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }
}
