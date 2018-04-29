package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes.templateMethodDesignPattern;

abstract class GenericWithCreate<T> {

    final T element;

    public GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class X{}

class Creator extends GenericWithCreate<X>{
    @Override
    X create() {
        return new X();
    }

    void f(){
        System.out.println(element.getClass().getSimpleName());
    }
}

class Run{
    public static void main(String[] args) {
        Creator c= new Creator();
        c.f();
    }
}
