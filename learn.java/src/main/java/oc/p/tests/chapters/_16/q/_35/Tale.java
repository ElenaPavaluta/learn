package oc.p.tests.chapters._16.q._35;

class Tale {

    int tellStory() {
        try {
        } catch (BearException e) {
//            e = new RuntimeException();  //compiler error
            e = (BearException) new RuntimeException();
            throw e;
        } catch (WolfException | DragonException e) {
//            e = new RuntimeException();
            throw e;
        }
        return 3;
    }

    class BearException extends RuntimeException {
    }

    class WolfException extends RuntimeException {
    }

    class DragonException extends RuntimeException {
    }
}
