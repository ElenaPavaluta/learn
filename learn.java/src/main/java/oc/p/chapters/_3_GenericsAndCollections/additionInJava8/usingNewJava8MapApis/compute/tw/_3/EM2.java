package oc.p.chapters._3_GenericsAndCollections.additionInJava8.usingNewJava8MapApis.compute.tw._3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

class EM2 {

    Map<Integer, String> map = new HashMap<>();
    Integer key = null;
    Function<Integer, String> FUNCTION = String::valueOf;
    BiFunction<Integer, String, String> BI_FUNCTION = (k, v) ->String.valueOf(k) + " : " + v;
    BinaryOperator<String> BINARY_OPERATOR = (ov, nv)->ov + " :: " + nv;
    Integer k= null;
    String v = "";


    {
        map.computeIfAbsent(k, FUNCTION);

        if(map.get(k) == null){
            String nv = FUNCTION.apply(k);
            if(nv !=null){
                map.put(k, nv);
            }
        }
    }

    {
        map.computeIfPresent(k, BI_FUNCTION);

        String ov = map.get(k);
        if(ov !=null){
            String nv = BI_FUNCTION.apply(k, ov);
            if(nv != null){
                map.put(k, nv);
            }else{
                map.remove(k);
            }
        }
    }

    {
        map.compute(k, BI_FUNCTION);

        String ov = map.get(k);
        String nv = BI_FUNCTION.apply(k, ov);

        if(ov != null){
            if(nv !=null){
                map.put(k, nv);
            }else{
                map.remove(k);
            }
        }else{
            if(nv !=null){
                map.put(k, nv);
            }
        }
    }

    {
        map.merge(k, v, BINARY_OPERATOR);

        String ov = map.get(k);
        String nv = ov == null? v: BINARY_OPERATOR.apply(ov, v);

        if(nv !=null){
            map.put(k, nv);
        }else{
            map.remove(k);
        }
    }
}
