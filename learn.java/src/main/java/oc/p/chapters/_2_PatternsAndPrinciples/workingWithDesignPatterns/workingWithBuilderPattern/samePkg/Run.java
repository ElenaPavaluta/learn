package oc.p.chapters._2_PatternsAndPrinciples.workingWithDesignPatterns.workingWithBuilderPattern.samePkg;

class Run {

    public static void main(String[] args) {
        Pizza p;

        PizzaBuilder pb = new PizzaBuilder ( "quatro", 20.5 ).sauce ( "tomato" ).extraMeat ( true ).extraCheese ( true );

        p = new Pizza ( pb );

        p = pb.build ();

        p = new PizzaBuilder ( "pizza", 2 ).sauce ( "tomato" ).extraCheese ( true ).extraMeat ( false ).build ( );
    }
}
