package com.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 〈the aop test01〉
 *
 * @author LewJay
 * @create 2018/6/16 16:06
 */
public class Transaction {
    public void logForEntering(){
        System.out.println("enter the transaction method");
    }

    public void logForAfter(){
        System.out.println("after the transaction method");
    }

    public void logForAfterReturning(){
        System.out.println("after returning the transaction method");
    }

    public Object logAround(ProceedingJoinPoint point) throws Throwable {
        System.out.println("around before");
        Object proceed = point.proceed();
        System.out.println("around after");
        return proceed;
    }

}
