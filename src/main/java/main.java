import application.Application;
import utils.InfoPrinter;

public class main {

    public static void main(String[] args) {
        InfoPrinter infoPrinter = new InfoPrinter();
        Application app = new Application();

        infoPrinter.greetings();
        app.run();
    }
}
