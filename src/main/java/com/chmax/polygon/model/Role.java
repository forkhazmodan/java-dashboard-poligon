package com.chmax.polygon.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Privilege> privileges;

    public Role(@NonNull String name) {
        setName(name);
    }

    public void setName(@NonNull String name) {
        this.name = name.toUpperCase();
    }
}