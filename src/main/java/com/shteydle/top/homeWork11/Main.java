package com.shteydle.top.homeWork11;

/*В библиотеке решили автоматизировать учет книг, выданных студентам.
Студент, для того чтобы получить книгу, должен получить читательский билет, если не получал ранее. В читательском
билете содержится информация:
■ номер билета;
■ фамилия и имя студента;
■ номер группы.
При выдаче книги библиотекарь фиксирует в журнале:
■ название и автора книги;
■ номер билета, на который выдана книга;
■ дата выдачи;
■ на какое время выдана книга (в сутках).
При приеме книги библиотекарь фиксирует в журнале:
■ название и автора книги;
■ номер билета студента, который вернул книгу;
■ дата возврата.
Разработать модель программы, которая бы позволила находить должников (студентов, которые не сдали книгу вовремя).*/

public class Main {

    public static void main(String[] args) {

        // Создание студента
        Student s1 = new Student("Богдан Иван", "Д-12");
        Student s2 = new Student("Михайлов Максим", "З-54");
        Student s3 = new Student("Лызик Дмитрий", "Л-24");
        Student s4 = new Student("Панков Павел", "Д-13");
        Student s5 = new Student("Абаев Константин", "Л-41");
        // Создание билета + создание студента
        ReadersTicket r1 = new ReadersTicket(1024, "Иванов Иван", "Б-13");
        ReadersTicket r2 = new ReadersTicket(1025, "Петров Петр", "А-11");
        //Создание билета по готовому студенту
        ReadersTicket r3 = new ReadersTicket(1026, s1);
        ReadersTicket r4 = new ReadersTicket(1027, s2);
        ReadersTicket r5 = new ReadersTicket(1028, s3);
        ReadersTicket r6 = new ReadersTicket(1029, s4);
        ReadersTicket r7 = new ReadersTicket(1030, s5);

        // Создание списка книг
        Books b1 = new Books(1, "Толстой Л.Н.", "Война и мир");
        Books b2 = new Books(2, "Достоевский Ф.М.", "Идиот");
        Books b3 = new Books(3, "Маркс К.", "Капитал");
        Books b4 = new Books(4, "Конан Дойл А.", "Шерлок Холмс");
        Books b5 = new Books(5, "Роулинг Дж.", "Гарри Поттер");
        Books b6 = new Books(6, "Кинг С.", "Зеленая миля");
        Books b7 = new Books(7, "Толкиен Дж.", "Властелин Колец");
        Books b8 = new Books(8, "Дюма А", "Граф Монте Кристо");
        Books b9 = new Books(9, "Мартин Дж.", "Песнь льда и пламени");
        Books b0 = new Books(10, "Фадеев А.", "Молодая Гвардия");
        Books b11 = new Books(11, "Васильев Б.", "А зори здесь тихие");
        Books b12 = new Books(12, "Кинг С.", "Побег из Шоушенка");
        Books b13 = new Books(13, "Ильф И., Петров Е.", "Двенадцать стульев");
        Books b14 = new Books(14, "Беляев А.", "Старая крепость");

        //Заполнение истории прочтения книг, при создании журнала книга так же записывается в историю
        s1.setHistoryOfRead(Books.getBook(5));
        s1.setHistoryOfRead(Books.getBook(1));
        s1.setHistoryOfRead(Books.getBook(2));

        //Печать истории прочтения до создания журнала
        System.out.println(s1.toString());

        LibraryJournal j1 = new LibraryJournal(2, 1024, 5);
        LibraryJournal j2 = new LibraryJournal(1, 1024, 7);
        LibraryJournal j3 = new LibraryJournal(4, 1026, 3);
        LibraryJournal j4 = new LibraryJournal(2, 1025);
        LibraryJournal j5 = new LibraryJournal(4, 1024, 3);
        LibraryJournal j6 = new LibraryJournal(2, 1024);
        LibraryJournal j7 = new LibraryJournal(12, 1026, 2024, 8, 23, 10);
        //Печать истории после создания журнала
        System.out.println(s1.toString());
        // Поиск должников
        LibraryJournal.printDebtors();
        // Создание записи о сдачи книги
        LibraryJournal j8 = new LibraryJournal(12, 1026);
        // Повторный поиск должников
        LibraryJournal.printDebtors();
        // Печать истории прочтения
        System.out.println(s1.toString());
        // Печать всего журнала библиотеки
        LibraryJournal.printJournal();
    }
}
