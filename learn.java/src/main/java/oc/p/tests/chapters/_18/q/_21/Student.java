package oc.p.tests.chapters._18.q._21;

import java.io.Serializable;

class Student implements Serializable {

    private String name;
    private int age;
    private double grade;

    Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    String getName() {
        return name;
    }

    int getAge() {
        return age;
    }

    double getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade=" + grade +
                '}';
    }
}
