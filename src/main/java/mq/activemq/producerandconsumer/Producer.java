/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package mq.activemq.producerandconsumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * 消息生产者
 *
 * @author mr.24
 * @version Id: Producer, v 1.0 2019/4/6 上午12:22 Exp $$
 */
public class Producer {

    /**
     * 连接工厂实例
     */
    private static ConnectionFactory connectionFactory;

    /**
     * 消息长度
     */
    private static final Integer MESSAGE_NO = 20;

    static {
        connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER, ActiveMQConnectionFactory.DEFAULT_PASSWORD, "tcp://localhost:61616");
    }

    /**
     * 发送消息
     *
     * @param session  会话
     * @param producer 生产者
     */
    public static void send(Session session, MessageProducer producer) throws JMSException {
        for (int i = 0; i < MESSAGE_NO; i++) {
            // 创建消息
            TextMessage msg = session.createTextMessage("消息" + i);

            // 发送消息
            producer.send(msg);
            System.out.println("发送消息：消息" + i);
        }
    }

    public static void main(String[] args) {
        // 连接
        Connection connection = null;
        // 会话
        Session session = null;
        // 目的地
        Destination destination;
        // 生产者
        MessageProducer producer;

        try {
            // 1. 获取消息连接
            connection = connectionFactory.createConnection();
            // 2. 开启连接
            connection.start();
            // 3. 通过连接建立会话
            session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
            // 4. 建立消息队列
            destination = session.createQueue("queue");
            // 5. 创建发送者，将消息发送到消息队列
            producer = session.createProducer(destination);
            // 6. 发送消息
            send(session, producer);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                session.commit();
                connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }
}
