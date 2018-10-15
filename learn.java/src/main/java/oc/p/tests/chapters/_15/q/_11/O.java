package oc.p.tests.chapters._15.q._11;

import java.util.Optional;

class O {

    static void m(){
        Optional<String> o = Optional.empty();
//        Optional<String> o2 = Optional.of(null);
        Optional<String> o3 = Optional.ofNullable(null);

        System.out.println(o.isPresent());
//        System.out.println(o2.isPresent());
        System.out.println(o3.isPresent());
    }

    public static void main(String[] args) {
        m();
    }
}
