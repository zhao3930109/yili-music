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

}