package org.iscas;

import org.iscas.entity.student.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wbq
 * @version 1.0
 * @title IOC
 * @description
 * @create 2024/7/28 21:43
 */

public class IOC {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        System.out.println("start to get student");
        Student student = context.getBean(Student.class);
        student.hello();
        System.out.println(student);
    }
}
