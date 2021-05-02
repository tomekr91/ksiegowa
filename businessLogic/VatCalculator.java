package businessLogic;
import model.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

public class VatCalculator {
    private VAT vat = new VAT();

    public BigDecimal calculateVAT (ArrayList<Income> incomes, ArrayList<Cost> carCosts, ArrayList<Cost> noCarCosts) {
        vat.setToDeduct(new BigDecimal("0"));
        vat.setTotal(new BigDecimal("0"));
        for (Income i : incomes) {
            vat.setTotal(vat.getTotal().add(i.getValue().multiply(vat.getVATRate())));
        }
        for (Cost c : carCosts) {
            vat.setToDeduct(vat.getToDeduct().add(c.getValue().multiply(vat.getVATRate()).multiply(vat.getVATCarDeductLevel())));
        }
        for (Cost c : noCarCosts) {
            vat.setToDeduct(vat.getToDeduct().add(c.getValue().multiply(vat.getVATRate())));
        }
        this.vat.setToPay(vat.getTotal().subtract(vat.getToDeduct()));
        return this.vat.getToPay().setScale(2, RoundingMode.HALF_EVEN);
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }
}
