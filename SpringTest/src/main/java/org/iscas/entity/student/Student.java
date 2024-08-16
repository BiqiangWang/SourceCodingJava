package org.iscas.entity.student;

import lombok.Setter;
import lombok.ToString;
import org.iscas.entity.teacher.SETeacher;
import org.iscas.entity.teacher.Teacher;

/**
 * @author wbq
 * @version 1.0
 * @title Student
 * @description
 * @create 2024/7/28 21:45
 */

@Setter
@ToString
public class Student {
    String name;
    Teacher teacher;

    public Student() {
        System.out.println("student initializing...");
    }

    public void Student(Teacher teacher, String name) {
        System.out.println("student initializing...");
        this.teacher = teacher;
        this.name = name;
    }

    public void study() {
        teacher.teach();
    }

    public void hello() {
        System.out.println("hello, I‘m a student!");
    }

}
