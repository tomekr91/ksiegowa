package businessLogic;

public class UserID {
    private static int nextID;

    public int setID(){
        nextID ++;
        return nextID;
    }
}
