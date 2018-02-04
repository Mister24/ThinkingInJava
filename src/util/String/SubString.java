/**
 * Fayuan.com Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package util.String;

/**
 *
 * @author mr.24
 * @version $Id: SubString.java, v 0.1 2018年02月04日 上午11:31 mr.24 Exp $
 */
public class SubString {
    public static void main(String[] args) {
        String str = "1923456789";

        String resultString = str.substring(str.indexOf("1"), str.lastIndexOf("9"));
        String resultString1 = str.substring(str.indexOf("1"), str.indexOf("9") + 1);
        System.out.println(resultString);
        System.out.println(resultString1);
    }
}