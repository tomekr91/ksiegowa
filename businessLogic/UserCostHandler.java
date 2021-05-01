package businessLogic;

import model.*;

import java.math.BigDecimal;

public class UserCostHandler {
    private VatCalculator vatCalculator = new VatCalculator();
    private TaxCalculator taxCalculator = new TaxCalculator();

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
        BigDecimal toPayVAT = this.vatCalculator.calculateVAT(user.getIncomes(), user.getCarCosts(), user.getNoCarCosts());
        System.out.printf("VAT do zapłaty: %.2f\n", toPayVAT);
    }

    public void calculateTax(User user){
        BigDecimal toPayTAX = this.taxCalculator.calculateTax(user.getIncomes(), user.getCarCosts(), user.getNoCarCosts(), user.getZus(), user.isLinear());
        System.out.printf("Podatek do zapłaty: %.2f\n", toPayTAX);
    }

    public void getCosts(User user) {
        System.out.println("Koszty związane z obsługą samochodu:");
        for(Cost c : user.getCarCosts()){
            System.out.printf("%s\t%.2f\n",c.getName(), c.getValue());
        }
        System.out.println("===================================");
        System.out.println("Koszty nie związane z obsługą samochodu:");
        for(Cost c : user.getNoCarCosts()){
            System.out.printf("%s\t%.2f\n",c.getName(), c.getValue());
        }
        System.out.println("===================================");
        System.out.println("ZUS:");
        for(ZUS z : user.getZus()){
            if(z.isHealth()){
                System.out.printf("Składka zdrowotna: %.2f\n", z.getValue());
            }
            else{
                System.out.printf("Składki społeczne: %.2f\n", z.getValue());
            }
        }
    }

    public void getIncomes(User user) {
        System.out.println("Przychody:");
        for(Income i : user.getIncomes()){
            System.out.printf("%s\t%.2f\n",i.getName(),i.getValue());
        }
    }
}
