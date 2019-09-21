/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author fskn
 */
@NamedQueries({
    @NamedQuery(name = "Student.getAllStudents", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.getStudentByID", query = "SELECT s FROM Student s WHERE s.id =:id"),
    @NamedQuery(name = "Student.getStudentByFirstname", query = "SELECT s FROM Student s WHERE s.firstname =:firstname"),
    @NamedQuery(name = "Student.getStudentByLastname", query = "SELECT s FROM Student s WHERE s.lastname =:lastname"),
    @NamedQuery(name = "Student.getStudentCount", query = "SELECT COUNT(s) FROM Student s")

})

@Entity
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    
    @OneToMany(mappedBy = "student")
    private List <Semester> semester;

    public Student(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public List<Semester> getSemester() {
        return semester;
    }

    public void setSemester(List<Semester> semester) {
        this.semester = semester;
    }
    
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }

}
