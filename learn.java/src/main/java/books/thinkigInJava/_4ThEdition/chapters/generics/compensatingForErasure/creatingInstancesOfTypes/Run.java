package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes;

class Run {

    static void m(){
        ClassAsFactory<DefaultConstructor> caf = new ClassAsFactory<>(DefaultConstructor.class);

        System.out.println(caf.getClass().getSimpleName() + " intantiated");

        try {
            ClassAsFactory<ContructorWithParams> caf2 = new ClassAsFactory<>(ContructorWithParams.class);
        }catch(Exception e){
            System.out.println("caf2 instantion error: because it has no default constructor");
        }

        try{
            ClassAsFactory<PrivateConstructor> caf3 = new ClassAsFactory<>(PrivateConstructor.class);
        }catch(Exception e){
            System.out.println("caf3 instantiation error: private constructor");
        }
    }

    public static void main(String[] args) {
        m();
    }
}
