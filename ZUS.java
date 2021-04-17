public class ZUS extends Cost {
    private boolean isHealth;

    public ZUS(double value, boolean isHealth){
        super("ZUS", value, false);
        this.isHealth = isHealth;
        }

    public boolean isHealth() {
        return isHealth;
    }

}
