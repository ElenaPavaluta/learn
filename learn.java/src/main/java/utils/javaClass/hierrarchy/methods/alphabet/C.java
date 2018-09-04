package utils.javaClass.hierrarchy.methods.alphabet;

import java.util.Arrays;
import java.util.function.Predicate;

public class C {

    private Predicate<String> IS_PUBLIC = s -> s.contains("public");
    private Predicate<String> IS_STATIC = s -> s.contains("static");

    protected String info() {
        return className() + " -> " + methodName();
    }

    private String className() {
        return this.getClass().getSimpleName();
    }

    private String methodName() {
        return Arrays.stream(this.getClass().getDeclaredMethods())
                .filter(m -> IS_PUBLIC.and(IS_STATIC.negate()).test(m.toString()))
                .findFirst()
                .map(m -> m.getName())
                .orElse("No method found");
    }

    public String mC() {
        return info();
    }
}
