package com.spring.henallux.javaProjectB3.dataAccess.dao;

import com.spring.henallux.javaProjectB3.dataAccess.entity.UserEntity;
import com.spring.henallux.javaProjectB3.dataAccess.repository.UserRepository;
import com.spring.henallux.javaProjectB3.dataAccess.util.ProviderConverter;
import com.spring.henallux.javaProjectB3.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
class UserDAOTest {
    private UserDAO userDAO;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setup() {
        userDAO = new UserDAO(userRepository, new ProviderConverter());
    }

    @Test
    void findByUsername() throws Exception {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date dateOfBirth = dateFormat.parse("12-12-2002");
        UserEntity userEntityMocked = new UserEntity(1, "robin.paulus10@gmail.com", "robinpaulus", "password", "Robin", "Paulus", dateOfBirth,"0472580914", "Rue Gaston Dancot", "ROLE_USER", true, false, false, false);
        when(userRepository.findByUsername("robinpaulus")).thenReturn(userEntityMocked);
        User user = userDAO.findByUsername("robinpaulus");
        assertEquals("robin.paulus10@gmail.com", user.getEmail());
        assertEquals("robinpaulus", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals("Robin", user.getFirstName());
        assertEquals("Paulus", user.getLastName());
        assertEquals(dateOfBirth, user.getDateOfBirth());
        assertEquals("0472580914", user.getTelephone());
        assertEquals("Rue Gaston Dancot", user.getAddress());

    }
}