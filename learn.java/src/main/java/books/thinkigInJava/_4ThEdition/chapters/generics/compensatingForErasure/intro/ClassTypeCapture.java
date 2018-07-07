package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.intro;

import java.time.LocalDateTime;

class ClassTypeCapture<T> {
    Class<T> kind;

    ClassTypeCapture(Class<T> kind){
        this.kind = kind;
    }

    boolean f(Object arg){
        return kind.isInstance(arg);
    }

    public static void main(String[] args) {
//        createAndPopulate();
    }

    private static void m() {
        ClassTypeCapture<Building> cb = new ClassTypeCapture<>(Building.class);

        System.out.println(cb.f(new Building()));  //true
        System.out.println(cb.f(new House()));  //true
        System.out.println(cb.f(new House2()));  //true
        System.out.println(cb.f(new Object()));  //false
        System.out.println(cb.f(LocalDateTime.now()));  //false

        System.out.println();

        Building b = new Building();
        System.out.println(b instanceof Building);  //true
        System.out.println(b instanceof House); //false
        System.out.println(b instanceof House2);  //false
        System.out.println(b instanceof Object);  //true
//        System.out.println(b instanceof LocalDateTime);  //compiler error
    }

    private static void m2(){
        ClassTypeCapture<House> ch = new ClassTypeCapture<>(House.class);

        System.out.println(ch.f(new Building()));  //false
        System.out.println(ch.f(new House()));  //true
        System.out.println(ch.f(new House2()));  //false
        System.out.println(ch.f(new Object()));  //false
        System.out.println();
    }


}
