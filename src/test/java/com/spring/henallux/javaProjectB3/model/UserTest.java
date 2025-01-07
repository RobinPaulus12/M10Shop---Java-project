package com.spring.henallux.javaProjectB3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;

    @BeforeEach
    void setUp() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth = dateFormat.parse("12-12-2002");
        user = new User(1, "robin.paulus10@gmail.com", "robinpaulus", "password","Robin", "Paulus", dateOfBirth,"0472580914", "Rue Gaston Dancot", "ROLE_USER", true, false, false, false);
    }

    @Test
    void getTelephone() {
        assertEquals("0472580914", user.getTelephone());
    }

    @Test
    void getDateOfBirth() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date expectedDate = dateFormat.parse("12-12-2002");
        assertEquals(expectedDate, user.getDateOfBirth());
    }

    @Test
    void getAddress() {
        assertEquals("Rue Gaston Dancot", user.getAddress());
    }

    @Test
    void getPassword() {
        assertEquals("password", user.getPassword());
    }

    @Test
    void setPassword() {
        user.setPassword("newPassword");
        assertEquals("newPassword", user.getPassword());
    }
}
