package com.stu.util;


import java.text.DecimalFormat;

public class NumberUtil {
    /**
     * 小数位
     */
    public static String fillZero(Double number) {
        DecimalFormat format = new DecimalFormat("0.000");
        String num = format.format(number);
        return num;
    }
    /**
     * 生成四位序列号
     * @param number
     * @return
     */
    public static String fillZero(Integer number) {
        DecimalFormat format = new DecimalFormat("0.000");
        String num = format.format(number);
        return num;
    }

    public static void main(String[] args) {
        Double number=23.38;
        System.out.println(fillZero(number));
    }



}
