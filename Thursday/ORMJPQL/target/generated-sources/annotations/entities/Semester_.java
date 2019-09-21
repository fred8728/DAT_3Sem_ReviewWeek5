package entities;

import entities.Student;
import entities.Teacher;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-20T17:52:39")
@StaticMetamodel(Semester.class)
public class Semester_ { 

    public static volatile ListAttribute<Semester, Teacher> teachers;
    public static volatile SingularAttribute<Semester, String> name;
    public static volatile SingularAttribute<Semester, String> description;
    public static volatile ListAttribute<Semester, Student> students;
    public static volatile SingularAttribute<Semester, Integer> id;

}