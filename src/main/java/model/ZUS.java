package model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ZUS extends Cost {
    private boolean isHealth;

    public ZUS(BigDecimal value, boolean isHealth){
        super("ZUS", value, false);
        this.isHealth = isHealth;
        }

}
