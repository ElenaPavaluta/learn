package oc.p.tests.chapters._22.q._8;

import utils.javaClass.hierrarchy.methods.none.animal.Animal;
import utils.javaClass.hierrarchy.methods.none.animal.Dog;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

public class Q3_en_US extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        Object[][] arr = new Object[2][];
        arr[0] = new Object[] {"a", new Animal()};
        arr[1] = new Object[] {"b", new Dog()};
        return arr;
    }


}
