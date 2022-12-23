package com.example.javavirtualmachine8105._1_classload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * @author liyanhao
 * @Date 2022-12-20 22:20
 */
public class TomcatClassLoaderTest {
    static class TomcatClassLoader extends ClassLoader {
        private String classPath;

        public TomcatClassLoader(String classPath) {
            this.classPath = classPath;
        }

        private byte[] loadByte(String name) throws Exception {
            name = name.replace(".", "/");
            FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
            int len = fis.available();
            byte[] data = new byte[len];
            fis.read(data);
            fis.close();
            return data;
        }

        private Class<?> finClass(String name) throws Exception {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        }




        //重写类加载方法 实现自己的加载逻辑 不委派给双亲
        protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
            synchronized (getClassLoadingLock(name)) {
                Class<?> c = findLoadedClass(name);
                if (c == null) {
                    long t1 = System.nanoTime();
                    //非自定义的类还是走双亲委派加载
                    if (!name.startsWith("com.example")) {
                        c = this.getParent().loadClass(name);
                    } else {
                        try {
                            c = finClass(name);
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                    sun.misc.PerfCounter.getFindClasses().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
                if (resolve) {
                    resolveClass(c);
                }
                return c;
            }

        }

        //观察是不同的对象  所以通过重写loadClass可以打破双亲委派机制 从而得到一个class的加载器信息

        public static void main(String[] args) throws Exception {

            TomcatClassLoader tomcatClassLoader = new TomcatClassLoader("d:/test");
            Class<?> clazz = tomcatClassLoader.loadClass("com.example.javavirtualmachine8105.entity.User");
            Object o = clazz.newInstance();
            Method sout = clazz.getDeclaredMethod("sout", null);
            sout.invoke(o, null);
            System.out.println(clazz.getClassLoader());
            System.out.println();
            TomcatClassLoader tomcatClassLoader1 = new TomcatClassLoader("d:/test");
            Class<?> clazz1 = tomcatClassLoader1.loadClass("com.example.javavirtualmachine8105.entity.User");
            Object o1 = clazz1.newInstance();
            Method sout1 = clazz.getDeclaredMethod("sout", null);
            sout1.invoke(o, null);
            System.out.println(clazz1.getClassLoader());
            System.out.println();

        }


    }
}
