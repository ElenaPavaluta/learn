package oc.p.tests.chapters._12.q._26;

class Forecast {

    enum Snow { BLIZZARD, SQUALL, FLURRY }

    public static void main(String[] args) {
        System.out.println(Snow.BLIZZARD.ordinal());
        System.out.println(Snow.valueOf("flurry".toUpperCase()).name());
    }
}
