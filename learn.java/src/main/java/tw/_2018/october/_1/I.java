package tw._2018.october._1;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

interface I {

    public static void main(String[] args) {
//        m();
        I i = C.CD.CD1;
        boolean b = Stream.of(C.CD.CD1, C.CD.CD2, C.CDD.CDD1, C.CDD.CDD2)
                .anyMatch(x->x==i);
        System.out.println(b);
    }

    static void m() {
        I i = C.CD.CD1;
        Stream.of(C.CD.values(), C.CDD.values())
                .flatMap(Arrays::stream)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    enum A implements I {
        A1,
        A2
    }

    enum B implements I {
        B1,
        B2;
    }

    enum C implements I {
        C1,
        C2;

        enum CD implements I {
            CD1,
            CD2;
        }

        enum CDD implements I {
            CDD1,
            CDD2,
        }
    }
}
