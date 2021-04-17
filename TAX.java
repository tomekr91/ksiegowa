import java.util.ArrayList;

public class TAX {
    private double taxBase;
    private double deduction;
    private double toPay;
    private final double taxTreshold = 85000;
    private final double linearTaxRate = 0.19;
    private final double firstProgressiveTaxRate = 0.17;
    private final double secondProgressiveTaxRate = 0.32;

    public double calculateTax(ArrayList<Income> incomes, ArrayList<Cost> carCosts, ArrayList<Cost> noCarCosts, ArrayList<ZUS> zus, boolean isLinear){
        for(Income i : incomes){
            this.taxBase += i.getValue();
        }
        for(Cost c : carCosts){
            this.taxBase -= 0.75 * (c.getValue() + 0.5 * 0.23 * c.getValue());
        }
        for(Cost c : noCarCosts){
            this.taxBase -= c.getValue();
        }
        for(ZUS z : zus){
            if(z.isHealth()){
                this.deduction += 7.75/9 * z.getValue();
            }
            else{
                this.taxBase -= z.getValue();
            }
        }
        if(isLinear){
            this.toPay = this.taxBase * this.linearTaxRate - this.deduction;
        }
        else{
            if(this.taxBase < this.taxTreshold){
                this.toPay = this.taxBase * this.firstProgressiveTaxRate - this.deduction;
            }
            else{
                this.toPay = this.taxTreshold * this.firstProgressiveTaxRate + (this.taxBase - this.taxTreshold)*this.secondProgressiveTaxRate - this.deduction;
            }
        }
        return this.toPay;
    }

    public double getTaxBase() {
        return taxBase;
    }

    public double getDeduction() {
        return deduction;
    }

    public double getToPay() {
        return toPay;
    }

    public double getTaxTreshold() {
        return taxTreshold;
    }

    public double getLinearTaxRate() {
        return linearTaxRate;
    }

    public double getFirstProgressiveTaxRate() {
        return firstProgressiveTaxRate;
    }

    public double getSecondProgressiveTaxRate() {
        return secondProgressiveTaxRate;
    }
}
