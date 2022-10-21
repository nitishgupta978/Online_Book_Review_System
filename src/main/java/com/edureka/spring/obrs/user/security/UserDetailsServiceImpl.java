package com.edureka.spring.obrs.user.security;

import com.edureka.spring.obrs.user.entity.User;
import com.edureka.spring.obrs.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserService userService;
    private Converter<User, UserDetails> userToUserDetailsConverter;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    @Qualifier(value = "userToUserDetails")
    public void setUserUserDetailsConverter(Converter<User, UserDetails> userToUserDetailsConverter) {
        this.userToUserDetailsConverter = userToUserDetailsConverter;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userToUserDetailsConverter.convert(userService.findByUsername(username));
    }


}
