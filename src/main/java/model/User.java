package model;

import businessLogic.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data @NoArgsConstructor
public class User {
    private String name;
    private int ID;
    private UserID userID= new UserID();
    private boolean isLinear;
    private ArrayList<Cost> carCosts = new ArrayList<>();
    private ArrayList<Cost> noCarCosts = new ArrayList<>();
    private ArrayList<Income> incomes = new ArrayList<>();
    private ArrayList<ZUS> zus = new ArrayList<>();
    private VatCalculator vatCalculator = new VatCalculator();
    private TaxCalculator taxCalculator = new TaxCalculator();

    public User(String name, boolean isLinear){
        this(name);
        this.isLinear = isLinear;
    }

    public User(String name){
        this.name = name;
        this.ID = userID.setID();
    }
}
