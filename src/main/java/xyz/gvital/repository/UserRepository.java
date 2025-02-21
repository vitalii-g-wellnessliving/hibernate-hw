package xyz.gvital.repository;

import xyz.gvital.models.User;

import java.util.Optional;

public interface UserRepository {
    User create(User user);

    User update(User user);

    Optional<User> findById(Long id);
}
