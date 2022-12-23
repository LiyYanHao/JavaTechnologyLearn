package com.example.javavirtualmachine8105._3_memoryallocation;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author liyanhao
 * @Date 2022-12-21 17:12
 * 计算对象大小
 */
public class JOLSample {
    public static void main(String[] args) {
        ClassLayout classLayout = ClassLayout.parseInstance(new Object());
        System.out.println(classLayout.toPrintable());

        ClassLayout classLayout1 = ClassLayout.parseInstance(new int[]{});
        System.out.println(classLayout1.toPrintable());

        System.out.println();
        ClassLayout classLayout2 = ClassLayout.parseInstance(new A());
        System.out.println(classLayout2.toPrintable());
    }

    //‐XX:+UseCompressedOops 默认开启的压缩所有指针
     //‐XX:+UseCompressedClassPointers默认开启的压缩对象头里的类型指针KlassPointe

    public static class A {
        int id;//4BKlassPointer如果关闭压缩‐XX:‐UseCompressedClassPointers或‐XX:‐UseCompressedOops，则占用8B
        String name;//4B如果关闭压缩‐XX:‐UseCompressedOops，则占用8B
        byte b;
        Object o;//4B如果关闭压缩‐XX:‐UseCompressedOops，则占用8B
    }
}
