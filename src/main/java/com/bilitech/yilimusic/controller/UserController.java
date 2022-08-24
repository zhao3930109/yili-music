package com.bilitech.yilimusic.controller;


import com.bilitech.yilimusic.dto.UserCreateDto;
import com.bilitech.yilimusic.entity.User;
import com.bilitech.yilimusic.mapper.UserMapper;
import com.bilitech.yilimusic.service.UserService;
import com.bilitech.yilimusic.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController

@RequestMapping("/users")
public class UserController {
    UserService userService;
    UserMapper  userMapper;

    @GetMapping("/")
    List<UserVo> list(){
        return userService.list().stream().map(userMapper::toVo).collect(Collectors.toList());

    }

    @PostMapping("/")
    UserVo create(@RequestBody UserCreateDto userCreateDto){
        return userMapper.toVo(userService.create(userCreateDto));
    }

    @Autowired
    public  void setUserService(UserService userService){
        this.userService = userService;
    }

    @Autowired

    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}
