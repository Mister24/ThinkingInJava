/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package mq.selfMq;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 消息处理中心
 *
 * @author mr.24
 * @version Id: Broker, v 1.0 2019-05-27 12:12 Exp $$
 */
public class Broker {

    /** 消息队列中消息的最大数量 */
    private final static int MAX_SIZE = 3;

    /** 保存消息数据的容器 */
    private static ArrayBlockingQueue<String> messageQueue = new ArrayBlockingQueue<>(MAX_SIZE);

    /**
     * 生产消息
     *
     * @param msg 新的消息
     * */
    public static void produce(String msg) {
        if (messageQueue.offer(msg)) {
            System.out.println("成功向消息处理中心投递消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心暂存的消息达到最大负荷，不能继续放入消息！");
        }
    }

    /**
     * 消费消息
     *
     * */
    public static String consume() {
        String msg = messageQueue.poll();
        if (null != msg) {
            System.out.println("已消费消息：" + msg + "，当前暂存的消息数量是：" + messageQueue.size());
        } else {
            System.out.println("消息处理中心内没有消息可供消费！");
        }
        System.out.println("===");

        return msg;
    }
}
