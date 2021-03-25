package fr.esiea.ex4A;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface AgifyClient {
    @GET("/user")
    Call<UserInfo> getUser(@Query("userName") String userName,@Query("userCountry") String userCountry);

    @GET("/")
    Call<AgifyResponse> agifyRequest(@Query("name") String username,@Query("country_id") String userCountry);
}
