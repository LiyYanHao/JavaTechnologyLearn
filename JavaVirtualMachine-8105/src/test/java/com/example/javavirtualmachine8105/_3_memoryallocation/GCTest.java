package com.example.javavirtualmachine8105._3_memoryallocation;

/**
 * @author liyanhao
 * @Date 2022-12-22 15:00
 * //添加运行JVM参数：-XX:+PrintGCDetails
 */
public class GCTest {
    public static void main(String[] args) {
        byte[] allocation1,allocation2,allocation3,allocation4;
        allocation1 = new byte[60000 * 1024];
        allocation2 = new byte[8000 * 1024];
        allocation3 = new byte[8000 * 1024];
        allocation4 = new byte[800000 * 1024];

    }
}
