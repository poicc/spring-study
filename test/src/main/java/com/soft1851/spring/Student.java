package com.soft1851.spring;

/**
 * @author CRQ
 */
public class Student {
    private String name;
    private Phone phone;

    public Student() {
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                '}';
    }

    public Student(String name, Phone phone){
        this.name =name;
        this.phone = phone;


    }
}
