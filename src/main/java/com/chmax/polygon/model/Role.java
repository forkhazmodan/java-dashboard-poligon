package com.chmax.polygon.model;

import com.chmax.polygon.enums.RoleEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    public enum Roles {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private RoleEnum name;

    @ManyToMany
    private Collection<User> users;


//////    @JoinTable(
//////            name = "roles_privileges",
//////            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"),
//////            inverseJoinColumns = @JoinColumn(name = "privilege_id", referencedColumnName = "id"))
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Privilege> privileges;



    public Role(RoleEnum name) {
        this.name = name;
    }
}
