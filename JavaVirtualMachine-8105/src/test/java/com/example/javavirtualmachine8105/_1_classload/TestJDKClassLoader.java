package com.example.javavirtualmachine8105._1_classload;

import sun.misc.Launcher;

import java.net.URL;

/**
 * @author liyanhao
 * @Date 2022-12-20 15:22
 * 类加载器示例
 */
public class TestJDKClassLoader {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(com.sun.crypto.provider.DESedeKeyFactory.class.getClassLoader().getClass().getName());
        System.out.println(TestJDKClassLoader.class.getClassLoader().getClass().getName());
        System.out.println();
        ClassLoader appclassloader = ClassLoader.getSystemClassLoader();
        ClassLoader extClassLoader = appclassloader.getParent();
        ClassLoader bootstrapLoader = extClassLoader.getParent();
        System.out.println("the bootstrapLoader:" + bootstrapLoader);
        System.out.println("the extClassLoader:" + extClassLoader);
        System.out.println("the appclassloader:" + appclassloader);
        System.out.println();
        System.out.println("bootstrapLoader加载一下文件:");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL);
        }

        System.out.println();
        System.out.println("extClassLoader加载一下文件:");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println();
        System.out.println("appClassLoader加载一下文件：");
        System.out.println(System.getProperty("java.class.path"));
    }

}
