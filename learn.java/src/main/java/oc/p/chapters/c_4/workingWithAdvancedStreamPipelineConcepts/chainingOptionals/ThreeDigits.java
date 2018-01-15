package oc.p.chapters.c_4.workingWithAdvancedStreamPipelineConcepts.chainingOptionals;

import java.time.LocalDate;
import java.util.Optional;

/**
 * <U> Optional<U>	map(Function<? super T,? extends U> mapper)
 * If a value is present, apply the provided mapping function to it,
 * and if the result is non-null, return an Optional describing the result.
 *
 *
 * Optional<T>	filter(Predicate<? super T> predicate)
 * If a value is present, and the value matches the given predicate,
 * return an Optional describing the value, otherwise return an empty Optional.
 *
 *
 * <U> Optional<U>	flatMap(Function<? super T,Optional<U>> mapper)
 * If a value is present, apply the provided Optional-bearing mapping function to it,
 * return that result, otherwise return an empty Optional.
 */
class ThreeDigits {

    static void threeDigits_old(Optional<Integer> optional) {
        if(optional.isPresent()) {
            Integer num = optional.get();
            String string = "" + num;
            if(string.length() == 3) {
                System.out.println(string);
            }
        }
    }

    static void threeDigits_new(Optional<Integer> optional) {
        optional.map(String::valueOf)
                .filter(s -> s.length() == 3)
                .ifPresent(System.out::println);
    }

    static void m() {
        Optional<String> optional = Optional.ofNullable(null);
        optional.map(Double::valueOf).ifPresent(System.out::println);
    }

    static void m2() {
        Optional<LocalDate> optional = Optional.<LocalDate>ofNullable(LocalDate.now().minusMonths(3));
        optional.filter(d -> d.isBefore(LocalDate.now())).
                filter(d -> d.isBefore(LocalDate.now().minusMonths(2)))
                .map(LocalDate::toString)
                .ifPresent(System.out::println);
    }

    static void m3(){
        Optional<Optional<String>> opt = Optional.of(Optional.of("male"));
        System.out.println("Optional value   :: " + opt);
        System.out.println("Optional.map     :: " + opt.map(gender -> gender.map(String::toUpperCase)));
        System.out.println("Optional.flatMap :: " + opt.flatMap(gender -> gender.map(String::toUpperCase)));
    }

    static void m4(){
        Optional<Optional<String>> opt = Optional.of(Optional.of("a"));

        Optional<Optional<Integer>> temp = opt.map(o -> o.map(s->7) );
        temp.ifPresent(System.out::println);

        Optional<Double> tempDouble = opt.flatMap(o->o.map(s->7.0));
        tempDouble.ifPresent(System.out::println);
    }

    public static void main(String[] args) {
//        threeDigits_old(Optional.<Integer>of(123));
//        threeDigits_new(Optional.of(123));
//        m();
//        m2();
//        m3();
        m4();
    }

}
