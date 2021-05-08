package application;

import businessLogic.*;
import model.*;
import utils.*;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Application {
    User currentUser = new User();
    UserCostHandler userCostHandler = new UserCostHandler();
    UserHandler userHandler = new UserHandler();
    InfoPrinter infoPrinter = new InfoPrinter();
    InputHandler inputHandler = new InputHandler();

    public void run(){
        infoPrinter.mainMenu();
        String chooseOption = inputHandler.chooseMenuInput();
        if(chooseOption.equals("1")) addUser();
        else if(chooseOption.equals("2")) showUsers();
        else if(chooseOption.equals("3")) {
            chooseUser();
            runUserMenu();
        }
    }

    public void addUser(){
        System.out.println("Podaj nazwę użytkownika:");
        String name = inputHandler.getUserInput();
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
                userHandler.introduceUser(currentUser);
            }
        }
    }

    public void runUserMenu(){
        infoPrinter.userMenu();
        String chooseOption2 = inputHandler.chooseUserMenuInput();
        if (chooseOption2.equals("1")) addIncome();
        else if (chooseOption2.equals("2")) addCost();
        else if (chooseOption2.equals("3")) addZUS();
        else if (chooseOption2.equals("4")) getIncomes();
        else if (chooseOption2.equals("5")) getCosts();
        else if (chooseOption2.equals("6")) getTaxes();
        else if (chooseOption2.equals("7")) removeIncome();
        else if (chooseOption2.equals("8")) removeCost();
        else if (chooseOption2.equals("9")) run();
    }

    public void addIncome(){
        System.out.println("podaj nazwę przychodu");
        String incomeName = inputHandler.getUserInput();
        System.out.println("podaj wysokość przychodu");
        String incomeValue = inputHandler.costInput();
        userCostHandler.addIncome(currentUser, incomeName, new BigDecimal(incomeValue).setScale(2, RoundingMode.HALF_EVEN));
        runUserMenu();
    }

    public void addCost(){
        System.out.println("podaj nazwę kosztu");
        String costName = inputHandler.getUserInput();
        System.out.println("podaj wysokość kosztu");
        String costValue = inputHandler.costInput();
        System.out.println("Czy koszt jest związany z samochodem:\n1) TAK\n2) NIE");
        boolean isCarCost = inputHandler.getBooleanInput();
        userCostHandler.addCost(currentUser, costName, new BigDecimal(costValue).setScale(2, RoundingMode.HALF_EVEN), isCarCost);
        runUserMenu();
    }

    public void addZUS(){
        System.out.println("Podaj wysokość składki zdrowotnej:");
        String healthValue = inputHandler.costInput();
        System.out.println("Podaj wysokość składek społecznych:");
        String socialValue = inputHandler.costInput();
        userCostHandler.addZUS(currentUser, new BigDecimal(healthValue).setScale(2, RoundingMode.HALF_EVEN), true);
        userCostHandler.addZUS(currentUser, new BigDecimal(socialValue).setScale(2, RoundingMode.HALF_EVEN), false);
        runUserMenu();
    }

    public void getIncomes(){
        userCostHandler.getIncomes(currentUser);
        runUserMenu();
    }

    public void getCosts(){
        userCostHandler.getCosts(currentUser);
        runUserMenu();
    }

    public void getTaxes(){
        userCostHandler.calculateTax(currentUser);
        userCostHandler.calculateVAT(currentUser);
        runUserMenu();
    }

    public void removeIncome(){
        System.out.println("Podaj nazwę przychodu, który chcesz usunąć");
        String incomeName = inputHandler.getUserInput();
        userCostHandler.removeIncome(currentUser, incomeName);
        runUserMenu();
    }

    public void removeCost(){
        System.out.println("Podaj nazwę kosztu, który chcesz usunąć");
        String costName = inputHandler.getUserInput();
        userCostHandler.removeCost(currentUser, costName);
        runUserMenu();
    }

}
