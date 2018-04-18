package books.thinkigInJava4ThEdition.chapters.generics.genericInterfaces.coffe;

import java.util.stream.IntStream;

class Run {
    public static void main(String[] args) {
        m();
        m2();
    }

    private static void m2(){
        for(Coffe c: new CoffeGenerator(5)){
            System.out.println(c);
        }
    }

    private static void m() {
        CoffeGenerator cg  =new CoffeGenerator();
        IntStream.range(0, 5).forEach(i-> System.out.println(cg.next()));
        System.out.println();
    }
}
