package fr.esiea.ex4A.matchify;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepo {

    final HashMap<String, UserInfo> userList = new HashMap<>();
    final HashMap<String, AgifyResponse> userListWithAge = new HashMap<>();


    void addUser(UserInfo userInfo, AgifyResponse agifyResponse){
        this.userList.put(userInfo.getUserName(), userInfo);
        this.userListWithAge.put(userInfo.getUserName(), agifyResponse);
    }
    public boolean exists (UserInfo userInfo)
    {
        return this.userList.containsKey(userInfo.getUserName());
    }

    ArrayList<UserInfo> getUser() {
        ArrayList<UserInfo> matchingUsers = new ArrayList<>();
        for (Map.Entry<String, UserInfo> userEntry : this.userList.entrySet()) {
            matchingUsers.add(userEntry.getValue());
        }
        return matchingUsers;
    }
    ArrayList<AgifyResponse> getResponse() {
        ArrayList<AgifyResponse> matchingUsers = new ArrayList<>();
        for (Map.Entry<String, AgifyResponse> userEntry : this.userListWithAge.entrySet()) {
            matchingUsers.add(userEntry.getValue());
        }
        return matchingUsers;
    }

    public UserInfo getName(String userName) {
        return this.userList.get(userName);
    }

    public ArrayList<UserInfo> matchUser(UserInfo userInfo) {
        ArrayList<UserInfo> matchingUsers = new ArrayList<>();
        for(Map.Entry<String, AgifyResponse> userEntry : this.userListWithAge.entrySet()){
            if(Math.abs(userEntry.getValue().getAge() - this.userListWithAge.get(userInfo.getUserName()).getAge()) <= 4){
                UserInfo possiblyMatchingUser = this.userList.get(userEntry.getValue().getName());
                if(possiblyMatchingUser.getUserSex().equals(userInfo.getUserSexPref()) && userInfo.getUserSex().equals(possiblyMatchingUser.getUserSexPref())) {
                    matchingUsers.add(this.userList.get(userEntry.getValue().getName()));
                }
            }
        }
        return matchingUsers;
    }
    int getNumberOfUsers(){
        return this.userList.size();
    }

    public int match (UserInfo userInfo)
    {
        return this.userListWithAge.get(userInfo.getUserName()).getAge();
    }
}
