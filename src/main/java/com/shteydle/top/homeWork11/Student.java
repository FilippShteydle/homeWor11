package com.shteydle.top.homeWork11;

import java.util.ArrayList;
// Класс Студент содержит полное имя, группу и историю прочтенных книг
public class Student {

    private String fullName;
    private String idGroup;
    private ArrayList<String> historyOfRead = new ArrayList<>();

    public Student(String fullName, String idGroup) {
        this.fullName = fullName;
        this.idGroup = idGroup;
    }
//Просмотреть историю чтения
    private StringBuilder toStringHistory() {
        StringBuilder his = new StringBuilder();
        for (String a : historyOfRead) {
            his.append(a + "; ");
        }
        return his;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getIdGroup() {
        return idGroup;
    }

    public void setIdGroup(String idGroup) {
        this.idGroup = idGroup;
    }

// Заполнение листа истории
    void setHistoryOfRead(String autor, String book) {
        String str = "автор: " + autor + ", " + book;
        historyOfRead.add(str);
    }
    void setHistoryOfRead(String autorAndBook) {
        historyOfRead.add(autorAndBook);
    }

    @Override
    public String toString() {
        return "Студент: " + fullName + ", группа: " + idGroup + ", история чтения: " + toStringHistory();
    }
}
