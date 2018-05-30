package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.pEx._1;

class Arrays {

    class A{}

    Arrays.A[] aas;

    A[] as;

    {
        aas = new A[2];  //due to scope visibility; wouldn't work from outside the outer class
        aas = new Arrays.A[2];

        as = new A[2];
        as = new Arrays.A[2];
    }

    {
        as[0] = new A ();
//        as[1] = new StringBuilder (  );  //compiler error
        as[1] = new A ();

        Object[] oa = as;
        as = (A[])oa;

//        StringBuilder[] sba = (StringBuilder[]) oa;  //compiler error: cannot be cast to StringBuilder

        System.out.println (as.hashCode ());
        System.out.println (oa.hashCode () );
    }

    {
        Object[] oa = new Object[2];
//        A[] aa = (A[]) oa;  //compiler error: cannot cast to A
//        StringBuilder[] sba = (StringBuilder[])oa;  //compiler error: cannot cast to B
    }

    public static void main(String[] args) {
        new Arrays ();
    }
}
