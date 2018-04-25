package books.thinkigInJava4ThEdition.chapters.generics.genericMethods.aSetUtility;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import java.util.*;
import java.util.stream.Stream;

class ContainerMethodDifferences {

    static Set<String> methodSet(Class<?> type){
        Set<String> res = new TreeSet<>();
        Stream.of(type.getMethods()).forEach(
                m->res.add(m.getName()));
        return  res;
    }

    static void interfaces(Class<?> type){
        System.out.println("Interfaces in: " + type.getSimpleName());
        List<String> lst = new ArrayList<>();
        Stream.of(type.getInterfaces())
              .forEach(i->lst.add(i.getSimpleName()));
        System.out.println(lst);
    }

    static Set<String> object = methodSet(Object.class);
    static {
        object.add("clone");
    }

    static void difference(Class<?> superset, Class<?> subset){
        System.out.println(superset.getSimpleName() + " extends: " + subset.getSimpleName() + ", adds");
        Set<String> comp = Sets.difference(methodSet(superset), methodSet(subset));
        comp.removeAll(object);
        System.out.println(comp);
        interfaces(superset);

    }

    public static void main(String[] args) {
        System.out.println("Collection: " + methodSet(Collection.class));
        interfaces(Collection.class);
        difference(Set.class, Collection.class);
        difference(Set.class, HashSet.class);
        difference(LinkedHashSet.class, HashSet.class);
        difference(TreeSet.class, Set.class);
        difference(List.class, PolicyUtils.Collections.class);
        difference(ArrayList.class, List.class);
        difference(LinkedList.class, List.class);
        difference(Queue.class, Collection.class);
        difference(PriorityQueue.class, Queue.class);
        System.out.println("Map: " + methodSet(Map.class));
        difference(HashMap.class, Map.class);
        difference(LinkedHashMap.class, HashMap.class);
        difference(SortedMap.class, Map.class);
        difference(TreeMap.class, Map.class);
    }

}
