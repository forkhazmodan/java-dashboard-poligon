package com.chmax.polygon.model;

import com.chmax.polygon.enums.PrivilegeType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "privileges")
public class Privilege implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PrivilegeType name;

    public Privilege(PrivilegeType name) {
        this.name = name;
    }

    @Override
    public String getAuthority() {
        return getName().name();
    }

}
