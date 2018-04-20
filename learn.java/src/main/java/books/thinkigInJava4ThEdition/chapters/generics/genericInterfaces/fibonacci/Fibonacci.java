package books.thinkigInJava4ThEdition.chapters.generics.genericInterfaces.fibonacci;

import java.util.stream.IntStream;

class Fibonacci implements Generator<Integer> {
    private int count =0;


    @Override
    public Integer next() {
        return fib(count++);
    }

    private Integer fib(int n) {
        if(n<2){
            return 1;
        }
        return fib(n-2) + fib(n-1);
    }

    public static void main(String[] args) {
        Generator<Integer> g = new Fibonacci();
        IntStream.range(0, 18)
                 .forEach(i-> System.out.println(g.next()));
    }
}
