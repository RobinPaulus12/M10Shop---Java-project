package com.spring.henallux.javaProjectB3.model;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptedPassword {

    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(encoder.encode("dhsqjdhqsJDQHbdqsndvsbD132343FFSD3E___232SDSDS"));

    }
}
