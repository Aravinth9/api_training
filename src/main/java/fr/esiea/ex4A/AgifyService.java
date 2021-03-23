package fr.esiea.ex4A;

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



    public String getUser(String userName, String userCountry) {
        String reponse = " ";
        Call<UserInfo> agifyResponseCall = agifyClient.getUser(userName, userCountry);
        try {
            Response<UserInfo> bite = agifyResponseCall.execute();
            reponse = "ok";
            if (bite.isSuccessful()) {
                System.out.println(reponse);
            }
        } catch (IOException exception) {
            reponse = "ko";
            exception.printStackTrace();
        }

        return reponse;
    }


    public boolean add(UserInfo userInfo) {
        return userRepo.getUserList().add(userInfo);
    }

    public ArrayList<UserInfo> getAll(){
        return userRepo.getUserList();
    }

    public boolean isHere(UserInfo userInfo) {
        for (UserInfo u : userRepo.getUserList()) {
            if (u.getUserName().equals(userInfo.getUserName())) {
                return true;
            }
        }
        return false;
    }
}
