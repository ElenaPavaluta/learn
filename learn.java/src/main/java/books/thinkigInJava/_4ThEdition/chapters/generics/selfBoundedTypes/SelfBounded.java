package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes;

/**
 * Has the dizzying effect of 2 mirrors pointing at each other
 * @param <T>
 */
class SelfBounded<T extends SelfBounded<T>> {
}
