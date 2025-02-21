package xyz.gvital.repository.impl;

import jakarta.persistence.EntityManagerFactory;
import xyz.gvital.models.Role;
import xyz.gvital.repository.RoleRepository;
import xyz.gvital.util.JpaUtil;

import java.util.Optional;

public class RoleRepositoryImpl implements RoleRepository {

    private final EntityManagerFactory emf = JpaUtil.getENTITY_MANAGER_FACTORY();

    @Override
    public Role create(Role role) {
        try (var entityManager = emf.createEntityManager()) {
            entityManager.getTransaction().begin();
            entityManager.persist(role);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return role;

    }

    @Override
    public Optional<Role> findById(Long id) {
        try (var entityManager = emf.createEntityManager()) {
            return Optional.ofNullable(entityManager.find(Role.class, id));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Optional.empty();
    }
}
