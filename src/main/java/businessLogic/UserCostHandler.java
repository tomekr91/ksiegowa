package businessLogic;

import model.*;

import java.math.BigDecimal;

public class UserCostHandler {


    public void addCost(User user, String name, BigDecimal value, boolean isCarExpense){
        Cost newCost = new Cost(name, value, isCarExpense);
        if(newCost.isCarExpense()){
            user.getCarCosts().add(newCost);
        }
        else user.getNoCarCosts().add(newCost);
    }

    public void addZUS(User user, BigDecimal value, boolean isHealth){
        ZUS newZUS = new ZUS(value, isHealth);
        user.getZus().add(newZUS);
    }

    public void addIncome(User user, String name, BigDecimal value){
        Income newIncome = new Income(name, value);
        user.getIncomes().add(newIncome);
    }

    public void removeIncome(User user, String data){
        user.getIncomes().removeIf(income -> income.getName().equalsIgnoreCase(data));
    }

    public void removeCost(User user, String data){
        user.getCarCosts().removeIf(cost -> cost.getName().equalsIgnoreCase(data));
        user.getNoCarCosts().removeIf(cost -> cost.getName().equalsIgnoreCase(data));
    }

    public void calculateVAT(User user){
        System.out.println("VAT do zapłaty: " + user.getVatCalculator().calculateVAT(user.getIncomes(), user.getCarCosts(), user.getNoCarCosts()));
    }

    public void calculateTax(User user){
        System.out.println("Podatek do zapłaty: " + user.getTaxCalculator().calculateTax(user.getIncomes(), user.getCarCosts(), user.getNoCarCosts(), user.getZus(), user.isLinear()));
    }

    public void getCosts(User user) {
        System.out.println("Koszty związane z obsługą samochodu:");
        for(Cost c : user.getCarCosts()){
            System.out.println(c.getName()+"\t"+c.getValue());
        }
        System.out.println("===================================");
        System.out.println("Koszty nie związane z obsługą samochodu:");
        for(Cost c : user.getNoCarCosts()){
            System.out.println(c.getName()+"\t"+c.getValue());
        }
        System.out.println("===================================");
        System.out.println("ZUS:");
        for(ZUS z : user.getZus()){
            if(z.isHealth()){
                System.out.println("Składka zdrowotna: " + z.getValue());
            }
            else{
                System.out.println("Składki społeczne: " + z.getValue());
            }
        }
    }

    public void getIncomes(User user) {
        System.out.println("Przychody:");
        for(Income i : user.getIncomes()){
            System.out.println(i.getName()+"\t"+i.getValue());
        }
    }
}
