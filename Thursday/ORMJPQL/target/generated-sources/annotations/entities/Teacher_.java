package entities;

import entities.Semester;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-09-20T17:52:39")
@StaticMetamodel(Teacher.class)
public class Teacher_ { 

    public static volatile SingularAttribute<Teacher, String> firstname;
    public static volatile SingularAttribute<Teacher, Integer> id;
    public static volatile ListAttribute<Teacher, Semester> semesters;
    public static volatile SingularAttribute<Teacher, String> lastname;

}