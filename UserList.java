import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users = new ArrayList<>();

    public void addUser(String name, boolean isLinear){
        User newUser = new User(name, isLinear);
        this.users.add(newUser);
    }

    public void getUsers(){
        System.out.println("Lista użytkowników:");
        for(User u : users){
            System.out.printf("%2d. - %s\n", u.getID(), u.getName());
        }
        System.out.println("=====================================================================");
    }

    public boolean isArrayListUsersEmpty(){
        return this.users.size() == 0;
    }

    public User chooseUser(int index){
        return this.users.get(index-1);
    }

    public void introduceUser(int index){
        System.out.println("Cześć " +this.users.get(index-1).getName()+"! Wybierz co chcesz zrobić:");
    }

    public int getSize(){
        return this.users.size();
    }

}
