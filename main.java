
public class main {

    public static void main(String[] args) {
        User tomek = new User("tomek", true);
        tomek.addCost("leasing", 1500, false);
        tomek.addCost("księgowość", 99, false);
        tomek.addCost("parking", 300, true);
        tomek.addCost("paliwo", 400, true);
        tomek.addIncome("nexity", 10000);
        System.out.println();
        tomek.addZUS(350, true);
        tomek.addZUS(300, false);

        tomek.getCarCosts();
        tomek.getNoCarCosts();

        System.out.println(tomek.getVAT());
        System.out.println(tomek.getIncomeTax());
    }


}
