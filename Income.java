public class Income {
    private String name;
    private double value;

    public Income(String name, double value){
        this.name = name;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
