package model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class VAT {
    private BigDecimal total = new BigDecimal("0.00");
    private BigDecimal toDeduct = new BigDecimal("0.00");
    private BigDecimal toPay;
    private final BigDecimal VATRate = new BigDecimal("0.23");
    private final BigDecimal VATCarDeductLevel = new BigDecimal("0.50");
}
