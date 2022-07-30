package com.bilitech.yilimusic.service;

import com.bilitech.yilimusic.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    List<UserDto>list();
}
