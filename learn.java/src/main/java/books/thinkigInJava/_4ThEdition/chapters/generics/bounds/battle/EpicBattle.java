package books.thinkigInJava._4ThEdition.chapters.generics.bounds.battle;

import java.util.List;

/**
 * Wildcards are limited to a single bound
 */
class EpicBattle {
    static <POWER extends SuperHearing> void useSuperHearing(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
    }

    static <POWER extends SuperHearing & SuperSmell> void superFind(SuperHero<POWER> hero){
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    static void m(){
        List<? extends SuperHearing> lst;

        //wilcards are limited to a single bound
//        List<? extends SuperHearing & SuperSmell> lst2;
    }

    public static void main(String[] args) {
        DogBoy dogBoy = new DogBoy();
        useSuperHearing(dogBoy);
        superFind(dogBoy);
    }
}
