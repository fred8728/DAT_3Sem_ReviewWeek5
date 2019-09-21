/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fskn
 */
public class Tester {
    
    private static EntityManagerFactory emf;
    private static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public static void main(String[] args) {
        Customer c1 = new Customer("Frederikke", "Nilsson");
        c1.addHobbies("Svømning");
        c1.addHobbies("Male");
        c1.addPhones("12345678", "Dette er nummeret");
        
        Customer c2 = new Customer("Malene", "Hansen");
        c2.addHobbies("Mad");
        c2.addPhones("43215678", "Mit nummer");
        
        Customer c3 = new Customer("Anders", "Jesan");
        c3.addHobbies("World of Warcraft");
        c3.addPhones("13212178", "Forkert nummer");
        
        Customer c4 = new Customer("Lena", "Tikki");
        c4.addHobbies("Håndarbejde");
        c4.addPhones("12334238", "Måske");
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Customer.deleteAllRows").executeUpdate();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);
            
            em.getTransaction().commit();

        } finally {
            em.close();
        }
    }
}
