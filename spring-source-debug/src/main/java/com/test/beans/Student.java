package com.test.beans;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 〈the test bean class 01〉
 *
 * @author LewJay
 * @create 2018/6/9 9:08
 */
@Data
public class Student {
    private String name;
    private Integer age;
    private Double score;
    @Autowired
    private IHelper helper;

    public Student(String name, Integer age, Double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
        this.score = 120.0;
    }


    public void getHelp(){
        helper.help();
    }
}
