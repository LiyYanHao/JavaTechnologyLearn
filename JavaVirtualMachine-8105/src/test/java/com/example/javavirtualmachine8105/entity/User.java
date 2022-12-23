package com.example.javavirtualmachine8105.entity;

/**
 * @author liyanhao
 * @Date 2022-12-20 10:28
 */
public class User {
    public void sout() {
        System.out.println("---User---Sout---");
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
