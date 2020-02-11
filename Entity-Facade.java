#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

/*
 * author ${USER}
 * version 1.0
*/

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

#set ($entityName = ${NAME.split("Facade")[0]})
#set ($lcEntityName = $entityName.toLowerCase())

public class ${NAME} {

    private static ${NAME} instance;
    private static EntityManagerFactory emf;

    private ${NAME}() {}

    /**
     * @param _emf
     * @return an instance of this facade class.
     */
    public static ${NAME} get${NAME}(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new ${NAME}();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getCount() {
        throw new UnsupportedOperationException();
    }

    public List<$entityName> getAll() {
        throw new UnsupportedOperationException();
    }

    public List<$entityName> getByName(String name) {
        throw new UnsupportedOperationException();
    }

    public $entityName getById(long id) {
        throw new UnsupportedOperationException();
    }

    public $entityName create($entityName $lcEntityName) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist($lcEntityName);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return $lcEntityName;
    }

    public void populate() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Movie.deleteAllRows").executeUpdate();
            throw new UnsupportedOperationException();
        } finally {
            em.close();
        }
    }
}
