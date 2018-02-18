package books.thinkigInJava4ThEdition.chapters.concurrency.baiscThreading.joiningAThread.tw.exceptions;

class E {

    static void m(){
        try {
            throw new Exception();
        }catch(Exception e){
            System.out.println("catched");
        }
        System.out.println("last line ");
    }

    static void m2(){
        try{
            throw new Exception();
        }catch(Exception e){
            System.out.println("catched");
            throw new RuntimeException();
        }
//        System.out.println("last line");  //compiler error: unreachable cdde
    }

    public static void main(String[] args) {
//        m();
        m2();
    }
}
