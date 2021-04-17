public class Cost {
    private String name;
    private double value;
    private boolean isCarExpense;

    public Cost(String name, double value, boolean isCarExpense){
        this.name = name;
        this.value = value;
        this.isCarExpense = isCarExpense;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public boolean isCarExpense() {
        return isCarExpense;
    }
}
