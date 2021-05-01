package model;

import java.math.BigDecimal;

public class Income {
    private String name;
    private BigDecimal value;

    public Income(String name, BigDecimal value){
        this.name = name;
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
