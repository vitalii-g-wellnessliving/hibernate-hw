package xyz.gvital.repository.impl;

import jakarta.persistence.EntityManagerFactory;
import xyz.gvital.models.User;
import xyz.gvital.repository.UserRepository;
import xyz.gvital.util.JpaUtil;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private final EntityManagerFactory emf = JpaUtil.getENTITY_MANAGER_FACTORY();

    @Override
    public User create(User user) {
        try (var entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public User update(User user) {
        try (var entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.merge(user);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        try (var entityManager = emf.createEntityManager()) {
            return Optional.ofNullable(entityManager.find(User.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
