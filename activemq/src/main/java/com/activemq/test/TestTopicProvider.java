package com.activemq.test;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 〈the class of active topic message 〉
 *
 * @author LewJay
 * @create 2018/6/13 21:33
 */
public class TestTopicProvider {
    public static void main(String[] args) throws Exception{
        ActiveMQConnectionFactory connectionFactory =
                new ActiveMQConnectionFactory("tcp://192.168.25.134:61616");
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("test-topic");
        MessageProducer producer = session.createProducer(topic);
        TextMessage textMessage = session.createTextMessage("hello topic message!!!!");
        producer.send(textMessage);
        producer.close();
        session.close();
        connection.close();
    }
}
