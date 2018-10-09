package gtk.tw.date._2018.october._1;

import java.lang.reflect.Field;
import java.util.Arrays;

class Q {

    public static void main(String[] args) {
//        m();

//        Map<Class[], List<Class<?>>> map = Arrays.stream(I.C.class.getDeclaredClasses()).collect(Collectors.groupingBy(c -> c.getClass().getEnumConstants()));
//        map.forEach((k, v) -> System.out.println(k + " -> " + v));
        I i = I.C.CD.CD1;

        System.out.println(i.getClass().getTypeName());
        String s = i.toString();

        boolean b = Arrays.stream(I.C.class.getDeclaredClasses())
                .map(Class::getFields)
                .flatMap(Arrays::stream)
                .peek(p -> System.out.println("peek: " + p))
                .filter(f -> f.getType().getTypeName().endsWith(i.getClass().getTypeName()))
                .map(Field::getName)
                .anyMatch(s::equals);
        System.out.println(b);
    }

    private static void m() {
        I i = I.C.C1;
        I i2 = I.C.CD.CD1;

        I.C i3 = (I.C) i;
//        I.C i4 = (I.C.CD)i;  //compile error

        I.C.CD i5 = (I.C.CD) i2;
//        I.C i6 = (I.C)i2;  //RE
        System.out.println(i2 instanceof I.C);
        System.out.println(i2 instanceof I.C.CD);

        System.out.println(i);
        System.out.println(i2);
        System.out.println(i3);
        System.out.println(i5);
//        System.out.println(i6);
    }
}
