package books.thinkigInJava._4ThEdition.chapters.generics.issues.castingAndWarnings;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

class Casting {
    void need(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<Widget> widgets = (List<Widget>) in.readObject();
    }

    void classCasting(String[] args) throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(args[0]));
        List<Widget> widgets = List.class.cast(in.readObject());
    }
}

class Widget{}

