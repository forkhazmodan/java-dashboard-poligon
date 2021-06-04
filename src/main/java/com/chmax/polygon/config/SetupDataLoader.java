package com.chmax.polygon.config;

import com.chmax.polygon.enums.PrivilegeEnum;
import com.chmax.polygon.enums.RoleEnum;
import com.chmax.polygon.model.Privilege;
import com.chmax.polygon.model.Role;
import com.chmax.polygon.model.User;
import com.chmax.polygon.repository.PrivilegeRepository;
import com.chmax.polygon.repository.RoleRepository;
import com.chmax.polygon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class SetupDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    boolean alreadySetup = false;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        if (alreadySetup) return;

        Privilege readPrivilege = createPrivilegeIfNotFound(PrivilegeEnum.READ);
        Privilege writePrivilege = createPrivilegeIfNotFound(PrivilegeEnum.WRITE);

        List<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
        createRoleIfNotFound(RoleEnum.ADMIN, adminPrivileges);
        createRoleIfNotFound(RoleEnum.USER, Collections.singletonList(readPrivilege));

        com.chmax.polygon.model.Role adminRole = roleRepository.findByName(RoleEnum.ADMIN);

        User user = new User("test", "test@test.com", "test");
//        user.setRoles(Collections.singletonList(adminRole));
        userRepository.save(user);

        System.out.println(user);

        alreadySetup = true;
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(PrivilegeEnum name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    com.chmax.polygon.model.Role createRoleIfNotFound(RoleEnum name, Collection<Privilege> privileges) {

        com.chmax.polygon.model.Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
//            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
