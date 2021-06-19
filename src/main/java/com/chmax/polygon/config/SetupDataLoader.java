package com.chmax.polygon.config;

import com.chmax.polygon.enums.PrivilegeType;
import com.chmax.polygon.model.Privilege;
import com.chmax.polygon.model.Role;
import com.chmax.polygon.model.User;
import com.chmax.polygon.repository.PrivilegeRepository;
import com.chmax.polygon.repository.RoleRepository;
import com.chmax.polygon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

        Privilege viewPrivilege = createPrivilegeIfNotFound(PrivilegeType.VIEW_USER);
        Privilege createPrivilege = createPrivilegeIfNotFound(PrivilegeType.CREATE_USER);
        Privilege editPrivilege = createPrivilegeIfNotFound(PrivilegeType.EDIT_USER);
        Privilege deletePrivilege = createPrivilegeIfNotFound(PrivilegeType.DELETE_USER);

        List<Privilege> adminPrivileges = Arrays.asList(
                viewPrivilege,
                createPrivilege,
                editPrivilege,
                deletePrivilege);

        List<Privilege> userPrivileges = Collections.singletonList(viewPrivilege);

        createRoleIfNotFound("ADMIN", adminPrivileges);
        createRoleIfNotFound("USER", userPrivileges);

        com.chmax.polygon.model.Role adminRole = roleRepository.findByName("ADMIN");
        com.chmax.polygon.model.Role userRole = roleRepository.findByName("USER");

        User user = new User("test", "test@test.com", "test");
        User user2 = new User("test2", "test2@test.com", "test");

        user.setRoles(Collections.singletonList(adminRole));
        user2.setRoles(Collections.singletonList(userRole));

        createUserIfNotFound(user);
        createUserIfNotFound(user2);

        alreadySetup = true;
    }

    @Transactional
    void createUserIfNotFound(User user) {

        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if (optionalUser.isEmpty()) {
            userRepository.save(user);
        }
    }

    @Transactional
    Privilege createPrivilegeIfNotFound(PrivilegeType name) {

        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }

    @Transactional
    com.chmax.polygon.model.Role createRoleIfNotFound(String name, Collection<Privilege> privileges) {

        com.chmax.polygon.model.Role role = roleRepository.findByName(name);
        if (role == null) {
            role = new Role(name);
            role.setPrivileges(privileges);
            roleRepository.save(role);
        }
        return role;
    }

}
