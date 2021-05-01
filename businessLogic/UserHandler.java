package businessLogic;

import model.*;

import java.util.Scanner;

public class UserHandler {
    private UserList userList = new UserList();
    static Scanner in = new Scanner(System.in);

    static String getUserInput(){
        return in.nextLine();
    }

    public void addUser(String name, boolean isLinear){
        User newUser = new User(name, isLinear);
        userList.getUsers().add(newUser);
    }

    public void getUsers(){
        System.out.println("Lista użytkowników:");
        for(User u : userList.getUsers()){
            System.out.printf("%2d. - %s\n", u.getID(), u.getName());
        }
        System.out.println("=====================================================================");
    }

    public User chooseUser(int index){
        return userList.getUsers().get(index-1);
    }

    public void introduceUser(int index){
        System.out.println("Cześć " +userList.getUsers().get(index-1).getName()+"! Wybierz co chcesz zrobić:");
    }

    public boolean isUserListEmpty(){
        return userList.getUsers().isEmpty();
    }

    public int getSize(){
        return userList.getUsers().size();
    }
}
