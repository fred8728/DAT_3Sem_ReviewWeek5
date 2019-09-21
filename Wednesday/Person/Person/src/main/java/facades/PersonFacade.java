package facades;

import entities.Address;
import entities.Person;
import exceptions.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class PersonFacade implements IPersonFacade{

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private PersonFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    
    public int getPersonCount(){
        EntityManager em = emf.createEntityManager();
        try{
            Query query = em.createQuery("SELECT COUNT(p) FROM Person p");
            return Integer.parseInt(query.getSingleResult().toString());
        }finally{  
            em.close();
        }
        
    }

    @Override
    public Person addPerson(String firstname, String lastname, String phone) {
        Person p = new Person();
        p = new Person(firstname, lastname, phone);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }

    @Override
    public Person deletePerson(int id) {
        EntityManager em = emf.createEntityManager();
        Person p = em.find(Person.class, id);
        try {
            em.getTransaction().begin();
            em.remove(p);
            em.getTransaction().commit();
        }finally {
            em.close();
        }
        return p;
    }
    

    @Override
    public Person getPerson(int id) {
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(Person.class, id);
        }
        finally{
            em.close();
        } 
    }

    @Override
    public List<Person> getAllPersons() {
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery query = 
                    em.createQuery("Select p from Person p", Person.class);
            return query.getResultList();
        }finally{
            em.close();
        }
    }

    
    //Method doesnt work yet
    @Override
    public Person editPerson(Person p) {
        EntityManager em = emf.createEntityManager();
        p = new Person(p.getFirstname(), p.getLastname(), p.getPhone());
        Person p1 = em.find(Person.class, p);
        try {
            em.getTransaction().begin();
            p.setFirstname(p1.getFirstname());
            p.setLastname(p1.getLastname());
            p.setPhone(p1.getPhone());
            em.getTransaction().commit();
            return p;
        } finally {
            em.close();
        }
    }
}

