package oc.p.tests.chapters._11.q._25;

class Watch {

    private String getType(){
        return "watch";
    }

    public String getName(String suffix){
        return getType() + suffix;
    }
}

class SmartWatch extends Watch{
    private String getType(){
        return "smart watch";
    }

    public String getName(String suffix){
        return getType() + suffix;
    }

    public static void main(String[] args) {
//        m();
        m2();
    }

    private static void m2() {
        Watch w = new SmartWatch();
        SmartWatch sm = new SmartWatch();

        System.out.println(w.getName(""));  //smart watch
        System.out.println(w.getName(""));  //smart watch
    }

    private static void m() {
        Watch w = new Watch();
        SmartWatch sm = new SmartWatch();
        System.out.println(w.getName(""));  //watch
        System.out.println(sm.getName(""));  //smart watch
    }
}
