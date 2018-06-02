package books.thinkigInJava._4ThEdition.chapters.generics.dynamicTypeSafety;

import utils.javaClass.hierrarchy.methods.none.animal.Cat;
import utils.javaClass.hierrarchy.methods.none.animal.Dog;
import utils.javaClass.hierrarchy.methods.none.animal.Pet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class CheckedList {

    static void oldStyleMethod(List probablyDogs){
        probablyDogs.add(new Cat());
    }

    public static void main(String[] args) {
        List<Dog> dogs = new ArrayList<>();

        oldStyleMethod(dogs);  //quitly accepts a cat;

        List<Dog> dogs2 = Collections.checkedList(new ArrayList<Dog>(), Dog.class);

        try{
            oldStyleMethod(dogs2);
        }catch(Exception e){
            System.out.println(e);
        }

        //Derived type work fine: the method accepts a raw type list
        List<Pet> pets = Collections.checkedList(new ArrayList<Pet>(), Pet.class);
        pets.add(new Dog());
        pets.add(new Cat());
    }
}
