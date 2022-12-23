package com.example.javavirtualmachine8105._2_JVMstructure;

/**
 * @author liyanhao
 * @Date 2022-12-21 10:34
 * StackOverflowError
 */
public class StackOverflowTest {
    static int count = 0;

    public static void add() {
        count++;
        add();
    }
    public static void main(String[] args) {
        try {
            add();
        } catch (Throwable e) {
            System.out.println(count);
        }
    }
}
