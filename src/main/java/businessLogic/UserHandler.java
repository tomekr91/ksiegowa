package businessLogic;

import model.*;

public class UserHandler {
    private UserList userList = new UserList();

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

    public void introduceUser(User user){
        System.out.println("Cześć " +user.getName()+"! Wybierz co chcesz zrobić:");
    }

    public boolean isUserListEmpty(){
        return userList.getUsers().isEmpty();
    }

    public int getSize(){
        return userList.getUsers().size();
    }
}
