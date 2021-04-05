package fr.esiea.ex4A.matchify;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

enum Sex {
    M,
    F,
    O
}
public class UserInfo {
    public final String userName;
    public final String userCountry;
    private final String userTweeter;
    private final String userMail;
    private final Sex userSex;
    private final Sex userSexPref;

    public UserInfo(@JsonProperty("userName") String userName, @JsonProperty("userCountry") String userCountry, @JsonProperty("userTweeter") String userTweeter, @JsonProperty("userEmail") String userMail, @JsonProperty("userSex") Sex userSex, @JsonProperty("userSexPref") Sex userSexPref) {
            this.userName = userName;
            this.userCountry = userCountry;
            this.userMail = userMail;
            this.userTweeter = userTweeter;
            this.userSex = userSex;
            this.userSexPref = userSexPref;
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

    public Sex getUserSex() {
        return userSex;
    }
    public Sex getUserSexPref() {
        return userSexPref;
    }

    @Override
    public String toString() {
        return "{" +
            "\"userEmail\":\"" + userMail + '"' +
            ",\"userName\":\"" + userName + '"' +
            ",\"userTweeter\":\"" + userTweeter + '"' +
            ",\"userCountry\":\"" + userCountry + '"' +
            ",\"userSex\":\"" + userSex + '"' +
            ",\"userSexPref\":\"" + userSexPref + '"' +
            '}';
    }
}
