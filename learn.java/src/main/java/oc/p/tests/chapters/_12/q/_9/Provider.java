package oc.p.tests.chapters._12.q._9;

enum Currency{
    DOLLAR, YEN, EURO
}

abstract class Provider {
    protected Currency c = Currency.EURO;
}

class Bank extends Provider{
    protected Currency c = Currency.DOLLAR;

    public static void main(String[] args) {
        int value = 0;
        Provider bank = new Bank();
//        Bank bank = new Bank();
        switch (bank.c){
            case DOLLAR:
                System.out.println("Dollar");
                break;
            case EURO:
                System.out.println("Euro");
                break;
        }
    }
}
