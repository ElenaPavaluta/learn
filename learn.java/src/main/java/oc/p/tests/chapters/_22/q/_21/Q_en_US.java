package oc.p.tests.chapters._22.q._21;

import oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAPropertyFileResourceBundle.tw.LRB_en_US;
import utils.resources.files.Resources;

import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class Q_en_US extends ListResourceBundle {
    protected Object[][] getContents() {
        return new Object[][]{{"keys", new ArrayList<String>()}};
    }

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle(Resources.pathToListResourceBundle(new Q_en_US().getClass().getPackage(), "Q"));

        List<String> keys = (List)rb.getObject("keys");
        keys.add("q");
        keys.add("w");
        keys.add("e");
        System.out.println(((List)rb.getObject("keys")).size());
    }
}


