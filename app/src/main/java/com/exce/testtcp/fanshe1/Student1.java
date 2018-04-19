package com.exce.testtcp.fanshe1;

/**
 * @Author Wangjj
 * @Create 2018/4/18.
 * @Content
 */
public class Student1 {

    public Student1() {

    }

    //**********字段*************//
    public String name;
    protected int age;
    char sex;
    private String phoneNum;

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", sex=" + sex
                + ", phoneNum=" + phoneNum + "]";
    }
}
