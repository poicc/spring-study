package com.soft1851.spring.ioc.entity;

/**
 * @author CRQ
 */
public class Student {
    private Integer id;
    private String name;
//    private List<String> hobbies;
//    private Map<String,Student> single;
//    private Set<Student> fruits;


//    public Set<Student> getFruits() {
//        return fruits;
//    }
//
//    public void setFruits(Set<Student> fruits) {
//        this.fruits = fruits;
//    }
//
//    public void setSingle(Map<String, Student> single) {
//        this.single = single;
//    }
//
//    public Map<String, Student> getSingle() {
//        return single;
//    }
//
//    public void setSex(Map<String, Student> single) {
//        this.single = single;
//    }

    public Student(String name,Integer id) {
        this.name = name;
        this.id = id;

    }



//    public List<String> getHobbies() {
//        return hobbies;
//    }
//
//    public void setHobbies(List<String> hobbies) {
//        this.hobbies = hobbies;
//    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
//                ", hobbies=" + hobbies +
//                ", single=" + single +
//                ", fruits=" + fruits +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public Student() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
