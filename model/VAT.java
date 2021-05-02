package model;

import java.math.BigDecimal;

public class VAT {
    private BigDecimal total = new BigDecimal("0.00");
    private BigDecimal toDeduct = new BigDecimal("0.00");
    private BigDecimal toPay;
    private final BigDecimal VATRate = new BigDecimal("0.23");
    private final BigDecimal VATCarDeductLevel = new BigDecimal("0.50");

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public void setToDeduct(BigDecimal toDeduct) {
        this.toDeduct = toDeduct;
    }

    public void setToPay(BigDecimal toPay) {
        this.toPay = toPay;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public BigDecimal getToDeduct() {
        return toDeduct;
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    public BigDecimal getVATRate() {
        return VATRate;
    }

    public BigDecimal getVATCarDeductLevel() {
        return VATCarDeductLevel;
    }
}
