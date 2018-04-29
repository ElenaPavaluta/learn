package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes;

class Foo2<T> {

    private T t;

    <F extends FactoryI<T>> Foo2(F factory){
        t =  factory.create();
    }
}

