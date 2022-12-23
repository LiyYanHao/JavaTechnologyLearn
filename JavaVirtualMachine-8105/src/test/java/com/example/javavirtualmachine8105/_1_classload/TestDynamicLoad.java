package com.example.javavirtualmachine8105._1_classload;


/**
 * @author liyanhao
 * @Date 2022-12-20 15:10
 */
public class TestDynamicLoad {
    static {
        System.out.println("***********load testDynamicLoad*******1***********");
    }

    public static void main(String[] args) {
        new A();
        System.out.println("***********load test****6********");
        B b = null;//B不会加载，除非在这里执行new B()
    }
}
class A{
    static {
        System.out.println("************load A*****2*****");
    }
    public A(){
        System.out.println("**********initial A******4*********");
    }
}
class B{
    static {
        System.out.println("********initial B*****3**");
    }
    public B(){
        System.out.println("*********initial B*****5***");
    }
}