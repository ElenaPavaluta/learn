package oc.p.chapters.c_4.workingWithBuiltInFunctionalInterface;

@FunctionalInterface
interface Consumer<T> {

    void accept(T t);
}

@FunctionalInterface
interface BiConsumer<T, U>{
    void accept(T t, U u);
}

class A2{

}
