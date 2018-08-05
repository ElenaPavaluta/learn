package oc.p.chapters._3_GenericsAndCollections.workingWithGenerics.bounds.wildcardGenericType.wildcards.tw._1;

class Need {

    static void m() {
        Object[] oa = new Object[5];
        oa[0] = new Integer(23);

        Integer[] ia = (Integer[]) oa;  //RE
    }

    static void m2(){
        Object[] oa = new Integer[5];
        oa[0] = 7;

        Integer[] ia = (Integer[])oa;
        System.out.println(ia[0]);
    }

    public static void main(String[] args) {
        m();
//        m2();
    }
}
