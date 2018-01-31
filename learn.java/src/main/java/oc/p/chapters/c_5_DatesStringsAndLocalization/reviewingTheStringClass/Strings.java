package oc.p.chapters.c_5_DatesStringsAndLocalization.reviewingTheStringClass;

class Strings {

    static String s = "abcde ";

    static void mString() {
        System.out.println("s.trim().length(): " + s.trim().length());  //5

        System.out.println("s.charAt(4):" + s.charAt(4));  //e

        System.out.println("s.indexOf(\"e\"): " + s.indexOf("e"));  //4

        System.out.println("s.substring(2): " + s.substring(2));  //cde

        System.out.println("s.substring(2, 4): " + s.substring(2, 4));  //cd

        System.out.println("s.toUpperCase(): " + s.toUpperCase());  //ABCDE

        System.out.println("s.toLowerCase(): " + s.toLowerCase());  //abcde

        System.out.println("s.startsWith(\"a\"): " + s.startsWith("a"));  //true

        System.out.println("s.startsWith(\"c\", 2): " + s.startsWith("c", 2));  //true

        System.out.println("s.contains(\"A\"): " + s.contains("A"));  //false

        System.out.println("s.contains(new StringBuilder(\"a\")): " + s.contains(new StringBuilder("a")));  //true

        System.out.println("s.replace('a', 'A'):" + s.replace('a', 'A'));  //Abcde

        System.out.println("s.replace(new StringBuilder(\"a\"), \"A\"):" + s.replace(new StringBuilder("a"), "A"));  //Abcde;
    }

    static void mStringBuilder(){
        StringBuilder sb = new StringBuilder().append(12345).append('-');

        System.out.println("sb.length(): " +sb.length());  //6

        System.out.println("sb.indexOf(\"45\"): "+sb.indexOf("45"));  //3
        System.out.println("sb.indexOf(\"1\", 2): " +sb.indexOf("1", 2));  //-1

        System.out.println("sb.charAt(1): " + sb.charAt(1));  //2

        System.out.println("sb.insert(2, \"wq\"): " + sb.insert(2, "wq"));  //12wq345-

        System.out.println("sb.delete(2, 4): " + sb.delete(2, 4));  //12345-

        System.out.println("sb.deleteCharAt(4): " + sb.deleteCharAt(5));  //12345

        System.out.println("sb.substring(1, 4): " + sb.substring(1, 4));  //234

        System.out.println("sb.reverse(): " + sb.reverse());  //54321
    }

    public static void main(String[] args) {
//        mString();
        mStringBuilder();
    }

}
