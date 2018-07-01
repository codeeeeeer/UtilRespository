package com.test.source;

import com.test.actions.BeforeAopTest;
import com.test.actions.interfaces.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 〈〉
 *
 * @author LewJay
 * @create 2018/6/16 16:23
 */

public class TestSource02 {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:app*.xml");
        BeforeAopTest aopTest = context.getBean(BeforeAopTest.class);
        aopTest.doJob();
        UserService userService = context.getBean(UserService.class);
        userService.updateUserInfo("Honey!!!");
    }
}
