package com.test.beans;

import lombok.Data;

import java.util.List;

/**
 * 〈teacher〉
 *
 * @author LewJay
 * @create 2018/6/9 10:06
 */
@Data
public class Teacher {
    private String name;
    private Integer age;
    private List<Student> students;
    public Teacher(List<Student> students){
        this.students = students;
    }
}
