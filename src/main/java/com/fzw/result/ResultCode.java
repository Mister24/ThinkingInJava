/**
 * fzw.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fzw.result;

import java.io.Serializable;

/**
 *
 * @author fzw.fzw
 * @version $Id: ResultCode.java, v 0.1 2018年06月19日 下午10:31 fzw.fzw Exp $
 */
public class ResultCode implements Serializable {

    /** 错误码前缀 */
    private static final String PREFIX = "fzw_RS_";

    /** 错误码类型 */
    private String codeType;

    /** 错误码级别 */
    private String codeLevel;

    /** 错误信息描述 */
    private String errorDescription;
}