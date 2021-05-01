package model;

import java.math.BigDecimal;

public class Cost {
    private String name;
    private BigDecimal value;
    private boolean isCarExpense;

    public Cost(String name, BigDecimal value, boolean isCarExpense){
        this.name = name;
        this.value = value;
        this.isCarExpense = isCarExpense;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public boolean isCarExpense() {
        return isCarExpense;
    }
}
