package org.iscas.entity.teacher;

/**
 * @author wbq
 * @version 1.0
 * @title SETeacher
 * @description
 * @create 2024/7/28 22:21
 */

public class SETeacher implements Teacher {
    public SETeacher() {
        System.out.println("SETeacher initializing...");
    }

    @Override
    public void teach() {
        System.out.println("teach Java");
    }

}
