package oc.p.tests.chapters._18.q._14;

import java.io.Serializable;

class Cereal implements Serializable {

    private String name = "CocoaCookies";
    private transient int sugar;

    {
        name = "SugarPops";
    }

    public Cereal() {
        super();
        this.name = "CaptainPebbles";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }
}
