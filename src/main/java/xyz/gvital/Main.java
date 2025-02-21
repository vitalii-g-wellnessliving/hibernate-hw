package xyz.gvital;

import xyz.gvital.models.Role;
import xyz.gvital.models.User;
import xyz.gvital.repository.RoleRepository;
import xyz.gvital.repository.UserRepository;
import xyz.gvital.repository.impl.RoleRepositoryImpl;
import xyz.gvital.repository.impl.UserRepositoryImpl;

import java.util.Set;

@SuppressWarnings("hideutilityclassconstructor")
public class Main {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        RoleRepository roleRepository = new RoleRepositoryImpl();

        // Create and save a new user
        Role role = new Role();
        role.setName("Admin");
        role = roleRepository.create(role);

        User user = new User();
        user.setName("John Doe");
        user.setRoles(Set.of(role));
        user = userRepository.create(user);

        System.out.println("User saved with ID: " + user.getId() + " and roles: " + user.getRoles());
    }
}
