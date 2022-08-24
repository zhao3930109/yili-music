package com.bilitech.yilimusic.entity;


import javax.persistence.*;

import lombok.Data;

import com.bilitech.yilimusic.enums.Gender;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity

@Data
public class User extends AbstractEntity  implements UserDetails {
    @Column(unique = true)
    private String username;
    private String nickname;

    @ManyToMany(cascade = {},fetch = FetchType.LAZY)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id",referencedColumnName ="id"),inverseJoinColumns =@JoinColumn(name="role_id",referencedColumnName = "id") )
    private List<Role> roles;


    private String password;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    private Boolean locked = false;
    private Boolean enabled = true;
    private String lastLoginIp;
    private Date lastLoginTime;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !this.getLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.getEnabled();
    }
}
