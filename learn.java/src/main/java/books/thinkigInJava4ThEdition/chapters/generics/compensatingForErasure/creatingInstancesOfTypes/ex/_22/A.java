package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes.ex._22;


class A {

    public A(A2 a2, A3 a3, A4 a4) {
        System.out.println("A constructed");
    }

    static class A2{}

    static class A3{}

    static class A4{}
}
