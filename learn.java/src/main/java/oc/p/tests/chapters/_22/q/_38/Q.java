package oc.p.tests.chapters._22.q._38;

import utils.resources.files.Resources;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class Q extends ListResourceBundle {
    private int count = 0;

    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"count", count++}} ;
    }

    public static void main(String[] args) {
        Package pkg = new Q().getClass().getPackage();
        ResourceBundle rb = ResourceBundle.getBundle(Resources.pathToListResourceBundle(pkg, "Q"));
        System.out.println(rb.getObject("count"));
        System.out.println(rb.getObject("count"));
    }
}
