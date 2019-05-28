/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package mq.selfMq;

/**
 * 消费者
 *
 * @author mr.24
 * @version Id: ConsumeClient, v 1.0 2019-05-28 12:24 Exp $$
 */
public class ConsumeClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
        String message = client.consume();
        System.out.println("获取的消息为：" + message);
    }
}
