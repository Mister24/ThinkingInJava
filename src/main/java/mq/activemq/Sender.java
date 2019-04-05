/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package mq.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author mr.24
 * @version Id: Sender, v 1.0 2019/4/6 上午12:22 Exp $$
 */
public class Sender {

    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616");
    }

    public static void main(String[] args) {
        Connection connection = null;
        Session session = null;
        Destination destination;
        MessageProducer producer = null;
        try {
            connection = connectionFactory.createConnection();

            connection.start();

            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

            destination = session.createQueue("demo");

            producer = session.createProducer(destination);

            send(session, producer);

        } catch (JMSException e) {

        }
    }

    public static void send(Session session, MessageProducer producer) throws JMSException {
        for (int i = 0; i < 20; i++) {
            // 构建消息
            TextMessage message = session.createTextMessage("消息" + i);

            // 发送消息
            producer.send(message);
            System.out.println("发送消息： 消息" + i);
        }
    }
}
