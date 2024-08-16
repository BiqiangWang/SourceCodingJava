package org.iscas;

import org.iscas.entity.student.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wbq
 * @version 1.0
 * @title BI
 * @description
 * @create 2024/7/28 22:27
 */

public class BI {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        Student student = context.getBean(Student.class);
        student.study();
        System.out.println(student.toString());
    }
}
