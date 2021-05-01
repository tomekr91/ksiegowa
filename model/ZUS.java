package model;

import model.Cost;

import java.math.BigDecimal;

public class ZUS extends Cost {
    private boolean isHealth;

    public ZUS(BigDecimal value, boolean isHealth){
        super("ZUS", value, false);
        this.isHealth = isHealth;
        }

    public boolean isHealth() {
        return isHealth;
    }

}
