package oc.p.tests.chapters._12.q._38;

interface Toy {

    String play();
}

class Gift{
    public static void main(String[] args) {
        abstract class Robot{
        }

        class Transformer extends Robot implements Toy{
            public String name = "Giant Robot";

            @Override
            public String play() {
                return "Dinosaur Robot";
            }
        }

        Transformer prime = new Transformer(){
            @Override
            public String play() {
                return name;
            }
        };

        System.out.println(prime.play() + " "  /* + name*/);
    }
}
