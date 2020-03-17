package com.soft1851.spring.ioc.entity;

/**
 * @author CRQ
 */
public class Phone {
    private String phone;
    private Student student;

    public Phone(String phone,Student student) {
        this.phone = phone;
        this.student = student;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "phone='" + phone + '\'' +
                ", student=" + student +
                '}';
    }

    public Phone() {
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
