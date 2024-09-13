package com.shteydle.top.homeWork11;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

// Класс журнал библиотеки, содержит данные когда взяли книгу, на какой срок. Может распечатать записи журнала, найти должников
public class LibraryJournal {

    private static ArrayList<String[]> journal = new ArrayList<>();
    LocalDate date;
    SimpleDateFormat form = new SimpleDateFormat("MM-dd-YYYY");
    private int period;

    // Когда студент берет книгу, добавляется значение false
    public LibraryJournal(int numberOfBook, int numberOfReadersTicket, int period) {
        date = LocalDate.now();
        String book = Books.getBook(numberOfBook);
        String ticket = ReadersTicket.printInfoStudent(numberOfReadersTicket);
        String dateGet = "Дата выдачи: " + String.valueOf(date);
        String per = "На срок: " + String.valueOf(period) + " дн.";
        String deadline = String.valueOf(date.plusDays(period));
        String[] str = new String[]{book, ticket, dateGet, per, deadline, String.valueOf(false)};
        journal.add(str);
        ReadersTicket.getStudent(numberOfReadersTicket).setHistoryOfRead(book);
    }
    public LibraryJournal(int numberOfBook, int numberOfReadersTicket, int year, int month, int day, int period) {
        date = LocalDate.of(year, month, day);
        String book = Books.getBook(numberOfBook);
        String ticket = ReadersTicket.printInfoStudent(numberOfReadersTicket);
        String dateGet = "Дата выдачи: " + String.valueOf(date);
        String per = "На срок: " + String.valueOf(period) + " дн.";
        String deadline = String.valueOf(date.plusDays(period));
        String[] str = new String[]{book, ticket, dateGet, per, deadline, String.valueOf(false)};
        journal.add(str);
        ReadersTicket.getStudent(numberOfReadersTicket).setHistoryOfRead(book);
    }
// Когда студент возвращает книгу, false переделывается в true
    public LibraryJournal(int numberOfBook, int numberOfReadersTicket) {
        date = LocalDate.now();
        String book = Books.getBook(numberOfBook);
        String ticket = ReadersTicket.printInfoStudent(numberOfReadersTicket);
        String daterecep = "Дата возврата: " + String.valueOf(date);
        String[] str = new String[]{book, ticket, daterecep, "", String.valueOf(true)};
        journal.add(str);
        for(String[] s : journal) {
            if (book.equals(s[0]) && ticket.equals(s[1])) {
                s[s.length - 1] = "true";
            }
        }
    }
// Метод ищет тех, кто не сдал во время книги, выводит данные о студенте и не сданной книге
    public static void printDebtors() {
        LocalDate toNight = LocalDate.now();
        LocalDate deadline;
        for (String[] s : journal) {
            if (s.length == 6) {
                if (s[s.length - 1].equals("false")) {
                    String[] n = s[4].split("-");
                    deadline = LocalDate.of(Integer.parseInt(n[0]), Integer.parseInt(n[1]), Integer.parseInt(n[2]));
                    if (toNight.isAfter(deadline)) {
                        System.out.println(s[1] + " не сдал " + s[0] + " в срок!");
                    }
                }
            }
        }

    }

    // Метод печатает журнал библиотеки на экран
    public static void printJournal() {
        for (String[] s : journal) {
            for (int i = 0; i < s.length - 2; i++) {
                System.out.print(s[i] + "; ");
            }
            System.out.println();
        }
    }
}
