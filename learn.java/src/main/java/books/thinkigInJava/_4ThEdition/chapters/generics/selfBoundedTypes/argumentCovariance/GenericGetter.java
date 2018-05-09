package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance;

interface GenericGetter<T extends GenericGetter<T>> {
    T get();
}
