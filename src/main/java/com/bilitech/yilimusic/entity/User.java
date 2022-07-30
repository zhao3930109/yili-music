package com.bilitech.yilimusic.entity;


import javax.persistence.*;

import lombok.Data;
import com.bilitech.yilimusic.enums.Gender;


import java.util.Date;
import java.util.List;


@Entity

@Data
public class User extends AbstractEntity {
    @Column(unique = true)
    private String username;
    private String nickname;

    @ManyToMany(cascade = {},fetch = FetchType.LAZY)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id",referencedColumnName ="id"),inverseJoinColumns =@JoinColumn(name="role_id",referencedColumnName = "id") )
    private List<Role> roles;


    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    private Boolean locked;
    private Boolean enabled;
    private String lastLoginIp;
    private Date lastLoginTime;


}
