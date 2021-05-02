package model;

import businessLogic.*;

import java.util.ArrayList;

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



    public User(){}

    public User(String name, boolean isLinear){
        this(name);
        this.isLinear = isLinear;
    }

    public User(String name){
        this.name = name;
        this.ID = userID.setID();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public UserID getUserID() {
        return userID;
    }

    public void setUserID(UserID userID) {
        this.userID = userID;
    }

    public boolean isLinear() {
        return isLinear;
    }

    public void setLinear(boolean linear) {
        isLinear = linear;
    }

    public ArrayList<Cost> getCarCosts() {
        return carCosts;
    }

    public ArrayList<Cost> getNoCarCosts() {
        return noCarCosts;
    }

    public ArrayList<Income> getIncomes() {
        return incomes;
    }

    public ArrayList<ZUS> getZus() {
        return zus;
    }

    public VatCalculator getVatCalculator() {
        return vatCalculator;
    }

    public TaxCalculator getTaxCalculator() {
        return taxCalculator;
    }
}
