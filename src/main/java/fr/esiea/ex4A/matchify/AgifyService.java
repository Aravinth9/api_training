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
    public AgifyResponse getUserAge(String userName, String country_id) throws IOException {
        AgifyResponse agifyResponse = this.agifyClient.agifyRequest(userName, country_id).execute().body();
        return agifyResponse;
    }

    void addNewUser(UserInfo userData, AgifyResponse agifyResponse){
        this.userRepo.addUser(userData,agifyResponse);
    }

    public void get (String userName)
    {
        UserInfo userInfo = userRepo.getName(userName);
        int age = userRepo.match(userInfo);
    }
    public ArrayList<UserInfo> matchUser(String userName, String userCountry){
        UserInfo userRequestingMatch = userRepo.getName(userName);
        if(userRequestingMatch != null){
            return userRepo.matchUser(userRequestingMatch);
        } else {
            return new ArrayList<>();
        }
    }

}
