package books.thinkigInJava4ThEdition.chapters.generics.compensatingForErasure.creatingInstancesOfTypes.ex._22;

import sun.util.resources.cldr.rof.CurrencyNames_rof;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Factory {

    static <T> T create(Class<T> kind, Class<?>... params) {
        final T t;
        return (t = newInstance(kind)) != null ? t : newInstance(kind, params);
    }

    private static <T> T newInstance(Class<T> kind, Class<?>... params) {
        T t = null;
        try {
            Constructor<T> constructor = kind.getConstructor(params);
            t = constructor.newInstance(newInstances(params));
        } catch(NoSuchMethodException e) {
            System.out.println(kind.getSimpleName() + ": no constructor for params");
        } catch(IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println(kind.getSimpleName() + ": error when invoking constructor");
        } catch(Exception e) {
            e.printStackTrace();
            Stream.<Throwable>of(e.getSuppressed()).forEach(Throwable::printStackTrace);
        }
        return t;
    }

    private static Object[] newInstances(Class<?>[] params) {
        return Stream.<Class<?>>of(params).map(Factory::newInstance).collect(Collectors.toList()).toArray();
    }

    static <T> T newInstance(Class<T> kind) {
        T t = null;
        try {
            t = kind.newInstance();
        } catch(InstantiationException e) {
            System.out.println(kind.getSimpleName() + ": no def constructor");
        } catch(IllegalAccessException e) {
            System.out.println(kind.getSimpleName() + ": no visible constructor");
        }
        return t;
    }

}
