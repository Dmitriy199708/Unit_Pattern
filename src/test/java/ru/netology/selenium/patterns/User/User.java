package ru.netology.selenium.patterns.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor

public class User {
    private final String city;
    private final String data;
    private final String name;
    private final String phone;
}
