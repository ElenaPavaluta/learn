package books.thinkigInJava._4ThEdition.chapters.generics.issues.noPrimitiveAsTypeParameter.ex._30;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

class C {

    static Queue<Long> q;

    static void m(){
        q = new LinkedList<>();
        q.add(2l);
        System.out.println(q.poll());
    }

    static void m2(){
        q = new ArrayDeque<>();
        q.add(2l);
        System.out.println(q.poll());
    }

    public static void main(String[] args) {
        m();
        m2();
    }

}
