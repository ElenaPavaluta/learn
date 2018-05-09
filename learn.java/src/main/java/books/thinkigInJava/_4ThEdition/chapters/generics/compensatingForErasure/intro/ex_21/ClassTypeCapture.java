package books.thinkigInJava._4ThEdition.chapters.generics.compensatingForErasure.intro.ex_21;

import java.util.HashMap;
import java.util.Map;

class ClassTypeCapture<T> {

    Class<T> kind;
    Map<String, Class<?>> map = new HashMap<>();

    ClassTypeCapture(Class<T> kind) {
        this.kind = kind;
    }


    /**
     * isInstance(Object o) return true
     *
     * if the current reference can be used to refer the given object (o)
     */
    boolean m(Object o) {
        return kind.isInstance(o);
    }

    void addType(String typeName, Class<?> kind) {
        map.put(typeName, kind);
    }

    Object createNew(String typeName) {
        try {
            return map.get(typeName).newInstance();
        } catch(InstantiationException | IllegalAccessException e) {
//            e.printStackTrace();
        }
        return null;
    }

}

class A {
}

class B {
}

class C {
}

class D {
}
