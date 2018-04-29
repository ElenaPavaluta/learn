package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes;

class DefaultConstructor {
}


class ContructorWithParams{
    public ContructorWithParams(String s) {
        System.out.println(s);
    }
}

class PrivateConstructor{
    private PrivateConstructor() {
    }
}
