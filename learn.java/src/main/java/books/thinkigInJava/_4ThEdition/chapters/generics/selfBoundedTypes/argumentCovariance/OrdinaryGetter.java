package books.thinkigInJava._4ThEdition.chapters.generics.selfBoundedTypes.argumentCovariance;

interface OrdinaryGetter {

    Base get();
}

interface DerivedOrdinaryGetter extends OrdinaryGetter{

    /**
     * Return dbType of overridden method is allow to vary
     * (as long as it is a subclass)
     */

    @Override
    Derived get();
}
