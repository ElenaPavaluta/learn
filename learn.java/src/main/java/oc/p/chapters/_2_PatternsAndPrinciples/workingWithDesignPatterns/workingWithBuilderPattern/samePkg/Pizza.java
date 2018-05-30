package oc.p.chapters._2_PatternsAndPrinciples.workingWithDesignPatterns.workingWithBuilderPattern.samePkg;

class Pizza {
    private String type;
    private double price;
    private String sauce;
    private boolean extraChesse;
    private boolean extraMeat;

    Pizza(PizzaBuilder pizzaBuilder) {
        this.type = pizzaBuilder.getType ();
        this.price = pizzaBuilder.getPrice ();
        this.sauce = pizzaBuilder.getSauce ();
        this.extraChesse = pizzaBuilder.isExtraChesse ();
        this.extraMeat =  pizzaBuilder.isExtraMeat ();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public boolean isExtraChesse() {
        return extraChesse;
    }

    public void setExtraChesse(boolean extraChesse) {
        this.extraChesse = extraChesse;
    }

    public boolean isExtraMeat() {
        return extraMeat;
    }

    public void setExtraMeat(boolean extraMeat) {
        this.extraMeat = extraMeat;
    }
}
