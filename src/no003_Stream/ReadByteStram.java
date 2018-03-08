/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package no003_Stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author fayuan.fzw
 * @version $Id: ReadByteStram.java, v 0.1 2018年02月19日 下午8:45 fayuan.fzw Exp $
 */
public class ReadByteStram {
    public static void main(String[] args) {
        try {
            FileInputStream fileInputStream = new FileInputStream("ThinkingInJava/src/no003_Stream/txt.txt");

        } catch(FileNotFoundException exception) {
            exception.printStackTrace();
        }
    }
}