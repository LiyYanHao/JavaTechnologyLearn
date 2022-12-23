package com.example.javavirtualmachine8105._1_classload;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author liyanhao
 * @Date 2022-12-20 20:27
 * 自定义类加载器
 */
public class MyClassLoaderTest{
    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws IOException {
            name = name.replace(".", "/");
            FileInputStream fileInputStream =
                    new FileInputStream(classPath + "/" + name + ".class");
            int available = fileInputStream.available();
            byte[] data = new byte[available];
            fileInputStream.read(data);
            fileInputStream.close();
            return data;
        }

        protected Class<?> findClass(String name) {
            byte[] data = new byte[0];
            try {
                data = loadByte(name);
                //defneClass 将一个字节数据转化为Class对象，这个字节数组是class文件读取后最终的字节数组
                return defineClass(name, data, 0, data.length);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
            //初始化自定义类加载器 会先初始化父类ClassLoader
            // 其中会把自定义类加载器的父加载器设置为应用程序加载器AppClassLoader
            MyClassLoader myClassLoader = new MyClassLoader("d:/test");
            //d盘创建 test/com/tuling/jvm几层目录 将User类的复制类User1.class丢入目录
            Class<?> clazz = myClassLoader.findClass("com.example.javavirtualmachine8105.entity.User");
            Object obj = clazz.newInstance();
            Method sout = clazz.getDeclaredMethod("sout", null);
            sout.invoke(obj, null);
            System.out.println(clazz.getClassLoader().getClass().getName());
        }
    }





}
