package com.chmax.polygon.model;

import com.chmax.polygon.proivder.ApplicationContextProvider;
import com.chmax.polygon.proivder.PasswordEncoderProvider;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "users")
public class User {

    public User(String name, String email, String password) {
        this.setName(name);
        this.setEmail(email);
        this.setPassword(password);
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "email")
    String email;

    @Column(name = "password")
    String password;

    @ManyToMany(fetch = FetchType.LAZY)
////    @JoinTable(
////            name = "users_roles",
////            joinColumns = @JoinColumn(
////                    name = "user_id", referencedColumnName = "id"),
////            inverseJoinColumns = @JoinColumn(
////                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public void setPassword(String password) {
        this.password = PasswordEncoderProvider.getEncoder().encode(password);
    }
}
