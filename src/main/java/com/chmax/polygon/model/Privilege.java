package com.chmax.polygon.model;

import com.chmax.polygon.enums.PrivilegeEnum;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "privileges")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private PrivilegeEnum name;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Role> roles;

    public Privilege(PrivilegeEnum name) {
        this.name = name;
    }
}
