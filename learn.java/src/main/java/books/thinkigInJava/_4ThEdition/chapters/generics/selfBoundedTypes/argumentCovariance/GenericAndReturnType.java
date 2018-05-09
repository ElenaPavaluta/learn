package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance;

class GenericAndReturnType {

    void test(Getter g){
        Getter res = g.get();
        GenericGetter gg = g.get();  //Also the base type
    }
}
