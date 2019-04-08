/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package mq.activemq.producerandconsumer;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @author mr.24
 * @version Id: Consumer, v 1.0 2019/4/6 上午12:30 Exp $$
 */
public class Consumer {

    /** 连接工厂实例 */
    private static ConnectionFactory connectionFactory;

    static {
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
    }

    public static void main(String[] args) {
        Connection connection = null;
        Session session = null;
        Destination destination = null;
        MessageConsumer consumer = null;

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(Boolean.FALSE, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("demo");
            consumer = session.createConsumer(destination);

            while (true) {
                TextMessage msg = (TextMessage) consumer.receive(30000);
                if (null != msg) {
                    System.out.println("收到的消息：" + msg.getText());
                } else {
                    break;
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                consumer.close();
                session.commit();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}