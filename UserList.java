import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public void addUser(String name, boolean isLinear){
        User newUser = new User(name, isLinear);
        this.users.add(newUser);
    }

    public void getUsers(){
        for(User u : users){
            if(u.isLinear()){
                System.out.println("Użytkownik numer "+u.getID()+" - "+u.getName() +" podatek liniowy");
            }
            else {
                System.out.println("Użytkownik numer "+u.getID()+" - "+u.getName() +" podatek progresywny");
            }
            System.out.println("=====================================================================");
        }
    }

    public boolean isArrayListUsersEmpty(){
        return this.users == null;
    }

    public User setUser(int index){
        return this.users.get(index-1);
    }

    public void getUser(int index){
        System.out.println("Jesteś użytkownikiem " + this.users.get(index-1).getID()+" - "+this.users.get(index-1).getName());
    }

    public int getSize(){
        return this.users.size();
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
