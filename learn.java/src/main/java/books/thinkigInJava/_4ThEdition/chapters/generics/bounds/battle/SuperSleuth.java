package books.thinkigInJava._4ThEdition.chapters.generics.bounds.battle;

class SuperSleuth<POWER extends XRayVision> extends SuperHero<POWER>{
    public SuperSleuth(POWER power) {
        super(power);
    }

    void see(){
        power.seeThroughWalls();
    }
}
