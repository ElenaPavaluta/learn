package books.thinkigInJava4ThEdition.chapters.generics.theMysteryOfErasure;

import java.util.*;

/**
 * There’s no information about generic parameter types available
 * inside generic code
 */
class LostInformation {

    static void m(){
        List<Frob> list = new ArrayList<>();
        Map<Frob, Fnorkle> map = new HashMap<>();
        Quark<Fnorkle> quark = new Quark<>();
        Particle<Long, Double> p = new Particle<>();
        Bla<Long, Long> b = new Bla<>();

        System.out.println(Arrays.toString(list.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(map.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(quark.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(p.getClass().getTypeParameters()));

        System.out.println(Arrays.toString(b.getClass().getTypeParameters()));
    }

    public static void main(String[] args) {
        m();
    }
}
