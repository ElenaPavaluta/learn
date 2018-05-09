package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes;

class Widget {

    static class Factory implements FactoryI<Widget>{
        @Override
        public Widget create() {
            return new Widget();
        }
    }
}
