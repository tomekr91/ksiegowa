package businessLogic;

import model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class TaxCalculator {
    private TAX tax = new TAX();
    private VAT vat = new VAT();

    public BigDecimal calculateTax(ArrayList<Income> incomes, ArrayList<Cost> carCosts, ArrayList<Cost> noCarCosts, ArrayList<ZUS> zus, boolean isLinear){
        for(Income i : incomes){
            tax.setTaxBase(tax.getTaxBase().add(i.getValue()));
        }
        for(Cost c : carCosts){
            tax.setTaxBase(tax.getTaxBase().subtract(c.getValue().multiply(new BigDecimal("0.75")).add(c.getValue()).multiply(vat.getVATRate().multiply(vat.getVATCarDeductLevel()))));
            //this.taxBase -= 0.75 * (c.getValue() + 0.5 * 0.23 * c.getValue());
        }
        for(Cost c : noCarCosts){
            tax.setTaxBase(tax.getTaxBase().subtract(c.getValue()));
        }
        for(ZUS z : zus){
            if(z.isHealth()){
                tax.setDeduction(tax.getDeduction().add(z.getValue().multiply(new BigDecimal("7.75")).divide(new BigDecimal("9.00"), RoundingMode.HALF_EVEN)));
                //+= 7.75/9 * z.getValue();
            }
            else{
                tax.setTaxBase(tax.getTaxBase().subtract(z.getValue()));
            }
        }
        if(isLinear){
            tax.setToPay(tax.getTaxBase().multiply(tax.getLinearTaxRate()).subtract(tax.getDeduction()));
        }
        else{
            int checkTaxTreshold= tax.getTaxBase().compareTo(tax.getTaxTreshold());
            if(checkTaxTreshold == -1){
                tax.setToPay(tax.getTaxBase().multiply(tax.getFirstProgressiveTaxRate()).subtract(tax.getDeduction()));
            }
            else{
                tax.setToPay(tax.getTaxTreshold().multiply(tax.getFirstProgressiveTaxRate()).add(tax.getSecondProgressiveTaxRate().multiply(tax.getTaxBase().subtract(tax.getTaxTreshold()))).subtract(tax.getDeduction()));
                //this.taxTreshold * this.firstProgressiveTaxRate + (this.taxBase - this.taxTreshold)*this.secondProgressiveTaxRate - this.deduction;
            }
        }
        return tax.getToPay();
    }
}
