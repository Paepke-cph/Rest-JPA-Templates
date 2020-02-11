#if (${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end

/*
 * author ${USER}
 * version 1.0
*/

import utils.EMF_Creator;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

#set ($facadeName = ${NAME.split("Test")[0]})
#set ($facadeNameVar  = $facadeName.toLowerCase())
#set ($entityName = $facadeName.split("Facade")[0])
#set ($entityNameVar = $entityName.toLowerCase())

public class ${NAME} {

    private static EntityManagerFactory emf;
    private static $facadeName $facadeNameVar;

    public ${NAME}() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        ${facadeNameVar} = ${facadeName}.get${facadeName}(emf);
    }

    @BeforeAll
    public static void setUpClassV2() {
       emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST,Strategy.DROP_AND_CREATE);
       ${facadeNameVar} = ${facadeName}.get${facadeName}(emf);
    }

    @AfterAll
    public static void tearDownClass() {
        // Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("${entityName}.deleteAllRows").executeUpdate();
            em.persist(new ${entityName}());
            em.persist(new ${entityName}());
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void testAFacadeMethod() {
        assertEquals(2, ${facadeNameVar}.getCount(), "Expects two rows in the database");
    }
}
