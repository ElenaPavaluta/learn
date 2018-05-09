package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance;

interface Getter extends GenericGetter<Getter> {
}
