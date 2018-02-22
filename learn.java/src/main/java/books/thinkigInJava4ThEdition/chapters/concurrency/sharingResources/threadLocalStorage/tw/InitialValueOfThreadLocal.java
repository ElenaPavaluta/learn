package books.thinkigInJava4ThEdition.chapters.concurrency.sharingResources.threadLocalStorage.tw;

class InitialValueOfThreadLocal {

    static ThreadLocal<Integer> local = new ThreadLocal<>();

    static {
        System.out.println(local.get()); //null
    }

    public static void main(String[] args) {

    }
}
