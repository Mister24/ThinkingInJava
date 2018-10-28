/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package net.httpUrlConnection;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

/**
 * HttpUrlConnection用于http请求测试
 *
 * @author mr.24
 * @version Id: HttpUrlConnectionDemo, v 1.0 2018/10/28 下午2:52 Exp $$
 */
public class HttpUrlConnectionDemo {

    public static void main(String[] args) {

        String getResponstByRequest = get();

        String getResponstByPost = post();
        System.out.println(getResponstByPost);
    }

    /**
     *
     * @return 返回的结果
     */
    public static String get() {
        String res = "";

        try {
            URL url = new URL("https://httpbin.org/get");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5 * 1000);
            connection.connect();

            InputStream inputStream = connection.getInputStream();
            byte[] data = new byte[1024];
            StringBuilder stringBuilder = new StringBuilder();
            int length = 0;
            while (inputStream.read(data) != -1) {
                String string = new String(data, Charset.forName("utf-8"));
                stringBuilder.append(string);
            }

            //获取statusCode
            int statusCode = connection.getResponseCode();
            System.out.println("statusCode = " + statusCode);

            Map<String,List<String>> header = connection.getHeaderFields();
            System.out.println(header);

            res = stringBuilder.toString();
            inputStream.close();
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    /**
     *
     * post方式
     * */
    @Test
    public static String post() {

        String msg = "";

        try {
            URL url = new URL("https://httpbin.org/post");
            String bodyString = "password=e10adc3949ba59abbe56e057f20f883e&amp;username=test3";
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // 请求方式
            connection.setRequestMethod("POST");

            // 超时时间
            //connection.setConnectTimeout(5 * 1000);

            // 是否输出
            connection.setDoOutput(true);

            // 是否读入
            //connection.setDoInput(true);

            // 是否使用缓存
            //connection.setUseCaches(false);

            // 是否应该自动执行 HTTP 重定向
            //connection.setInstanceFollowRedirects(true);

            // 连接
            //connection.connect();

            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(bodyString.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();

            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                String line = bufferedReader.readLine();
                while (line != null) {
                    msg += line + "\n";

                }

                bufferedReader.close();
            }

            // 关闭连接
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return msg;
    }


}
