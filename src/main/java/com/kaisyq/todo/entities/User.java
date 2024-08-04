package com.kaisyq.todo.entities;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kaisyq.todo.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * This class represents a user entity in the application
 */
@Data
@AllArgsConstructor
@Entity
@Table(name = "users")
public final class User implements UserDetails {
    
    /**
     * The unique ID of the user
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * The username of the user
     */
    @Column(nullable = false, unique = true)
    private String username;

    /**
     * The password of the user
     */
    @Column(nullable = false)
    private String password;

    /**
     * The roles of the user
     */
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Role> roles;

    /**
     * Returns a collection of granted authorities based on the user's roles.
     *
     * @return a collection of GrantedAuthority objects representing the user's roles
    */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return 
            this.getRoles()
            .stream()
            .map(role -> new SimpleGrantedAuthority(role.toString()))
            .collect(Collectors.toList());
    }
}
