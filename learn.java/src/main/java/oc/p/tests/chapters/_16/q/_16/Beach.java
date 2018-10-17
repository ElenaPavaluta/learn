package oc.p.tests.chapters._16.q._16;

class Beach {

    class TideException extends Exception {
    }

    void surf() throws RuntimeException{
        try {
            throw new TideException();
        }catch (IllegalStateException | TideException e){
        }
    }
}
