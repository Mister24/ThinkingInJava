/**
 * fzw.com Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package com.fzw.basicjava.no001_Enum;

/**
 *
 * @author mr.24
 * @version $Id: EnumTest.java, v 0.1 2018年01月21日 下午11:05 mr.24 Exp $
 */
public class EnumTest {
    private Day day;

    private EnumTest(Day day) {
        this.day = day;
    }

    /**
     * 打印日期信息
     *
     * */
    private void dayInfo() {
        switch (day) {
            case MONDAY:
                System.out.println("today is Monday.");
                break;

            case TUESDAY:
                System.out.println("today is Tuesday.");
                break;

            case WEDNESDAY:
                System.out.println("today is WEDNESDAY.");
                break;

                default:
                    System.out.println("嗯哼？");
                    break;
        }
    }

    public static void main(String[] args) {
        EnumTest firstDay = new EnumTest(Day.MONDAY);
        firstDay.dayInfo();

        EnumTest secondDay = new EnumTest(Day.TUESDAY);
        secondDay.dayInfo();
    }
}