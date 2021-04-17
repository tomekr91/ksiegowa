import java.util.ArrayList;

public class User {
    private String name;
    private ArrayList<Cost> carCosts = new ArrayList<>();
    private ArrayList<Cost> noCarCosts = new ArrayList<>();
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<ZUS> zus = new ArrayList<>();
    private VAT vat = new VAT();
    private TAX tax = new TAX();
    private boolean isLinear;

    public User(String name, boolean isLinear){
        this.name = name;
        this.isLinear = isLinear;
    }

    public double getVAT(){
        return this.vat.calculateVAT(this.incomes, this.carCosts, this.noCarCosts);
    }


    public double getIncomeTax(){
        return this.tax.calculateTax(this.incomes, this.carCosts, this.noCarCosts, this.zus, this.isLinear);
    }

    public void addCost(String name, double value, boolean isCarExpense){
        Cost newCost = new Cost(name, value, isCarExpense);
        if(newCost.isCarExpense()){
            this.carCosts.add(newCost);
        }
        else this.noCarCosts.add(newCost);
    }

    public void addZUS(double value, boolean isHealth){
        ZUS newZUS = new ZUS(value, isHealth);
        this.zus.add(newZUS);
    }

    public void addIncome(String name, double value){
        Income newIncome = new Income(name, value);
        this.incomes.add(newIncome);
    }

    public String getName() {
        return name;
    }

    public void getCarCosts() {
        System.out.println("Koszty związane z obsługą samochodu");
        for(Cost c : this.carCosts){
            System.out.println(c.getName()+"  "+c.getValue()+"  ");
        }
        System.out.println("===================================");
    }

    public void getNoCarCosts() {
        System.out.println("Koszty nie związane z obsługą samochodu");
        for(Cost c : this.noCarCosts){
            System.out.println(c.getName()+"  "+c.getValue()+"  ");
        }
        System.out.println("===================================");
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    public ArrayList<ZUS> getZus() {
        return zus;
    }

    public boolean isLinear() {
        return isLinear;
    }
}
