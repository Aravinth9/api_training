package fr.esiea.ex4A.matchify;

import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;
import java.util.ArrayList;

@Service
public class AgifyService {
    private final AgifyClient agifyClient;
    private final UserRepo userRepo;


    public AgifyService(AgifyClient agifyClient, UserRepo userRepo) {
        this.agifyClient = agifyClient;
        this.userRepo = userRepo;
    }



    public UserInfo getUser(String userName) {
        for (UserInfo u : userRepo.getUserList())
        {
            if (u.getUserName().equals(userName))
                return u;
        }

        return null;
    }


    public boolean add(UserInfo userInfo) {
        return userRepo.addUser(userInfo);
    }

    public ArrayList<UserInfo> getAll(){
        return userRepo.getUserList();
    }

    public boolean exists(UserInfo userInfo) {
        for (UserInfo u : userRepo.getUserList()) {
            if (u.getUserName().equals(userInfo.getUserName())) {
                return true;
            }
        }
        return false;
    }
    public int getUserAge(String userName, String country_id){
        int age = 0;
        Call<AgifyResponse> agifyResponseCall = agifyClient.agifyRequest(userName,country_id);
        try {
            Response<AgifyResponse> response = agifyResponseCall.execute();
            if(response.isSuccessful()){
                assert response.body() != null;
                age = response.body().getAge();
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }
        return age;
    }
}
