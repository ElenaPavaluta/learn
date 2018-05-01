package books.thinkigInJava4ThEdition.chapters.generics.wildcards;

class CovariantArrays {
    static void m(){
        Fruit[] fruits = new Apple[10];

        fruits[0] = new Apple();
        fruits[1] = new Jonathan();

        /**
         * RE: ArrayStoreException
         *The runtime type (the actual type)
         * of the array is Apple[]
         * Although the compiler is happy a RE
         * gets thrown
         */
//        fruits[2] = new Fruit();
//        fruits[3] = new Orange();
    }

    static void m2(){
        Fruit[] fruits = new Fruit[10];
        fruits[0] = new Jonathan();
        fruits[1] = new Apple();
        fruits[3] = new Orange();
        fruits[4] = new Fruit();
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
