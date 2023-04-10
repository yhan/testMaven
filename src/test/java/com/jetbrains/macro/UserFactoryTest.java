package com.jetbrains.macro;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.*;

class UserFactoryTest {

    @Test
    void buildOneAdult() throws Exception {
        var age = 40;
        var adult = new UserFactory().buildOneAdult("Yi",  age, false, LocalDate.now().minusYears(age));
        assertThat(adult.age()).isGreaterThanOrEqualTo(18);
    }

    @Test
    @Ignore
    void buildOneAdultFails() {

        assertThatThrownBy(() -> {
            var age = 3;
            var adult = new UserFactory().buildOneAdult("Hugo",  age, false, LocalDate.now().minusYears(age));
        })
                .isInstanceOf(Exception.class)
                .hasMessage("age should at least 18");
    }

    @Test
    void buildOneAdultFails2() {

        assertThatThrownBy(() -> {
            var age = 3;
            var me = new UserFactory().buildOneAdult("Yi",  age, false, LocalDate.now().minusYears(age));
        })
                .isInstanceOf(Exception.class)
                .hasMessage("age should at least 18");
    }

//    private void assertThrows(Class<UserFactory> userFactoryClass, Object yi) {
//    }
}