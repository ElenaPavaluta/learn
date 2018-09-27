package oc.p.chapters._5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle.tw;

import utils.javaClass.hierrarchy.methods.none.animal.Cat;
import utils.javaClass.hierrarchy.methods.none.animal.Dog;
import utils.javaClass.hierrarchy.methods.none.animal.Lion;

import java.util.ListResourceBundle;

public class Rb_de_DE extends ListResourceBundle {
    @Override

    protected Object[][] getContents() {
        Object[][] arr = new Object[3][2];
        arr[0] = new Object[]{"lion", new Lion()};
        arr[1] = new Object[]{"dog", new Dog()};
        arr[2] = new Object[]{"cat", new Cat()};
        return arr;
    }
}
