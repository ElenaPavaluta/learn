package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.workingWithBuilderPattern.staticInnerClass;

class Run {

    public static void main(String[] args) {
//        Pizza p = new Pizza ();  //compiler error: the constructor is private
        Pizza p = new Pizza.PizzaBuilder ( "type", 2 ).sauce ( "sauce" ).extracheese ( true ).extraMeet ( true ).build ( );
    }
}
