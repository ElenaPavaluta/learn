package books.thinkigInJava._4ThEdition.chapters.generics.wildcards;

import oc.a.chapters.c3_core_java_apis.javaArrays.creatingAnArrayOfPrimitives.Array;
import java.util.ArrayList;
import java.util.List;

class UnboundedWildcards {
    static List list;
    static List<?> list2;
    static List<? extends Object> list3;

    static void assign(List temp){
        list = temp;
        list2 = temp;
        list3 = temp;
    }

    static void assign2(List<?> temp){
        list = temp;
        list2 = temp;
        list3 = temp;
    }

    static void assign3(List<? extends Object> temp){
        list = temp;
        list2 = temp;
        list3 = temp;
    }

    public static void main(String[] args) {
        assign(new ArrayList());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        ArrayList<String> as = new ArrayList<>();
        assign(as);
        assign2(as);
        assign3(as);

        List<?> lq = new ArrayList<>();
        lq = new ArrayList<String>();

        assign(lq);
        assign2(lq);
        assign3(lq);
    }
}
