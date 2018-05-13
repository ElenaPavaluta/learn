package books.thinkigInJava._4ThEdition.chapters.generics.exceptions.ex._36;

import java.util.function.Supplier;

class ExcepSupplier implements Supplier<RuntimeException> {
    static  int count = 0;
    @Override
    public RuntimeException get() {
        return new CustomException();
    }

    private class CustomException extends RuntimeException{
        public CustomException() {
            super("Custom exception: " + ++count);
        }
    }
}
