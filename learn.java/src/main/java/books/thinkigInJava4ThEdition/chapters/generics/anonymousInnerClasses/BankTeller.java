package books.thinkigInJava4ThEdition.chapters.generics.anonymousInnerClasses;

import java.util.*;

class BankTeller {

    static void serve(Teller t, Customer c){
        System.out.println(t + " serves: " + c);
    }

    static void m(){
        Random r = new Random(47);
        Queue<Customer> line = new LinkedList<>();
        Generators.fill(line, Customer.generator(), 15);
        List<Teller> tellers = new ArrayList<>();
        Generators.fill(tellers, Teller.generator(), 4);

        for(Customer cust: line){
            serve(tellers.get(r.nextInt(tellers.size())), cust);
        }
    }

    public static void main(String[] args) {
        m();
    }
}
