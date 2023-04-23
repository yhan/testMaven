package com.jetbrains.macro;

import java.time.LocalDate;

public class UserFactory {
    User buildOneAdult(String name, Integer age, Boolean locked, LocalDate dateOfBirth) throws Exception {
        if(age < 18)
            throw new Exception("age should at least 18");

        return new User(name, age, locked, dateOfBirth);
    }
}

