package xyz.gvital.repository;

import xyz.gvital.models.Role;

import java.util.Optional;

public interface RoleRepository {
    Role create(Role role);

    Optional<Role> findById(Long id);
}
