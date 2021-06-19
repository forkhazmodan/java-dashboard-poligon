package com.chmax.polygon.model;

import com.chmax.polygon.proivder.PasswordEncoderProvider;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    public User(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.setPassword(password);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email", unique = true)
    String email;

    @Column(name = "password")
    String password;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Role> roles;

    public void setPassword(String password) {
        this.password = PasswordEncoderProvider.getEncoder().encode(password);
    }
}