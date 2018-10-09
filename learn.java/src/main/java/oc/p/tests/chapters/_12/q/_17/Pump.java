package oc.p.tests.chapters._12.q._17;

interface Pump {
    void pump(double psi);
}

interface Bend extends Pump{
    void bend(double tensileStrength);
}

class Robot{
    static final void apply(Bend instr, double input){
        instr.bend(input);
    }

    public static void main(String[] args) {
        final Robot r  =new Robot();
//        r.apply(x-> System.out.println(x + " bent"), 5);
    }
}
