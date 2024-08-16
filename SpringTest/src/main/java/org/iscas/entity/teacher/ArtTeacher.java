package org.iscas.entity.teacher;

/**
 * @author wbq
 * @version 1.0
 * @title ArtTeacher
 * @description
 * @create 2024/7/28 22:22
 */

public class ArtTeacher implements Teacher {
    public ArtTeacher() {
        System.out.println("ArtTeacher initializing...");
    }
    @Override
    public void teach() {
        System.out.println("teach Art");
    }
}
