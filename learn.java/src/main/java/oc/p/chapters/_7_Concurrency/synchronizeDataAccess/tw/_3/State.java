package oc.p.chapters._7_Concurrency.synchronizeDataAccess.tw._3;

enum State {

    ONE,
    SECOND,
    THIRD;

    synchronized boolean readyForOne(){
        return this.equals(THIRD);
    }

    synchronized boolean readyForSecond() {
        return this.equals(ONE);
    }

    synchronized boolean readyForThird() {
        return this.equals(SECOND);
    }
}

