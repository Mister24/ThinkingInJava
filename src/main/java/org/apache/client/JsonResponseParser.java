/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.apache.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import leetcode.reOrderList_143.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author fayuan.fzw
 * @version $Id: JsonResponseParser.java, v 0.1 2018年10月08日 下午8:02 fayuan.fzw Exp $
 */
public class JsonResponseParser implements ResponseParser {
    /**
     * 解析http响应信息
     *
     * @param resp 响应信息
     *
     * @return 返回的内容
     * */
    @Override
    public Map<String, Object> parse(String resp) {
        JSONObject jsonObject = JSONObject.parseObject(resp);
        return parseJson(jsonObject);
    }

    private Map<String, Object> parseJson(JSONObject jsonObject) {
        Map<String, Object> map = new HashMap<>();
        Iterator<Map.Entry<String, Object>> iterator = jsonObject.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<String, Object> params = iterator.next();

            if (params.getValue() instanceof JSONObject) {
                map.put(params.getKey(), parseJson((JSONObject) params.getValue()));
            } else if (params.getValue() instanceof JSONArray) {
                map.put(params.getKey(), jsonToList(params.getValue()));
            } else {
                map.put(params.getKey(), params.getValue());
            }
        }

        return map;
    }

    private List<Map<String, Object>> jsonToList(Object object) {
        JSONArray jsonArray = (JSONArray) object;

        List<Map<String, Object>> list = new ArrayList<>();

        for (int i =  0; i < list.size(); i++) {
            list.add(parseJson(jsonArray.getJSONObject(i)));
        }

        return list;
    }
}