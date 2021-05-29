/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.apache.client;

import com.alibaba.fastjson.JSONObject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Map;

/**
 *
 * @author fzw.fzw
 * @version $Id: HttpClientUtil.java, v 0.1 2018年10月08日 下午7:52 fzw.fzw Exp $
 */
public class HttpClientUtil {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    private static ResponseParser responseParser = new JsonResponseParser();

    public static Map<String, Object> postRawData(String url, Map<String, Object> reqParams) {

        //获取response结果
        String resp = postRawData2Str(url, reqParams);

        //返回响应信息
        return responseParser.parse(resp);
    }

    /**
     * rawData形式发送post请求
     *
     * @param url
     * @param reqParams 请求参数
     *
     * @return          返回结果
     * */
    public static String postRawData2Str(String url, Map<String, Object> reqParams) {
        String resp = "";

        StringEntity stringEntity = new StringEntity(JSONObject.toJSONString(reqParams), ContentType.create("text/plain", "UTF-8"));

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(stringEntity);

        CloseableHttpResponse httpResponse = null;

        try {
            httpResponse = httpClient.execute(httpPost);
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                try {
                    httpResponse.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (resp == null || resp.equals("")) {
            return "";
        }

        return resp;
    }
}