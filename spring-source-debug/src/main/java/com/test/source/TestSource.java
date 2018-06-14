package com.test.source;

import com.test.beans.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈the main class of this test〉
 *
 * @author LewJay
 * @create 2018/6/9 9:06
 */
public class TestSource {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Student student = (Student) context.getBean("student");
        System.out.println(student.getScore());
    }
}
