package com.example.javavirtualmachine8105._3_memoryallocation;

import com.example.javavirtualmachine8105.entity.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @author liyanhao
 * @Date 2022-12-22 16:00
 * 常见的引用类型 强 软 弱 虚
 */
public class ReferenceType {
    //强引用
    // 变量s = 字符串对象"abc"的一个强引用
    // 注：只要给强引用对象赋空值null，该对象就可被垃圾回收器回收
    // 即：只要给强引用对象s赋空值null，该对象就可以被垃圾回收器回收。因为该对象此时不再含有其他强引用
    public static User user = new User();
    public static String s = "abc";

    public static void main(String[] args) {
        //软引用 虚拟机内存不够会回收该对象
        SoftReference<User> userSoftReference = new SoftReference<User>(new User());
        //弱引用 GC发生时就会被回收掉
        WeakReference<User> userWeakReference = new WeakReference<User>(new User());
        //虚引用 必须 和引用队列 （ReferenceQueue）联合使用
        // 即 当垃圾回收器准备回收一个对象时，若发现它还有虚引用，在回收对象的内存之前，把这个虚引用加入到与之关联的引用队列中
        ReferenceQueue<User> queue = new ReferenceQueue<User>();
        User user1 = new User();
        PhantomReference<User> userPhantomReference = new PhantomReference<User>(user1,queue);
        //在user1被回收后，user1会被假如到queue引用队列里边
        user1 = null;
    }


}
