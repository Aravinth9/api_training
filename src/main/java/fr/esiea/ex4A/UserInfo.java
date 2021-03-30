package fr.esiea.ex4A;

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
    private final Optional<Integer> age;

    public UserInfo(String userName, String userCountry, String userTweeter, String userMail, Sex userSex, Sex userSexPref, Optional<Integer> age) {
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
                    @JsonProperty("userSex") Sex userSex,
                    @JsonProperty("userSexPref") Sex userSexPref) {
            this.userName = userName;
            this.userCountry = userCountry;
            this.userMail = userMail;
            this.userTweeter = userTweeter;
            this.userSex = userSex;
            this.userSexPref = userSexPref;
            this.age = Optional.empty();
        }

    public UserInfo(UserInfo userInfo, int age) {
        this.userMail = userInfo.userMail;
        this.userName = userInfo.userName;
        this.userTweeter = userInfo.userTweeter;
        this.userCountry = userInfo.userCountry;
        this.userSex = userInfo.userSex;
        this.userSexPref = userInfo.userSexPref;
        this.age = Optional.of(age);
    }

    public Integer getUserAge(){return age.get();}

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
    public Optional<Integer> getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "\nUserInfo{" +
            "userName='" + userName + '\'' +
            ", userCountry='" + userCountry + '\'' +
            ", userTweeter='" + userTweeter + '\'' +
            ", userMail='" + userMail + '\'' +
            ", userSex='" + userSex + '\'' +
            ", userSexPref='" + userSexPref + '\'' +
            ", age=" + age +
            "} \n";
    }


}


