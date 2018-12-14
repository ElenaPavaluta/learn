package oc.p.tests.chapters._22.q._8;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

class Run {

    static void m(){
//        ResourceBundle bundle = ResourceBundle.getBundle("oc\\p\\tests\\chapters\\_22\\q\\_8\\Q3");
        ResourceBundle bundle = ResourceBundle.getBundle("oc.p.tests.chapters._22.q._8.Q3");
        System.out.println(bundle.getObject("a"));
//        System.out.println(bundle.getObject("c"));  //RE

        ListResourceBundle lrb = (ListResourceBundle)bundle;
        System.out.println(lrb.getObject("a"));
//        System.out.println(lrb.getObject("c"));  //null
    }

    public static void main(String[] args) {
        m();
    }
}
