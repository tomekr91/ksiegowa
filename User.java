import java.util.ArrayList;

public class User {
    private String name;
    private int ID;
    private static int nextID = 1;
    private ArrayList<Cost> carCosts = new ArrayList<>();
    private ArrayList<Cost> noCarCosts = new ArrayList<>();
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<ZUS> zus = new ArrayList<>();
    private VAT vat = new VAT();
    private TAX tax = new TAX();
    private boolean isLinear;

    public User(){}

    public User(String name, boolean isLinear){
        this(name);
        this.isLinear = isLinear;
    }

    public User(String name){
        this.name = name;
        this.ID = nextID;
        nextID ++;
    }

    public void calculateVAT(){
        double toPayVAT = this.vat.calculateVAT(this.incomes, this.carCosts, this.noCarCosts);
        System.out.printf("VAT do zapłaty: %.2f\n", toPayVAT);
    }


    public void calculateTax(){
        double toPayTAX = this.tax.calculateTax(this.incomes, this.carCosts, this.noCarCosts, this.zus, this.isLinear);
        System.out.printf("Podatek do zapłaty: %.2f\n", toPayTAX);
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

    public void getIncomes() {
        System.out.println("Przychody");
        for(Income i : this.incomes){
            System.out.println(i.getName()+"  "+i.getValue());
        }
    }

    public ArrayList<ZUS> getZus() {
        return zus;
    }

    public boolean isLinear() {
        return isLinear;
    }

    public int getID() {
        return ID;
    }
}
