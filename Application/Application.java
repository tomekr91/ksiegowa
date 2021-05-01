package Application;

import businessLogic.UserCostHandler;
import businessLogic.UserHandler;
import model.User;
import utils.InfoPrinter;
import utils.InputHandler;

import java.math.BigDecimal;
import java.util.Scanner;

public class Application {
    User currentUser = new User();
    UserCostHandler userCostHandler = new UserCostHandler();
    UserHandler userHandler = new UserHandler();
    InfoPrinter infoPrinter = new InfoPrinter();
    InputHandler inputHandler = new InputHandler();
    static Scanner in = new Scanner(System.in);

    static String getUserInput(){
        return in.nextLine();
    }

    public void addUser(){
        System.out.println("Podaj nazwę użytkownika:");
        String name = getUserInput();
        System.out.println("Podaj sposób rozliczania podatku:\n1) jeśli się rozliczasz liniowo\n2) jeśli się rozliczasz progresywnie");
        boolean isLinear = inputHandler.getBooleanInput();
        userHandler.addUser(name, isLinear);
        run();
    }

    public void showUsers(){
        if(userHandler.isUserListEmpty()){
            System.out.println("Brak użytkowników. Najpierw dodaj użytkownika.");
        }
        else userHandler.getUsers();
        run();
    }

    public void chooseUser(){
        if(userHandler.isUserListEmpty()){
            System.out.println("Brak użytkowników. Najpierw dodaj użytkownika.");
            run();
        }
        else {
            userHandler.getUsers();
            String chooseUser = inputHandler.chooseUserInput();
            if(Integer.parseInt(chooseUser) > userHandler.getSize()){
                System.out.println("Nie ma użytkownika o takim numerze. Wybierz ponownie.");
                chooseUser();
            }
            else{
                currentUser = userHandler.chooseUser(Integer.parseInt(chooseUser));
                userMenu();
            }
        }
    }

    public void userMenu(){
        infoPrinter.userMenu();
        String chooseOption2 = inputHandler.chooseUserMenuInput();
        if (chooseOption2.equals("1"));
        if (chooseOption2.equals("2"));
        if (chooseOption2.equals("3"));
        if (chooseOption2.equals("4"));
        if (chooseOption2.equals("5"));
        if (chooseOption2.equals("6"));
        if (chooseOption2.equals("7"));
        if (chooseOption2.equals("8"));
    }

    public void run(){
        infoPrinter.mainMenu();
        String chooseOption = inputHandler.chooseMenuInput();
        if(chooseOption.equals("1")) addUser();
        if(chooseOption.equals("2")) showUsers();
        if(chooseOption.equals("3")) {
            chooseUser();
        }
        /*
        {
                do{
                    userHandler.introduceUser(Integer.parseInt(chooseUser));

                    chooseOption2 = getUserInput();
                    if(!secondMenuPattern.matcher(chooseOption2).matches()){
                        System.out.println("Wybierz ponownie");
                    }
                    else if(chooseOption2.equals("1")){
                        System.out.println("podaj nazwę przychodu");
                        String incomeName = getUserInput();
                        String incomeValue;
                        do{
                            System.out.println("podaj wysokość przychodu");
                            incomeValue = getUserInput();
                            if(!costPattern.matcher(incomeValue).matches()){
                                System.out.println("Podaj liczbę");
                            }
                        }
                        while(!costPattern.matcher(incomeValue).matches());
                        userCostHandler.addIncome(currentUser, incomeName, new BigDecimal(incomeValue));
                    }
                    else if(chooseOption2.equals("2")){
                        System.out.println("podaj nazwę kosztu");
                        String costName = getUserInput();
                        String costValue;
                        do{
                            System.out.println("podaj wysokość kosztu");
                            costValue = getUserInput();
                            if(!costPattern.matcher(costValue).matches()){
                                System.out.println("Podaj liczbę");
                            }
                        }
                        while(!costPattern.matcher(costValue).matches());
                        String isCarExpense;
                        System.out.println("Czy koszt jest związany z samochodem?");
                        System.out.println("1) TAK");
                        System.out.println("2) NIE");
                        do{
                            isCarExpense = getUserInput();
                            if(!booleanPattern.matcher(isCarExpense).matches()){
                                System.out.println("Wybierz ponownie");
                            }
                        }
                        while(!booleanPattern.matcher(isCarExpense).matches());
                        userCostHandler.addCost(currentUser,costName, new BigDecimal(costValue), isCarExpense.equals("1"));
                    }
                    else if(chooseOption2.equals("3")){
                        String healthValue;
                        do{
                            System.out.println("Podaj wysokość składki zdrowotnej");
                            healthValue = getUserInput();
                            if(!costPattern.matcher(healthValue).matches()){
                                System.out.println("Podaj liczbę");
                            }
                        }
                        while(!costPattern.matcher(healthValue).matches());
                        String socialValue;
                        System.out.println("Podaj wysokość składek społecznych");
                        do{
                            socialValue = getUserInput();
                            if(!costPattern.matcher(socialValue).matches()){
                                System.out.println("Podaj liczbę");
                            }
                        }
                        while(!costPattern.matcher(socialValue).matches());
                        userCostHandler.addZUS(currentUser, new BigDecimal(healthValue), true);
                        userCostHandler.addZUS(currentUser, new BigDecimal(healthValue), false);
                    }
                    else if(chooseOption2.equals("4")){
                        userCostHandler.getIncomes(currentUser);
                    }
                    else if(chooseOption2.equals("5")){
                        userCostHandler.getCosts(currentUser);
                    }
                    else if(chooseOption2.equals("6")){
                        userCostHandler.calculateTax(currentUser);
                        userCostHandler.calculateVAT(currentUser);
                    }
                    else if(chooseOption2.equals("7")){
                        System.out.println("podaj nazwę przychodu, który chcesz usunąć");
                        String incomeName = getUserInput();
                        userCostHandler.removeIncome(currentUser, incomeName);
                    }
                    else if(chooseOption2.equals("8")){
                        System.out.println("podaj nazwę kosztu, który chcesz usunąć");
                        String costName = getUserInput();
                        userCostHandler.removeCost(currentUser, costName);
                    }
                }
                while(!chooseOption2.equals("9"));
            }*/
        }

}
