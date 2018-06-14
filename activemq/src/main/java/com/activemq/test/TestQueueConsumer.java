package com.activemq.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 〈the active message queue consumer class 〉
 *
 * @author LewJay
 * @create 2018/6/13 21:16
 */
public class TestQueueConsumer {
    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.25.134:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("test-queue");
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MyMessageListener());
        System.out.println("end");
        System.in.read();
        consumer.close();
        session.close();
        connection.close();
    }
}
