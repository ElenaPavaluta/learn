package books.thinkigInJava4ThEdition.chapters.generics.theActionAtTheBoundaries;

import java.util.ArrayList;
import java.util.List;

class FilledLIstMaker<T>
{
    List<T> crete(T t, int n){
        List<T> res = new ArrayList<>();
        for(int i= 0; i<n; i++){
            res.add(t);
        }
        return res;
    }
}
