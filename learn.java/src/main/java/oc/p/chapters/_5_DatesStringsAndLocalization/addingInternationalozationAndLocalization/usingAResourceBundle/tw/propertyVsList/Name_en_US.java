package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.tw.propertyVsList;


import java.util.ListResourceBundle;

public class Name_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] arr = new Object[2][];
        arr[0] = new Object[]{"a", "A"};
        arr[1] = new Object[]{"sa", new String[] {"this",  "is",  "a",  "string",  "array"}};
        return arr;
    }
}
