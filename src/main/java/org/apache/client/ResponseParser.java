/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package org.apache.client;

import java.util.Map;

/**
 * 回复消息
 *
 * @author fayuan.fzw
 * @version $Id: ResponseParser.java, v 0.1 2018年10月08日 下午7:59 fayuan.fzw Exp $
 */
public interface ResponseParser {

    /**
     * 解析http响应信息
     *
     * @param resp 响应信息
     *
     * @return     返回的内容
     * */
    Map<String, Object> parse(String resp);
}