package books.thinkigInJava4ThEdition.chapters.concurrency.newLibraryComponents.delayQueue.tw;

class Buffer {

    private StringBuilder sb = new StringBuilder();

    synchronized void add(String s){
        sb.append(s).append(" ");
    }

    synchronized void print(){
        System.out.println(sb.toString());
    }
}
