/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mappers;

import entities.Student;

/**
 *
 * @author fskn
 */
public class StudentInfo {

    public String fullName;
    public long studentId;
    public String classNameThisSemester;
    public String classDescription;

    public StudentInfo(Student s) {
        this.fullName = s.getFirstname() + s.getLastname();
        this.studentId = studentId;
        this.classNameThisSemester = classNameThisSemester;
        this.classDescription = classDescription;
    }
    
    

}
