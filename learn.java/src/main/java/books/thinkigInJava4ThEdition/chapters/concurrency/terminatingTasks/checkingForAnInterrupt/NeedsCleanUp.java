package books.thinkigInJava4ThEdition.chapters.concurrency.terminatingTasks.checkingForAnInterrupt;

class NeedsCleanUp {
    private final int id;

    NeedsCleanUp(int id){
        this.id = id;
        System.out.println("Needs clean up " + id);
    }

    void cleanUp(){
        System.out.println("Cleaning up " + id);
    }


}
