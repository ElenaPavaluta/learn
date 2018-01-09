package oc.p.chapters.c_4.usingVariablesInLambda;

/**
 * Lambda expressions can access:
 *
 * static variables
 *
 * instance variables
 *
 * effectively final method parameters
 *
 * effectively final local variables.
 */
class GorillaFamily {

    //static variableW
    static String walk2 = "walk2";
    //instance variable
    String walk = "walk";

    public static void main(String[] args) {
        GorillaFamily gf = new GorillaFamily();
        gf.everyonePlay(true);
    }

    //baby is effectively final method parameter
    void everyonePlay(boolean baby) {
 //        baby = true;  //generates a compiler error

        //effectively final local variable
        String approach = "amble";
        //approach = "run";  //generates a compiler error

        play(() -> walk);
        play(() -> walk2);
        play(() -> baby ? "hitch a ride" : "run");
        play(() -> approach);
    }

    void everyonePlaysWithMethodReference(boolean b){
        play(new Gorilla() {
            @Override
            public String move() {
                return walk;
            }
        });

        play(()->walk);

    }

    void play(Gorilla g) {
        System.out.println(g.move());
    }


    interface Gorilla {
        String move();

    }
}
