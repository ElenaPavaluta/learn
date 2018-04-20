package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.generalPurposeGenerator;

import java.time.LocalDateTime;
import java.util.Random;

class BasicGenerator<T> implements Generator<T> {
    Class<T> type;
    Random r = new Random(47);

    public BasicGenerator(Class<T> type) {
        this.type = type;
    }

    static <T> Generator<T> create(Class<T> type) {
        return new BasicGenerator<>(type);
    }

    public static void main(String[] args) {
        Generator<LocalDateTime> gLdt = create(LocalDateTime.class);
        System.out.println(gLdt.next());
    }

    void tE() throws E {
        if(r.nextBoolean()) {
            throw new E();
        }
    }

    @Override
    public T next() {
        try {
            tE();
            return type.newInstance();
        } catch(InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        } catch(RuntimeException e) {
            //no issue here
        } catch(E e) {
            next();
        }
        return null;
    }
}

class E extends Exception {
    public E() {
    }
}
