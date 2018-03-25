package books.thinkigInJava4ThEdition.chapters.concurrency.simulation.bankTellerSimulation;

class A {

    public static void main(String[] args) {
        String a  = "q\na"; //q\\n

        System.out.println(a.toString());

        a = a.replace("\n", "\\");

//        System.out.println(a);
//
//        a = a.replace("\\", "");
//
//        System.out.println(a);
    }
}
