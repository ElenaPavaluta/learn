package books.thinkigInJava._4ThEdition.chapters.generics.wildcards;

import java.util.HashMap;
import java.util.Map;

class UnboundedWildCards2 {
    static Map map;
    static Map<?, ?> map2;
    static Map<String, ?> map3;

    static void assign(Map temp){
        map = temp;
        map2 = temp;
        map3 = temp;
    }

    static void assign2(Map<?, ?> temp){
        map = temp;
        map2 = temp;
//        map3 = temp;  //compiler error
    }

    static void assign3(Map<String, ?> temp){
        map = temp;
        map2 = temp;
        map3 = temp;
    }

    public static void main(String[] args) {
        assign(new HashMap());
        assign2(new HashMap<>());
        assign3(new HashMap<>());

        assign(new HashMap<String, Integer>());
        assign2(new HashMap<String, Integer>());
        assign3(new HashMap<String, Integer>());
    }
}
