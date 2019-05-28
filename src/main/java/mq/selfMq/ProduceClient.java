/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package mq.selfMq;

/**
 * 生产者
 *
 * @author mr.24
 * @version Id: ProduceClient, v 1.0 2019-05-28 12:15 Exp $$
 */
public class ProduceClient {
    public static void main(String[] args) throws Exception {
        MqClient client = new MqClient();
        client.produce("hello world");
    }
}
