package com.example.javavirtualmachine8105._3_memoryallocation;

import com.example.javavirtualmachine8105.entity.User;

/**
 * @author liyanhao
 * @Date 2022-12-21 17:37
 * 栈上分配 标量替换
 * 
 * 代码调用了1亿次alloc()，如果是分配到堆上，大概需要1GB以上堆空间，如果堆空间小于该值，必然会触发GC。
 * 
 * 使用如下参数不会发生GC
 * 6 *‐Xmx15m‐Xms15m‐XX:+DoEscapeAnalysis ‐XX:+PrintGC‐XX:+EliminateAllocations
 * 7 *使用如下参数都会发生大量GC
 * 8 *‐Xmx15m‐Xms15m‐XX:‐DoEscapeAnalysis‐XX:+PrintGC‐XX:+EliminateAllocations
 * 9 *‐Xmx15m‐Xms15m‐XX:+DoEscapeAnalysis‐XX:+PrintGC‐XX:‐EliminateAllocations
 */
public class AllotOnstack {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long end = System.currentTimeMillis();
        for (int i = 0; i <100000000; i++) {
            u();
        }
        System.out.println(end - start);

    }

    public static void u(){
        User user = new User();
        user.setAge(1);
        user.setName("liyanhao");

    }
}
