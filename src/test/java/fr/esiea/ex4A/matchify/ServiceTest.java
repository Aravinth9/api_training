package fr.esiea.ex4A.matchify;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServiceTest {
    AgifyClient agifyClient() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://api.agify.io/").addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(AgifyClient.class);
    }

    AgifyClient mockAgifyClient = agifyClient();
    UserRepo userRepo = new UserRepo();

    AgifyService agifyService = new AgifyService(mockAgifyClient, userRepo);

    @Test
    void adding_a_user_should_increment_the_number_of_users() throws IOException {
        UserInfo userData = new UserInfo("marlon@mail.com", "Marlon", "marlon14", "US", Sex.M, Sex.F);
        AgifyResponse agifyResponse = this.agifyService.getUserAge(userData.getUserName(),userData.getUserCountry());
        agifyService.addNewUser(userData, agifyResponse);
        Assertions.assertThat(userRepo.userList.get("marlon@mail.com")).isEqualTo(userData);
        Assertions.assertThat(userRepo.getNumberOfUsers()).isEqualTo(1);
    }

    @Test
    void adding_multiple_users_should_increment_the_number_of_users() throws IOException {
        UserInfo userData1 = new UserInfo("henri@mail.fr", "Henri", "bHenri", "FR", Sex.M, Sex.M);
        UserInfo userData2 = new UserInfo("juan@movistar.es", "Juan", "juanjuan", "ES", Sex.M, Sex.F);
        UserInfo userData3 = new UserInfo("elena@mail.ru", "Elena", "elenaaa", "RU", Sex.F, Sex.F);
        UserInfo userData4 = new UserInfo("marlon@mail.com", "Marlon", "marlon14", "US", Sex.M, Sex.F);
        AgifyResponse agifyResponse1 = this.agifyService.getUserAge(userData1.getUserName(),userData1.getUserCountry());
        AgifyResponse agifyResponse2 = this.agifyService.getUserAge(userData2.getUserName(),userData2.getUserCountry());
        AgifyResponse agifyResponse3 = this.agifyService.getUserAge(userData3.getUserName(),userData3.getUserCountry());
        AgifyResponse agifyResponse4 = this.agifyService.getUserAge(userData4.getUserName(),userData4.getUserCountry());
        agifyService.addNewUser(userData1,agifyResponse1);
        agifyService.addNewUser(userData2,agifyResponse2);
        agifyService.addNewUser(userData3,agifyResponse3);
        agifyService.addNewUser(userData4,agifyResponse4);
        Assertions.assertThat(userRepo.userList.get("henri@mail.fr")).isEqualTo(userData1);
        Assertions.assertThat(userRepo.userList.get("juan@movistar.es")).isEqualTo(userData2);
        Assertions.assertThat(userRepo.userList.get("elena@mail.ru")).isEqualTo(userData3);
        Assertions.assertThat(userRepo.userList.get("marlon@mail.com")).isEqualTo(userData4);
        Assertions.assertThat(userRepo.getNumberOfUsers()).isEqualTo(4);
    }
}
