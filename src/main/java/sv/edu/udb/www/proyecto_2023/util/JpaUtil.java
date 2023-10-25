package sv.edu.udb.www.proyecto_2023.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.*;
public class JpaUtil {
    private static final EntityManagerFactory emFactory;
    static {
        emFactory = Persistence.createEntityManagerFactory("Proyecto2023");
    }
    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

}
