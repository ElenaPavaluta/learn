package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes;

class ClassAsFactory<T> {
    T t;

    public ClassAsFactory(Class<T> kind) {
        try {
            t = kind.newInstance();
        } catch(InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
