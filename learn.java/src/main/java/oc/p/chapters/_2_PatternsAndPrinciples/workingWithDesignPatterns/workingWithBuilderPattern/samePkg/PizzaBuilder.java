package oc.p.chapters._2_PatternsAndPrinciples.workingWithDesignPatterns.workingWithBuilderPattern.samePkg;

class PizzaBuilder {
    //required
    private String type;
    private double price;

    //optional
    private String sauce = "none";
    private boolean extraChesse = false;
    private boolean extraMeat = false;

    PizzaBuilder(String type, double price){
        this.type = type;
        this.price = price;
    }

    PizzaBuilder sauce(String s){
        this.sauce =s;
        return  this;
    }

    PizzaBuilder extraCheese(boolean b){
        extraChesse = b;
        return this;
    }

    PizzaBuilder extraMeat(boolean b){
        extraMeat =b;
        return  this;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public String getSauce() {
        return sauce;
    }

    public boolean isExtraChesse() {
        return extraChesse;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    Pizza build(){
        return new Pizza(this);
    }
}
