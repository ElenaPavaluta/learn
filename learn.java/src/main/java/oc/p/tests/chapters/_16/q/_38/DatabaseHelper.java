package oc.p.tests.chapters._16.q._38;

import java.io.Closeable;
import java.io.IOException;

class DatabaseHelper {

    static class Mydatabase implements Closeable {
        @Override
        public void close() throws /*SQLException*/ IOException {
            System.out.println(2);
        }

        void write(String data) {
        }

        String read() {
            return null;
        }
    }

    public static void main(String[] args) {
        try(Mydatabase m = new Mydatabase()){

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println(1);
        }
    }
}
