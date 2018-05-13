package books.thinkigInJava._4ThEdition.chapters.generics.exceptions;

class ThrowGenericException {
    public static void main(String[] args) {
        ProcessRunner<String, Failure> runner = new ProcessRunner<>();

        for(int i=0; i<3; i++){
            runner.add(new ProcessorImpl());
        }
        try{
            System.out.println(runner.processAll());
        } catch(Failure failure) {
            System.out.println(failure);
        }

        ProcessRunner<Integer, Failure2> runner2 = new ProcessRunner<>();
        for(int i=0; i<3; i++){
            runner2.add(new ProcessorImpl2());
        }
        try{
            System.out.println(runner2.processAll());
        } catch(Failure2 failure2) {
            System.out.println(failure2);
        }
    }
}
