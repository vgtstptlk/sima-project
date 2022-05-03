/*
package com.vgtstptlk.simaproject.jwt;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Data
public class JwtUser implements UserDetails {

    private Long id;
    private String username;
    private Collection<? extends GrantedAuthority> grantedAuthorities;

    public static JwtUser fromUserToJwtUser(User user){
        JwtUser jwtUser = new JwtUser();
        jwtUser.username = user.getEmail();
        jwtUser.id = user.getId();
        jwtUser.grantedAuthorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole().getName()));
        return jwtUser;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public Long getUserId(){
        return id;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }


}
*/
