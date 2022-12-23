package com.example.javavirtualmachine8105._3_memoryallocation;

import com.example.javavirtualmachine8105.entity.User;

import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.TimeUnit;

/**
 * @author liyanhao
 * @Date 2022-12-22 16:13
 * 强软弱虚四种引用类型测试
 */
public class ReferenceTypeTest {
    public static void main(String[] args) throws InterruptedException {

       // testStrongReference();
        testSoftReference();

    }

    public static void testSoftReference(){
        Long[] longs = new Long[1024 * 1024 * 1024*1024*1024*1024];
        SoftReference<Long[]> userSoftReference = new SoftReference<>(longs);
        Long[] longs1 = userSoftReference.get();
        System.out.println(longs1);
        Long[] l = new Long[1024 * 1024*1024*1024*1024*1024 * 1024 * 1024*1024*1024*1024 * 1024 * 1024*1024*1024*1024 * 1024 * 1024*1024*1024*1024 * 1024 * 1024*1024*1024*1024];
        System.out.println(longs1);

    }

    public static void testStrongReference() throws InterruptedException {
        //强引用
        String str = "hello world";
        TimeUnit.MINUTES.sleep(10);
        //取消引用
        str = null;
        //取消引用后 jvm会在适合的时间里边回收调
    }
}
