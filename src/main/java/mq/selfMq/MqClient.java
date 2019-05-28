/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2019 All Rights Reserved.
 */
package mq.selfMq;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 * 客户端
 *
 * @author mr.24
 * @version Id: MqClient, v 1.0 2019-05-27 12:56 Exp $$
 */
public class MqClient {

    /**
     * 生产消息
     *
     * @param message 消息内容
     * */
    public void produce(String message) throws Exception {

        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        // try () {} 的使用，()中的代码一般放的是对资源的申请，
        // 如果{}中的代码出项了异常，（）中的资源就会被关闭，
        // resources是在程序结束后必须关闭的对象，使用这种方式就不需要再手动关闭资源，
        // 这在inputstream和outputstream的使用中会很方便。
        try (
            PrintWriter out = new PrintWriter(socket.getOutputStream())
        ) {
            out.println(message);
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 消费消息
     *
     * 消息内容
     * */
    public String consume() throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), BrokerServer.SERVICE_PORT);
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream());
        ) {
            // 先向消息队列发送字符串"CONSUME"标识消费
            out.println("CONSUME");
            out.flush();
            // 再从消息队列获取一条消息
            String message = in.readLine();

            return message;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
