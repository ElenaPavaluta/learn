package books.thinkigInJava._4ThEdition.chapters.generics.issues.castingAndWarnings;

class FizedSizeStack<T> {

    private int index = 0;
    private Object[] storage;

    public FizedSizeStack(int size) {
        this.index = index;
        storage = new Object[size];
    }

    void push(T item){
        storage[index++] = item;
    }

    T pop(){
        return (T)storage[--index];
    }

    public static void main(String[] args) {
        FizedSizeStack<String> strings = new FizedSizeStack<>(7);
        for(String s: "a b c d e f g".split(" ")){
            strings.push(s);
        }

        for(int i = 0; i<7; i++){
            String s = strings.pop();
            System.out.println(s);
        }
    }
}
