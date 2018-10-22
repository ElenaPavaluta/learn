package oc.p.tests.chapters._18.q._31;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

class WidgetProcessor {

    static int getWdgetNumber(byte[] data) throws Exception {
        try (InputStream is = new ByteArrayInputStream(data)) {
            is.read(new byte[2]);
            if (!is.markSupported()) return -1;
            is.mark(5);
            is.read();
            is.read();
            is.skip(3);
            is.reset();
            return is.read();
        }
    }

    static void m() throws Exception {
        System.out.println(getWdgetNumber(new byte[] {1,2,3,4,5,6,7}));
    }

    public static void main(String[] args) throws Exception {
        m();
    }
}
