package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle;

import java.util.ListResourceBundle;

public class Tax_en_US extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"tax", new EnUsTaxCode()},};
    }
}
