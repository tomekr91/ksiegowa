package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputHandler {
    private Pattern menuPattern= Pattern.compile("[1234]");
    private Pattern booleanPattern = Pattern.compile("[12]");
    private Pattern userPattern = Pattern.compile("[1-9]?[1-9]");
    private Pattern userMenuPattern = Pattern.compile("[1-9]");
    private Pattern costPattern = Pattern.compile("[0-9]{0,9}\\.?[0-9]{0,2}");
    private Scanner in = new Scanner(System.in);

    public String getUserInput(){
        return in.nextLine();
    }

    public String chooseMenuInput(){
        String chooseOption = getUserInput();
        boolean rightMenuPattern = menuPattern.matcher(chooseOption).matches();
        if(rightMenuPattern){
            return chooseOption;
        }
        System.out.println("Wybierz ponownie");
        return chooseMenuInput();
    }

    public boolean getBooleanInput(){
        String booleanInput = getUserInput();
        boolean rightBooleanPattern = booleanPattern.matcher(booleanInput).matches();
        if(rightBooleanPattern){
            return booleanInput.equals("1");
        }
        System.out.println("Wybierz ponownie");
        return getBooleanInput();
    }

    public String chooseUserInput(){
        String chooseUser = getUserInput();
        boolean rightUserPattern = userPattern.matcher(chooseUser).matches();
        if(rightUserPattern){
            return chooseUser;
        }
        System.out.println("Wybierz ponownie");
        return chooseUserInput();
    }

    public String chooseUserMenuInput(){
        String chooseOption = getUserInput();
        boolean rightUserMenuPattern = userMenuPattern.matcher(chooseOption).matches();
        if(rightUserMenuPattern){
            return chooseOption;
        }
        System.out.println("Wybierz ponownie");
        return chooseUserMenuInput();
    }

    public String costInput(){
        String costInput = getUserInput();
        boolean rightCostPattern = costPattern.matcher(costInput).matches();
        if(rightCostPattern){
            return costInput;
        }
        System.out.println("wybierz ponownie");
        return costInput();
    }
}
