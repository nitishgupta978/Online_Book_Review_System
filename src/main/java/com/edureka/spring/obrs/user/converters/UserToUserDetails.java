package com.edureka.spring.obrs.user.converters;

import com.edureka.spring.obrs.user.entity.User;
import com.edureka.spring.obrs.user.security.UserDetailsImpl;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserToUserDetails implements Converter<User, UserDetails> {
    @Override
    public UserDetails convert(User user) {
        UserDetailsImpl userDetails = new UserDetailsImpl(user);
        if (user != null) {
            userDetails.setUsername(user.getUserName());
            userDetails.setPassword(user.getEncryptedPassword());
            userDetails.setEnabled(user.getActive());
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRole()));
            });
            userDetails.setAuthorities(authorities);
        }
        return userDetails;
    }
}
