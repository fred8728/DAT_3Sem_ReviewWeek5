package facades;

import entities.Person;
import java.util.ArrayList;
import java.util.List;
import utils.EMF_Creator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import utils.Settings;
import utils.EMF_Creator.DbSelector;
import utils.EMF_Creator.Strategy;

//Uncomment the line below, to temporarily disable this test
@Disabled
public class PersonFacadeTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;
    Person p1 = new Person("Frederikke", "Nilsson", "12345678");
    Person p2 = new Person("Cathrine", "Billen", "87654321");
    Person p3 = new Person("Katinka", "Villa", "75838274");

    public PersonFacadeTest() {
    }

    //@BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode_test",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
        facade = PersonFacade.getPersonFacade(emf);
    }

    /*   **** HINT **** 
        A better way to handle configuration values, compared to the UNUSED example above, is to store those values
        ONE COMMON place accessible from anywhere.
        The file config.properties and the corresponding helper class utils.Settings is added just to do that. 
        See below for how to use these files. This is our RECOMENDED strategy
     */
    @BeforeAll
    public static void setUpClassV2() {
        emf = EMF_Creator.createEntityManagerFactory(DbSelector.TEST, Strategy.DROP_AND_CREATE);
        facade = PersonFacade.getPersonFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }

    // Setup the DataBase in a known state BEFORE EACH TEST
    //TODO -- Make sure to change the script below to use YOUR OWN entity class
    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteAllRows").executeUpdate();
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    // TODO: Delete or change this method 
    @Test
    public void countPersonsTest() {
        assertEquals(3, facade.getPersonCount());
    }

    @Test

    public void getPersonTest() {
        Person p = facade.getPerson(p1.getId());
        assertEquals("Frederikke", p1.getFirstname());
    }

    @Test
    public void getAllPersonsTest() {
        List<Person> persons = facade.getAllPersons();
        List<Person> np = new ArrayList();
        np.add(p1);
        np.add(p2);
        np.add(p3);

        assertNotNull(persons);
        assertNotNull(np);
        assertEquals(np.size(), persons.size());

    }
    
    @Test
    public void deletePersonTest() {
        Person p = facade.deletePerson(p1.getId());
        assertEquals(2, facade.getPersonCount());
    
    }

    @Test
    public void addpersonTest() {
        String firstname = "Caroline";
        String lastname = "Villa";
        String phone = "98765433";
        Person p = new Person(firstname, lastname, phone);
        assertEquals(3, facade.getPersonCount());
    }

    
    /*
    @Test
    public void editPersonTest(){
    
    }
     */

}
