package com.jetbrains.macro;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserFactoryTest {

    @Test
    void buildOneAdult() throws Exception {
        var age = 40;
        var adult = new UserFactory().buildOneAdult("Yi",  age, false, LocalDate.now().minusYears(age));
        assertTrue(adult.age() > 18, "age should be at least 18");
    }

    @Test
    private void buildOneAdultFails() {
        // failed unit test
        assertDoesNotThrow( ()-> {
            var age = 3;
            var adult = new UserFactory().buildOneAdult("Yi",  age, false, LocalDate.now().minusYears(age));
        })
        ;
    }

    @Test
    void buildOneAdultFails2() throws Exception {
        // failed unit test
        assertThrows( Exception.class, ()-> {
            var age = 3;
            var adult = new UserFactory().buildOneAdult("Yi",  age, false, LocalDate.now().minusYears(age));
        })
        ;
    }

//    private void assertThrows(Class<UserFactory> userFactoryClass, Object yi) {
//    }
}