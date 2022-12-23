package com.example.javavirtualmachine8105._1_classload;

import com.example.javavirtualmachine8105.entity.User;

/**
 * @author liyanhao
 * @Date 2022-12-20 10:27
 */
//记载主类到虚拟机里
public class Math {
    public static final int initData = 666;
    public static User user = new User();

    //一个方法对应一块栈帧内存区域
    public int compute() {
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Math math = new Math();
        math.compute();
    }


}
