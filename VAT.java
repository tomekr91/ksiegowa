import java.util.ArrayList;

public class VAT {
    private double total;
    private double toDeduct;
    private double toPay;

    public double calculateVAT (ArrayList<Income> incomes, ArrayList<Cost> carCosts, ArrayList<Cost> noCarCosts) {
        for (Income i : incomes) {
            this.total += 0.23 * i.getValue();
        }
        for (Cost c : carCosts) {
            this.toDeduct += 0.5 * 0.23 * c.getValue();
        }
        for (Cost c : noCarCosts) {
            this.toDeduct += 0.23 * c.getValue();
        }
        this.toPay = this.total - this.toDeduct;
        return this.toPay;
    }

    public double getToPay() {
        return toPay;
    }

    public void setToPay(double toPay) {
        this.toPay = toPay;
    }
}
