package fr.esiea.ex4A;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AgifyResponse {
    private final String name;
    private final int age;
    private final int count;

    private final String country_id;

    @JsonCreator
    public AgifyResponse(@JsonProperty("name") String name,
                         @JsonProperty("age") int age,
                         @JsonProperty("count") int count,
                         @JsonProperty("country_id") String country_id) {
        this.name = name;
        this.age = age;
        this.count = count;
        this.country_id = country_id;
    }

    public int getAge() {
        return age;
    }

    public String getCountry_id() {
        return country_id;
    }

    public String getName() {
        return name;
    }
}
