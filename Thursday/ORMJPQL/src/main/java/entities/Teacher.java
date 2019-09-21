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
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author fskn
 */

@NamedQueries({
    @NamedQuery(name = "Teacher.getAllTeachers", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.getTeacherByID", query = "SELECT t FROM Teacher t WHERE t.id =:id"),
    @NamedQuery(name = "Teacher.getTeacherByFirstname", query = "SELECT t FROM Teacher t WHERE t.firstname =:firstname"),
    @NamedQuery(name = "Teacher.getTeacherByLastname", query = "SELECT t FROM Teacher t WHERE t.lastname =:lastname")})

@Entity
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstname;
    private String lastname;
    
    
    @ManyToMany
    private List<Semester> semesters;
    
    

    public Teacher(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public Teacher() {
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

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }
    
    public void addSemester(Semester semester){
        this.semesters.add(semester);
    }
    
    @Override
    public String toString() {
        return "Teacher{" + "id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + '}';
    }
}
