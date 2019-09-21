package facades;

import entities.AddressOne;
import entities.Customer;
import entities.CustomerOne;
import static entities.CustomerOne_.firstname;
import static entities.CustomerOne_.lastname;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class CustomerFacade {

    private static CustomerFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private CustomerFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static CustomerFacade getCustomerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CustomerFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public long getCustomerCount() {
        EntityManager em = emf.createEntityManager();
        try {
            long customerCount = (long) em.createQuery("SELECT COUNT(c) FROM Customer c").getSingleResult();
            return customerCount;
        } finally {
            em.close();
        }

    }

    public CustomerOne getCustomer(int id){
        EntityManager em = emf.createEntityManager();
        try{
            return em.find(CustomerOne.class, id);
        }finally{
            em.close();
        }
    }

    //(Check out the hints below)
    public List<CustomerOne> getCustomers(){
        EntityManager em = emf.createEntityManager();
        try{
            TypedQuery query = em.createQuery("Select c from CustomerOne c", CustomerOne.class);
            return query.getResultList();
        }finally{
            em.close();
        }
    }
    
    public CustomerOne addCustomer(CustomerOne cust){
        cust = new CustomerOne(cust.getFirstname(), cust.getLastname());
        AddressOne add = new AddressOne();
        add = new AddressOne(add.getStreet(), add.getCity());
        cust.setAddress(add);
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(cust);
            em.getTransaction().commit();
            return cust;
        }finally{
            em.close();
        }
    }

    public CustomerOne deleteCustomer(int id){
        EntityManager em = emf.createEntityManager();
        CustomerOne cust = em.find(CustomerOne.class, id);
        try{
            em.getTransaction().begin();
            em.remove(cust);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
        return cust;
    }

    public CustomerOne editCustomer(CustomerOne cust){
        EntityManager em = emf.createEntityManager();
        cust = new CustomerOne(cust.getFirstname(), cust.getLastname());
        CustomerOne newCust = em.find(CustomerOne.class, cust);
        try {
            em.getTransaction().begin();
            cust.setFirstname(newCust.getFirstname());
            cust.setLastname(newCust.getLastname());
            em.getTransaction().commit();
            return cust;
        } finally {
            em.close();
        }
    }

}
