/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author fskn
 */

@NamedQueries({
    @NamedQuery(name = "Semester.getAllSemesters", query = "SELECT s FROM Semester s"),
    @NamedQuery(name = "Semester.getSemesterByID", query = "SELECT s FROM Semester s WHERE s.id =:id"),
    @NamedQuery(name = "Semester.getSemesterByDescription", query = "SELECT s FROM Semester s  WHERE s.description =:description"),
    @NamedQuery(name = "Semester.getSemesterByName", query = "SELECT s FROM Semester s  WHERE s.name =:name")})
@Entity
public class Semester implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String description;
    private String name;

    @ManyToMany(mappedBy = "semesters")
    private List<Teacher> teachers = new ArrayList();
    
    @ManyToOne (cascade=CascadeType.PERSIST)
    private Student student;

    public Semester(String description, String name) {
        this.description = description;
        this.name = name;
    }

    public Semester() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void addTeachers(Teacher teacher) {
        this.teachers.add(teacher);
    }

    @Override
    public String toString() {
        return "Semester{" + "id=" + id + ", description=" + description + ", name=" + name + '}';
    }

}
