/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.fayuan.maker;
import java.lang.Math;
/**
 *
 * @author mr.24
 * @version $Id: ReportMaker.java, v 0.1 2018年01月31日 下午8:01 mr.24 Exp $
 */
public class ReportMaker {
    public static void main(String[] args) {
        String[] str1 = {"我觉得", "我认为", "我的观点是"};
        String[] str2 = {"这只股票", "这家公司", "这各行业"};
        String[] str3 = {"前景不错", "值得推荐", "挺好的"};
        System.out.println(str1[(int)(Math.random() *3)] + str2[(int)(Math.random() *3)] + str3[(int)(Math.random() *3)]);
    }
}