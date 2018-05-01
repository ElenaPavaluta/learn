package books.thinkigInJava4ThEdition.chapters.generics.bounds.color;

class HoldItem<T> {
    T item;

    public HoldItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }
}
