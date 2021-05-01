package model;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.ArrayList;

public class TAX {
    private BigDecimal taxBase = new BigDecimal("0.00");
    private BigDecimal deduction = new BigDecimal("0.00");
    private BigDecimal toPay;
    private VAT vat;
    private final BigDecimal taxTreshold =  new BigDecimal("85000.00");
    private final BigDecimal linearTaxRate = new BigDecimal("0.19");
    private final BigDecimal firstProgressiveTaxRate = new BigDecimal("0.17");
    private final BigDecimal secondProgressiveTaxRate = new BigDecimal("0.32");

    public BigDecimal getTaxBase() {
        return taxBase;
    }

    public void setTaxBase(BigDecimal taxBase) {
        this.taxBase = taxBase;
    }

    public BigDecimal getDeduction() {
        return deduction;
    }

    public void setDeduction(BigDecimal deduction) {
        this.deduction = deduction;
    }

    public BigDecimal getToPay() {
        return toPay;
    }

    public void setToPay(BigDecimal toPay) {
        this.toPay = toPay;
    }

    public VAT getVat() {
        return vat;
    }

    public void setVat(VAT vat) {
        this.vat = vat;
    }

    public BigDecimal getTaxTreshold() {
        return taxTreshold;
    }

    public BigDecimal getLinearTaxRate() {
        return linearTaxRate;
    }

    public BigDecimal getFirstProgressiveTaxRate() {
        return firstProgressiveTaxRate;
    }

    public BigDecimal getSecondProgressiveTaxRate() {
        return secondProgressiveTaxRate;
    }
}
