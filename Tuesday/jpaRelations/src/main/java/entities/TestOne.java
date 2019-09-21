/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.CustomerFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fskn
 */

public class TestOne {
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        CustomerOne c1 = new CustomerOne("Frederikke", "Nilsson");
        AddressOne add1 = new AddressOne("LyngbyVej", "Lyngby");
        AddressOne add = new AddressOne("Ishøjvej 12", "Ishøj");
        c1.setAddress(add);
        c1.setAddress(add1);
        
        CustomerOne c2 = new CustomerOne("Kirsten", "Nilsson");
        AddressOne add3 = new AddressOne("Ishøjvej 12", "Karslunde");
        AddressOne add4 = new AddressOne("Karslunde 212", "Hundige");
        c2.setAddress(add3);
        c2.setAddress(add4);
        
        CustomerOne c3 = new CustomerOne("Malene", "Haj");
        AddressOne add2 = new AddressOne("HundigeVej 5", "Hundige");
        AddressOne add5 = new AddressOne("Kisservej 45", "Greve");
        c3.setAddress(add2);
        c3.setAddress(add5);
        
        //add.setCustomerOne(c1); //OneToMany bidrectional
        //c1.addAddress(add); //OneToMany unidirectional and bidirectional
        //c1.setAddress(add); //OneToOne
        //add1.setCustomerOne(c2); //OneToMany bidrectional
        //c2.addAddress(add1); //OneToMany unidirectional and bidirectional
        //add2.setCustomerOne(c3); //OneToMany bidrectional
        //c3.addAddress(add2); //OneToMany unidirectional and bidirectional
        //c2.setAddress(add1); //Når man kører bidirectional skal man huske at sætte customer på address og omvendt
        //add1.setCustomerOne(c2); // se setAdress inde i customer , så man ikke skal gøre sådan her
        
        try {
            em.getTransaction().begin();
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            
            em.getTransaction().commit();

        } finally {
            em.close();
        }
        
        
        //not fully correct - it add the customer, and the address it - but the address is null in addressone table 
        CustomerFacade facade = CustomerFacade.getCustomerFacade(emf);
        System.out.println(facade.getCustomers().toString());
        AddressOne add8 = new AddressOne("Sigurdsvej 3", "Hornbæk");
        CustomerOne cust = new CustomerOne("Simona", "Niller");
        cust.setAddress(add8);
        facade.addCustomer(cust);
        
        
    }
    
    
    
}
