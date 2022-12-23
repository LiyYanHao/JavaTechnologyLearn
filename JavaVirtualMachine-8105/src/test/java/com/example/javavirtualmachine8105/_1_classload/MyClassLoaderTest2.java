package com.example.javavirtualmachine8105._1_classload;


import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author liyanhao
 * @Date 2022-12-20 20:53
 */
public class MyClassLoaderTest2 {
    static class MyClassLoader extends ClassLoader {
        private String classPath;

        public MyClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadBytes(String name) throws IOException {
            name = name.replace("\\.", "/");
            FileInputStream fileInputStream = new FileInputStream(name + "/" + name + ".class");
            int available = fileInputStream.available();
            byte[] data = new byte[available];
            fileInputStream.read(data);
            fileInputStream.close();
            return data;
        }

        protected Class<?> findClass(String name) throws ClassNotFoundException {
            byte[] data = new byte[0];
            try {
                data = loadBytes(name);
                return defineClass(name, data, 0, data.length);
            } catch (IOException e) {
                throw new ClassNotFoundException();
            }
        }

        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                //1、检查class是否被加载过
                Class<?> c
                        = findLoadedClass(name);
                if (c == null) {
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader("D:/test");
        //尝试用自己改写类加载机制去加载自己写的java.lang.String.class
        Class<?> clazz = myClassLoader.loadClass("java.lang.String");
        Object o = clazz.newInstance();
        Method sout = clazz.getDeclaredMethod("sout", null);
        Object invoke = sout.invoke(o, null);
        System.out.println(clazz.getClassLoader().getClass().getName());

    }
}
