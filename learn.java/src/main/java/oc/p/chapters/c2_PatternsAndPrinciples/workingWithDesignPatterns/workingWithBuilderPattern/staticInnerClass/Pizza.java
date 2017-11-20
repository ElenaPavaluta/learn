package oc.p.chapters.c2_PatternsAndPrinciples.workingWithDesignPatterns.workingWithBuilderPattern.staticInnerClass;

class Pizza {
    private String type;
    private double price;
    private String sauce;
    private boolean extraChesse;
    private boolean extraMeat;

    private Pizza(PizzaBuilder builder) {
        this.type = builder.type;
        this.price = builder.price;
        this.sauce = builder.sauce;
        this.extraChesse = builder.extraChesse;
        this.extraMeat = builder.extraMeat;
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

    static class PizzaBuilder {
        //required
        private String type;
        private double price;

        //optional
        private String sauce = "none";
        private boolean extraChesse = false;
        private boolean extraMeat = false;

        PizzaBuilder(String type, double price) {
            this.type = type;
            this.price = price;
        }

        PizzaBuilder sauce(String s) {
            this.sauce = s;
            return this;
        }

        PizzaBuilder extracheese(boolean b) {
            this.extraChesse = b;
            return this;
        }

        PizzaBuilder extraMeet(boolean b) {
            this.extraMeat = b;
            return this;
        }

        Pizza build() {
            return new Pizza ( this );
        }
    }

}
