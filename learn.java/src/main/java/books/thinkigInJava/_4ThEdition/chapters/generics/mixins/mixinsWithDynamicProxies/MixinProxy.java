package books.thinkigInJava._4ThEdition.chapters.generics.mixins.mixinsWithDynamicProxies;

import books.thinkigInJava._4ThEdition.chapters.generics.genericMethods.simplifyingTupleUse.TwoTuple;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

class MixinProxy implements InvocationHandler{
    Map<String, Object> delegatesByMethod;

    MixinProxy(TwoTuple<Object, Class<?>>... pairs){
        delegatesByMethod = new HashMap<>();
        for(TwoTuple<Object, Class<?>> pair: pairs){
            for(Method m: pair.getSecond().getMethods()){
                String methodName = m.getName();
                delegatesByMethod.putIfAbsent(methodName, pair.getFirst());
            }
        }
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Object delegate = delegatesByMethod.get(methodName);
        return method.invoke(delegate, args);
    }

    static Object newInstance(TwoTuple... pairs){
        Class[] interfaces = new Class[pairs.length];
        for(int i = 0; i<pairs.length; i++){
            interfaces[i] = (Class)pairs[i].getSecond();
        }
        ClassLoader cl = pairs[0].getFirst().getClass().getClassLoader();
        return Proxy.newProxyInstance(cl, interfaces, new MixinProxy(pairs));
    }
}
