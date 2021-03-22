package fr.esiea.ex4A;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class UserInfo {
    public final String userName;
    public final String userCountry;
    private final String userTweeter;
    private final String userMail;
    private final String userSex;
    private final String userSexPref;
    private final Optional<Integer> age;

    public UserInfo(String userName, String userCountry, String userTweeter, String userMail, String userSex, String userSexPref, Optional<Integer> age) {
        this.userName = userName;
        this.userCountry = userCountry;
        this.userTweeter = userTweeter;
        this.userMail = userMail;
        this.userSex = userSex;
        this.userSexPref = userSexPref;
        this.age = age;
    }

    public UserInfo(@JsonProperty("userName") String userName,
                    @JsonProperty("userCountry") String userCountry,
                    @JsonProperty("userTweeter") String userTweeter,
                    @JsonProperty("userEmail") String userMail,
                    @JsonProperty("userSex") String userSex,
                    @JsonProperty("userSexPref") String userSexPref) {
            this.userName = userName;
            this.userCountry = userCountry;
            this.userMail = userMail;
            this.userTweeter = userTweeter;
            this.userSex = userSex;
            this.userSexPref = userSexPref;
            this.age = Optional.empty();
        }




    public String getUserName() {
        return userName;
    }

    public String getUserCountry() {
        return userCountry;
    }

    public String getUserTweeter() {
        return userTweeter;
    }

    public String getUserMail() {
        return userMail;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserSexPref() {
        return userSexPref;
    }

    public Optional<Integer> getAge() {
        return age;
    }
}


