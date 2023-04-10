package com.jetbrains.macro;

import java.time.LocalDate;

public record User(String name, Integer age, Boolean locked, LocalDate birthDate) {
}

