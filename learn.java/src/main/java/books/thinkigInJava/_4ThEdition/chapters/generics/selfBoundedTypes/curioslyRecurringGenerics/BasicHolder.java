package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.curioslyRecurringGenerics;

public class BasicHolder<T> {
    private T element;
    public void set(T element){
        this.element =  element;
    }

    public T get(){
        return element;
    }

    public void print(){
        System.out.println(this.getClass().getSimpleName());
    }
}
