package com.shteydle.top.homeWork11;

import java.util.HashMap;

// Класс Читательский Билет содержит список номеров билетов
public class ReadersTicket {
    private int ticketsNumber;
    private static HashMap<Integer, Student> listOfTickets = new HashMap<>();

// Создается читательский билет, параллельно создается Студент
    public ReadersTicket(int ticketsNumber, String fullName, String idGroup) {
        this.ticketsNumber = ticketsNumber;
        Student student = new Student(fullName, idGroup);
        listOfTickets.put(ticketsNumber, student);
    }
    public ReadersTicket(int ticketsNumber, Student student) {
        this.ticketsNumber = ticketsNumber;
        listOfTickets.put(ticketsNumber, student);
    }

// Создается читательский билет
    public static void printInfo(){
        for (Integer i : listOfTickets.keySet()) {
            String key = i.toString();
            String value = listOfTickets.get(i).toString();
            System.out.println(key + " " + value);
        }
    }

    // Получить информацию о студенте (полное имя, группа)
    public static Student getStudent(int key) {
        Student student = listOfTickets.get(key);
        return student;
    }
    // Распечатать данные о читательском билете
    public static String printInfoStudent(int key) {
        return ("Номер билета: " + key + ", " + listOfTickets.get(key).getFullName() + ", " + listOfTickets.get(key).getIdGroup());
    }
}
