package utils;

public class InfoPrinter {

    public void mainMenu(){
        System.out.println("Wybierz co chcesz zrobić");
        System.out.println("1) Dodaj użytkownika");
        System.out.println("2) Pokaż użytkowników");
        System.out.println("3) Wybierz użytkownika");
        System.out.println("4) Zakończ");
    }

    public void greetings(){
        System.out.println("Program księgowa");
        System.out.println("========================");
    }

    public void userMenu(){
        System.out.println("1) dodaj przychód");
        System.out.println("2) dodaj koszt");
        System.out.println("3) dodaj ZUS");
        System.out.println("4) sprawdź przychody");
        System.out.println("5) sprawdź koszty");
        System.out.println("6) sprawdź podatki");
        System.out.println("7) usuń przychód");
        System.out.println("8) usuń koszt");
        System.out.println("9) wróć");
    }
}
