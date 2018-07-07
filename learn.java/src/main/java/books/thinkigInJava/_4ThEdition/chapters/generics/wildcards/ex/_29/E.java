package books.thinkigInJava._4ThEdition.chapters.generics.wildcards.ex._29;

import books.thinkigInJava._4ThEdition.chapters.generics.wildcards.Holder;
import java.util.ArrayList;
import java.util.List;

class E {

    static void m(Holder<List<?>> holder, List<?> lst){
        holder.setT(lst);
        List<?> l = holder.getT();
    }

    static void m2(List<Holder<?>> lst, Holder<?> holder){
        lst.add(holder);
        Holder<?> holder2 = lst.get(0);
    }

    static void runM(){
        Holder raw = new Holder();
        List rawList = new ArrayList<>();

        List<Integer> li = new ArrayList<>();
        Holder<List<Integer>> hLi = new Holder<List<Integer>>();

        Holder<List> hL = new Holder<>();

        m(raw, rawList);

        m(raw, li);

//        createAndPopulate(hLi, li);  //compiler error

        m(raw, li);

//        createAndPopulate(hL, li);  //compiler error
    }

    static void runM2(){
        List rawLst = new ArrayList<>();
        Holder raw = new Holder();

        m2(rawLst, raw);

        List<Holder<Integer>> lHI = new ArrayList<>();
        Holder<Integer> hI = new Holder<>();
//        m2(lHI, hI);  //compiler error

//        m2(new ArrayList<Holder>(), hI); compiler error

        m2(rawLst, hI);

    }
}
