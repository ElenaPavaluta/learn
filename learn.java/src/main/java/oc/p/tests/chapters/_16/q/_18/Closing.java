package oc.p.tests.chapters._16.q._18;

interface Closing {

    void close() throws Exception;
}

class Shelf implements Closing {
    @Override
    public void close() throws Exception {
    }
}

class Step {
    static {
        try /*(Shelf s = new Shelf())*/ {
//            throws new IllegalArgumentException()

        } catch (RuntimeException e) {
        } catch (Exception e) {
//        }catch (RuntimeException e){

//        }catch (IllegalArgumentException e){

        } finally {
            System.out.println("finally");
        }
    }

    public static void main(String[] args) {
        new Step();
    }
}
