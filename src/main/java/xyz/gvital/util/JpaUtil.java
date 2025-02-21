package xyz.gvital.util;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import lombok.Getter;

public class JpaUtil {
    private static final String PERSISTENCE_UNIT_NAME = "hibernate-hw";
    @Getter
    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
}
