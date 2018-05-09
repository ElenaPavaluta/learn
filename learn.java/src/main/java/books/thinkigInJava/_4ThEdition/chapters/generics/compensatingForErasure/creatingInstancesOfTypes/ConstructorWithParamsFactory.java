package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes;

class ConstructorWithParamsFactory implements FactoryI<ContructorWithParams> {
    @Override
    public ContructorWithParams create() {
        return new ContructorWithParams(this.getClass().getSimpleName());
    }
}
