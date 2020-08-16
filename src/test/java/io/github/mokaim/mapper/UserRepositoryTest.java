package io.github.mokaim.mapper;

import io.github.mokaim.domain.TestUser;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder bCryptPasswordEncoder;

    TestUser testUser;

    @Before
    public void setUp() throws Exception {
        testUser = new TestUser();
    }

    @Test
    public void identifyUser() {
        System.out.println("is true ? " + bCryptPasswordEncoder.matches("1234",userRepository.identifyUser("test").getPassword()));
    }

    @Test
    public void insertTest() {
        testUser.setNum(2);
        testUser.setUsername("test");
        testUser.setPassword(bCryptPasswordEncoder.encode("1234"));
        testUser.setRole("MEMBER");

        userRepository.insertTest(testUser);
    }
}