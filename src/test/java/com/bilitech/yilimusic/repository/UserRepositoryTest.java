package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.User;
import com.bilitech.yilimusic.enums.Gender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
class UserRepositoryTest {
    @Autowired
    UserRepository repository;
//    @Test
//    void findByUsername() {
//        User user = new User();
//        user.setUsername("伊力");
//        user.setEnabled(true);
//        user.setLocked(false);
//        user.setPassword("9095155");
//        user.setGender(Gender.FEMAL);
//        user.setLastLoginIp("127.0.0.1");
//        user.setLastLoginTime(new Date());
//        User savedUser = repository.save(user);
//        System.out.println(savedUser.toString());
//        User result = repository.getByUsername("伊力");
//        System.out.println(result.toString());
//
//     }
}