package fr.esiea.ex4A.matchify;

import fr.esiea.ex4A.matchify.AgifyResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class AgifyUserTest {


    @ParameterizedTest
    @CsvSource({
        "Marlon, Marlon",
        "Juan, Juan",
        "Fabrice, Fabrice"
    })
    void creating_a_new_agifyuser_with_a_name_should_give_the_same_name(String wantedName, String expectedName){
        AgifyResponse agifyUser = new AgifyResponse(wantedName, 10, 10, "US");
        Assertions.assertThat(agifyUser.getName()).isEqualTo(expectedName);
    }

    @ParameterizedTest
    @CsvSource({
        "44, 44",
        "56, 56",
        "49, 49"
    })
    void creating_a_new_agifyuser_with_an_age_should_give_the_same_age(int wantedAge, int expectedAge){
        AgifyResponse agifyUser = new AgifyResponse("test", wantedAge, 10, "US");
        Assertions.assertThat(agifyUser.getAge()).isEqualTo(expectedAge);
    }

    @ParameterizedTest
    @CsvSource({
        "1477, 1477",
        "569, 569",
        "4049, 4049"
    })
    void creating_a_new_agifyuser_with_a_count_should_give_the_same_count(int wantedCount, int expectedCount){
        AgifyResponse agifyUser = new AgifyResponse("test", 10, wantedCount, "US");
        Assertions.assertThat(agifyUser.getCount()).isEqualTo(expectedCount);
    }

    @ParameterizedTest
    @CsvSource({
        "US, US",
        "AR, AR",
        "FR, FR"
    })
    void creating_a_new_agifyuser_with_a_country_should_give_the_same_country(String wantedCountry, String expectedCountry){
        AgifyResponse agifyUser = new AgifyResponse("test", 10, 100, wantedCountry);
        Assertions.assertThat(agifyUser.getCountry_id()).isEqualTo(expectedCountry);
    }
}
