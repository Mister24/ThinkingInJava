/**
 * @Company Mister24.com Inc.
 * @Copyright Copyright (c) 2016-2018 All Rights Reserved.
 */
package net.httpUrlConnection;

import java.io.InputStream;
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

        String getRequest = get();
        System.out.println(getRequest);
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


}
