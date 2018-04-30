package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.arraysOfGenerics;

class ArrayOfGenericReference {

    /**
     * compiler error: Generic array creation
     */
//    static Generic<Integer>[] gia =new Generic<Integer>[3];

    static Generic[] gia2 = new Generic[3];
}
