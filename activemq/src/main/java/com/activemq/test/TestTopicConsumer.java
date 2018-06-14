package com.activemq.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 〈the class of active message consumer〉
 *
 * @author LewJay
 * @create 2018/6/13 21:38
 */
public class TestTopicConsumer {
    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.25.134:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("test-topic");
        MessageConsumer consumer = session.createConsumer(topic);
        consumer.setMessageListener(new MyMessageListener());
        System.in.read();
        System.out.println("end");
        consumer.close();
        session.close();
        connection.close();
    }
}
