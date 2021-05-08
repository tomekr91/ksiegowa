package model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class TAX {
    private BigDecimal taxBase = new BigDecimal("0.00");
    private BigDecimal deduction = new BigDecimal("0.00");
    private BigDecimal toPay;
    private VAT vat;
    private final BigDecimal taxTreshold =  new BigDecimal("85000.00");
    private final BigDecimal linearTaxRate = new BigDecimal("0.19");
    private final BigDecimal firstProgressiveTaxRate = new BigDecimal("0.17");
    private final BigDecimal secondProgressiveTaxRate = new BigDecimal("0.32");
}
