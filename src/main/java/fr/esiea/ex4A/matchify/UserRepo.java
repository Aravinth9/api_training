package fr.esiea.ex4A.matchify;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class UserRepo {

    private final ArrayList<UserInfo> userList = new ArrayList<>();

    public ArrayList<UserInfo> getUserList() {
        return this.userList;
    }

    public boolean addUser(UserInfo userInfo){
        this.userList.add(userInfo);
        return true;
    }
}