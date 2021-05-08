package model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data @NoArgsConstructor
public class Cost {
    private String name;
    private BigDecimal value;
    private boolean isCarExpense;

    public Cost(String name, BigDecimal value, boolean isCarExpense){
        this.name = name;
        this.value = value;
        this.isCarExpense = isCarExpense;
    }
}
