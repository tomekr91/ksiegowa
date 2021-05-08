package model;

import lombok.Data;
import java.util.ArrayList;

@Data
public class UserList {
    private ArrayList<User> users = new ArrayList<>();

}
