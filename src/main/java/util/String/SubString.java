/**
 * Fayuan.com Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package util.String;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 用string的subString方法实现简单正则表达式功能
 *
 * @author mr.24
 * @version $Id: SubString.java, v 0.1 2018年02月04日 上午11:31 mr.24 Exp $
 */
public class SubString {
    public static void main(String[] args) {
        String str = "1923456789";

        String resultString = str.substring(str.indexOf("1"), str.lastIndexOf("9"));
        String resultString1 = str.substring(str.indexOf("1"), str.indexOf("9") + 1);

        Pattern pattern = Pattern.compile("1(\\d+)9$");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.group(0));

        System.out.println(resultString);
        System.out.println(resultString1);
    }
}