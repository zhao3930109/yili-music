package com.bilitech.yilimusic.repository;

import com.bilitech.yilimusic.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



import java.util.Optional;


public interface UserRepository extends JpaRepository<User,String> {
    User getByUsername(String username);
    Optional<User> findByUsername(String username);


}
