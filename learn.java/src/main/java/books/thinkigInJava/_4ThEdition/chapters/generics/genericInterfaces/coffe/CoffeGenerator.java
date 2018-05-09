package books.thinkigInJava._4ThEdition.chapters.generics.genericInterfaces.coffe;

import java.util.Iterator;
import java.util.Random;

class CoffeGenerator implements Generator<Coffe>, Iterable<Coffe> {
    private Class[] types =
            {Latte.class, Mocha.class, Cappucino.class,
                    Americano.class, Breeve.class,};
    private static Random rand = new Random(47);

    //for iteration
    private int size = 0;

    public CoffeGenerator(int size) {
        this.size = size;
    }

    CoffeGenerator() {
    }

    @Override
    public Coffe next() {
        try {
            return (Coffe) types[rand.nextInt(types.length)].newInstance();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iterator<Coffe> iterator() {
        return new CoffeIterator();
    }

    class CoffeIterator implements Iterator<Coffe>{
        int count = size;

        @Override
        public boolean hasNext() {
            return count>0;
        }

        @Override
        public Coffe next() {
            count--;
            return CoffeGenerator.this.next();
        }
    }
}
