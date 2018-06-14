package com.activemq.test;


import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 〈the message sender of active message queue〉
 *
 * @author LewJay
 * @create 2018/6/13 20:58
 */
public class TestQueueProvider {
    public static void main(String[] args) throws Exception{
//        第一步：创建ConnectionFactory对象，需要指定服务端ip及端口号。
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://192.168.25.134:61616");
//        第二步：使用ConnectionFactory对象创建一个Connection对象。
        Connection connection = connectionFactory.createConnection();
//        第三步：开启连接，调用Connection对象的start方法。
        connection.start();
//        第四步：使用Connection对象创建一个Session对象。
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//        第五步：使用Session对象创建一个Destination对象（topic、queue），此处创建一个Queue对象。
        Queue queue = session.createQueue("test-queue");
//        第六步：使用Session对象创建一个Producer对象。
        MessageProducer producer = session.createProducer(queue);
//        第七步：创建一个Message对象，创建一个TextMessage对象。
        TextMessage message = session.createTextMessage("hello active message queue");
//        第八步：使用Producer对象发送消息。
        producer.send(message);
//        第九步：关闭资源。
        producer.close();
        session.close();
        connection.close();
    }
}
