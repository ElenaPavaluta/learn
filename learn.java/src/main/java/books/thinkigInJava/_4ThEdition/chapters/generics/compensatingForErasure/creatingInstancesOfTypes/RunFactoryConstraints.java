package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes;

class RunFactoryConstraints {

    public static void main(String[] args) {
        new Foo2<ContructorWithParams>(new ConstructorWithParamsFactory());
        new Foo2<Widget>(new Widget.Factory());    }
}
