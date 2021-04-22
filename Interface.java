import java.util.Scanner;
import java.util.regex.Pattern;

public class Interface {

    static Scanner in = new Scanner(System.in);

    static String getUserInput(){
        return in.nextLine();
    }

    public static void main(String[] args) {
        UserList users = new UserList();
        User currentUser = new User();
        Pattern pattern1 = Pattern.compile("[1234]");
        Pattern pattern2 = Pattern.compile("[12]");
        Pattern pattern3 = Pattern.compile("[1-9]?[1-9]");
        Pattern pattern4 = Pattern.compile("[1-9]");
        Pattern pattern5 = Pattern.compile("[0-9]{0,9}\\.?[0-9]{0,2}");
        System.out.println("Program księgowa");
        System.out.println("========================");
        String chooseOption;
        do{
            System.out.println("Wybierz co chcesz zrobić");
            System.out.println("1) Dodaj użytkownika");
            System.out.println("2) Pokaż użytkowników");
            System.out.println("3) Wybierz użytkownika");
            System.out.println("4) Zakończ");
            chooseOption = getUserInput();
            if(!pattern1.matcher(chooseOption).matches()){
                System.out.println("Wybierz ponownie");
            }
            if(chooseOption.equals("1")){
                System.out.println("Podaj nazwę użytkownika:");
                String name = getUserInput();
                System.out.println("Podaj sposób rozliczania podatku:\n1) jeśli się rozliczasz liniowo\n2) jeśli się rozliczasz progresywnie");
                String isLinear;
                do{
                    isLinear = getUserInput();
                    if(!pattern2.matcher(isLinear).matches()){
                        System.out.println("Wybierz ponownie");
                    }
                }
                while(!pattern2.matcher(isLinear).matches());
                users.addUser(name, isLinear.equals("1"));
            }
            if(chooseOption.equals("2")){
                if(users.isArrayListUsersEmpty()){
                    System.out.println("Brak użytkowników. Najpierw dodaj użytkownika.");
                }
                else users.getUsers();
            }
            if(chooseOption.equals("3")){
                String chooseUser;
                if(users.isArrayListUsersEmpty()){
                    System.out.println("Brak użytkowników. Najpierw dodaj użytkownika.");
                }
                else {
                    users.getUsers();
                    do {
                        System.out.println("Wybierz numer użytkownika:");
                        chooseUser = getUserInput();
                        if(!pattern3.matcher(chooseUser).matches()){
                            System.out.println("Wybierz ponownie");
                        }
                        else if(Integer.parseInt(chooseUser) > users.getSize()){
                            System.out.println("Nie ma użytkownika o takim numerze. Wybierz ponownie.");
                        }
                        else{
                            currentUser = users.chooseUser(Integer.parseInt(chooseUser));
                        }
                    }
                    while(!pattern3.matcher(chooseUser).matches()||Integer.parseInt(chooseUser) > users.getSize());

                    String chooseOption2;
                    do{
                        users.introduceUser(Integer.parseInt(chooseUser));
                        System.out.println("1) dodaj przychód");
                        System.out.println("2) dodaj koszt");
                        System.out.println("3) dodaj ZUS");
                        System.out.println("4) sprawdź przychody");
                        System.out.println("5) sprawdź koszty");
                        System.out.println("6) sprawdź podatki");
                        System.out.println("7) usuń przychód");
                        System.out.println("8) usuń koszt");
                        System.out.println("9) wróć");
                        chooseOption2 = getUserInput();
                        if(!pattern4.matcher(chooseOption2).matches()){
                            System.out.println("Wybierz ponownie");
                        }
                        else if(chooseOption2.equals("1")){
                            System.out.println("podaj nazwę przychodu");
                            String incomeName = getUserInput();
                            String incomeValue;
                            do{
                                System.out.println("podaj wysokość przychodu");
                                incomeValue = getUserInput();
                                if(!pattern5.matcher(incomeValue).matches()){
                                    System.out.println("Podaj liczbę");
                                }
                            }
                            while(!pattern5.matcher(incomeValue).matches());
                            currentUser.addIncome(incomeName, Double.parseDouble(incomeValue));
                        }
                        else if(chooseOption2.equals("2")){
                            System.out.println("podaj nazwę kosztu");
                            String costName = getUserInput();
                            String costValue;
                            do{
                                System.out.println("podaj wysokość kosztu");
                                costValue = getUserInput();
                                if(!pattern5.matcher(costValue).matches()){
                                    System.out.println("Podaj liczbę");
                                }
                            }
                            while(!pattern5.matcher(costValue).matches());
                            String isCarExpense;
                            System.out.println("Czy koszt jest związany z samochodem?");
                            System.out.println("1) TAK");
                            System.out.println("2) NIE");
                            do{
                                isCarExpense = getUserInput();
                                if(!pattern2.matcher(isCarExpense).matches()){
                                    System.out.println("Wybierz ponownie");
                                }
                            }
                            while(!pattern2.matcher(isCarExpense).matches());
                            currentUser.addCost(costName, Double.parseDouble(costValue), isCarExpense.equals("1"));
                        }
                        else if(chooseOption2.equals("3")){
                            String healthValue;
                            do{
                                System.out.println("Podaj wysokość składki zdrowotnej");
                                healthValue = getUserInput();
                                if(!pattern5.matcher(healthValue).matches()){
                                    System.out.println("Podaj liczbę");
                                }
                            }
                            while(!pattern5.matcher(healthValue).matches());
                            String socialValue;
                            System.out.println("Podaj wysokość składek społecznych");
                            do{
                                socialValue = getUserInput();
                                if(!pattern5.matcher(socialValue).matches()){
                                    System.out.println("Podaj liczbę");
                                }
                            }
                            while(!pattern5.matcher(socialValue).matches());
                            currentUser.addZUS(Double.parseDouble(healthValue), true);
                            currentUser.addZUS(Double.parseDouble(socialValue), false);
                        }
                        else if(chooseOption2.equals("4")){
                            currentUser.getIncomes();
                        }
                        else if(chooseOption2.equals("5")){
                            currentUser.getCosts();
                        }
                        else if(chooseOption2.equals("6")){
                            currentUser.calculateTax();
                            currentUser.calculateVAT();
                        }
                        else if(chooseOption2.equals("7")){
                            System.out.println("podaj nazwę przychodu, który chcesz usunąć");
                            String incomeName = getUserInput();
                            currentUser.removeIncome(incomeName);
                        }
                        else if(chooseOption2.equals("8")){
                            System.out.println("podaj nazwę kosztu, który chcesz usunąć");
                            String costName = getUserInput();
                            currentUser.removeCost(costName);
                        }
                    }
                    while(!chooseOption2.equals("9"));
                }
            }
        }
        while(!chooseOption.equals("4"));

    }
}
