package businessLogic;
import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class VatCalculator {
    private VAT vat = new VAT();

    public BigDecimal calculateVAT (ArrayList<Income> incomes, ArrayList<Cost> carCosts, ArrayList<Cost> noCarCosts) {
        for (Income i : incomes) {
            vat.setTotal(vat.getTotal().add(i.getValue().multiply(vat.getVATRate())));
        }
        for (Cost c : carCosts) {
            vat.setToDeduct(vat.getToDeduct().add(c.getValue().multiply(vat.getVATRate()).multiply(vat.getVATCarDeductLevel())));
        }
        for (Cost c : noCarCosts) {
            vat.setToDeduct(vat.getToDeduct().add(c.getValue().multiply(vat.getVATRate())));
        }
        vat.setToPay(vat.getTotal().subtract(vat.getToDeduct()));
        return vat.getToPay();
    }

}
