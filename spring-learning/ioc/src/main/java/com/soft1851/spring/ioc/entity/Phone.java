package com.soft1851.spring.ioc.entity;

/**
 * @author CRQ
 */
public class Phone {
    private String phone;
    private Double price;
    private Student student;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Phone(String phone,Double price,Student student) {
        this.phone = phone;
        this.price = price;
        this.student = student;
    }


    @Override
    public String toString() {
        return "Phone{" +
                "phone='" + phone + '\'' +
                ", price=" + price +
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
