/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Student;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author fskn
 */
public class SemesterFacade {

    private static SemesterFacade instance;
    private static EntityManagerFactory emf;

    //Private Constructor to ensure Singleton
    private SemesterFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static SemesterFacade getMemberFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new SemesterFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
    //Find all students in the system
    public List<Student> getAllStudents() {
        EntityManager em = getEntityManager();
        try{
        List<Student> students = em.createNamedQuery("Student.getAllStudents").getResultList();
        return students;        
        } finally {
            em.close();
        }
    }
    
    //Find all students in the system with the firstname anders
    public List<Student> getStudentByFirstname(String firstname) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Student> student = em.createNamedQuery("Student.getStudentByFirstname")
                    .setParameter("firstname", firstname).getResultList();
            return student;
        } finally {
            em.close();
        }
    }
    
    
    
    // insert a new student into the system
    public Student addMember(String firstname, String lastname) {
        Student student = new Student();
        student = new Student(firstname, lastname);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
            return student ;
        } finally {
            em.close();
        }
    }
    
    //find all students in the system with the lastname And
    public List<Student> getStudentByLastname(String lastname) {
        EntityManager em = emf.createEntityManager();
        try {
            List<Student> student = em.createNamedQuery("Student.getStudentByLastname")
                    .setParameter("lastname", lastname).getResultList();
            return student;
        } finally {
            em.close();
        }
    }
    
    //Find the total amount of all students 
    public int getStudentCount() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("Student.getStudentCount");
            return  Integer.parseInt(query.getSingleResult().toString());
        } finally {
            em.close();
        }
    }
    
    
}
