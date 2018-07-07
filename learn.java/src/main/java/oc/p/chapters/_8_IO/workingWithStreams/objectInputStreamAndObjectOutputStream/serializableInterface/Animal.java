package oc.p.chapters._8_IO.workingWithStreams.objectInputStreamAndObjectOutputStream.serializableInterface;

import java.io.Serializable;
import java.time.LocalDate;

class Animal implements Serializable{

    private String name;
    private int age;
    private Type type;
    private char c;
    private static int n = 21;
    private transient LocalDate localDate = LocalDate.now();

    public Animal(String name, int age, Type type, char c) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.c = c;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Type getType() {
        return type;
    }

    public char getC() {
        return c;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dbType=" + type +
                ", c=" + c +
                ", localDate=" + localDate +
                '}';
    }
}
