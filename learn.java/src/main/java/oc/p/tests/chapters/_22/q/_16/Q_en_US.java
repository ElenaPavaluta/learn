package oc.p.tests.chapters._22.q._16;

import utils.resources.files.Resources;

import java.time.LocalDateTime;
import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class Q_en_US extends ListResourceBundle {
    static LocalDateTime ldt = LocalDateTime.now();
    static Package pkg= new Q_en_US().getClass().getPackage();

    @Override
    protected Object[][] getContents() {
        Object[][] arr = new Object[1][];
        arr[0] = new Object[]{ldt, "LDT"};
        return arr;
    }

    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle(Resources.pathToListResourceBundle(pkg, "Q"));
        System.out.println(rb.getObject(ldt.toString()));
    }

}
