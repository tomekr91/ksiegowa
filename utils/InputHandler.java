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
        if(menuPattern.matcher(chooseOption).matches()){
            return chooseOption;
        }
        System.out.println("Wybierz ponownie");
        return chooseMenuInput();
    }

    public boolean getBooleanInput(){
        String booleanInput = getUserInput();
        if(booleanPattern.matcher(booleanInput).matches()){
            return booleanInput.equals("1");
        }
        System.out.println("Wybierz ponownie");
        return getBooleanInput();
    }

//    public String chooseUserInput(){
//        String chooseUser = getUserInput();
//        if(!userPattern.matcher(chooseUser).matches()){
//            System.out.println("Wybierz ponownie");
//            chooseUserInput();
//        }
//        System.out.println(chooseUser);
//        return chooseUser;
//    }

    public String chooseUserInput(){
        String chooseUser = getUserInput();
        if(userPattern.matcher(chooseUser).matches()){
            return chooseUser;
        }
        System.out.println("Wybierz ponownie");
        return chooseUserInput();
    }

    public String chooseUserMenuInput(){
        String chooseOption = getUserInput();
        if(userMenuPattern.matcher(chooseOption).matches()){
            return chooseOption;
        }
        System.out.println("Wybierz ponownie");
        return chooseUserMenuInput();
    }

    public String costInput(){
        String costInput = getUserInput();
        if(costPattern.matcher(costInput).matches()){
            return costInput;
        }
        System.out.println("wybierz ponownie");
        return costInput();
    }
}
