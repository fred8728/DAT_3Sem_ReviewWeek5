/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.SemesterFacade;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fskn
 */
public class Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();
        SemesterFacade facade = SemesterFacade.getMemberFacade(emf);
        
        try{
        Student s1 = new Student("Anders", "Hansen");
        Student s2 = new Student("Poul", "Walker");
        em.getTransaction().begin();
        em.persist(s1);
        em.persist(s2);
        em.getTransaction().commit();
        } finally{
            em.close();
        }
        System.out.println(facade.getAllStudents().toString());
        System.out.println(facade.getStudentByFirstname("Anders"));
        System.out.println(facade.addMember("Anna", "Larsen"));
        System.out.println(facade.getStudentByLastname("Walker"));
        System.out.println(facade.getStudentCount());
        
    }
}
