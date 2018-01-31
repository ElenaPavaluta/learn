package oc.p.chapters.c_5_DatesStringsAndLocalization.addingInternationalozationAndLocalization.usingAResourceBundle.creatingAJavaClassResourceBundle;

import java.util.ListResourceBundle;

class Tax_fr_FR extends ListResourceBundle {

    @Override
    protected Object[][] getContents() {
        return new Object[][]{{"tax", new FrFrTaxCode()}};
    }
}
