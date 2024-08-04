package com.kaisyq.todo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kaisyq.todo.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private final UserRepository userRepository;

    private final String USER_NOT_FOUND_BY_NAME_FORMAT = "User with name: %s not found !";

    /**
     * Retrieves the UserDetails object for the given username.
     *
     * @param  username  the username of the user
     * @return           the UserDetails object for the user
     * @throws UsernameNotFoundException if the user with the given username is not found
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final var user = this.userRepository.findOneByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_BY_NAME_FORMAT, username)));

        return user;
    }
    

}
