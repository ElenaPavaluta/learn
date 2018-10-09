package oc.p.tests.chapters._11.q._13;

class Laptop extends Computer{
    String type  = "laptop";
}

class Computer{
    String type = "computer";

    public static void main(String[] args) {
        Computer computer = new Laptop();
        Laptop laptop = new Laptop();

        System.out.println(computer.type);  //computer
        System.out.println(laptop.type);  //laptop
    }
}
