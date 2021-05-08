package model;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class Income {
    private String name;
    private BigDecimal value;

    public Income(String name, BigDecimal value){
        this.name = name;
        this.value = value;
    }

}
