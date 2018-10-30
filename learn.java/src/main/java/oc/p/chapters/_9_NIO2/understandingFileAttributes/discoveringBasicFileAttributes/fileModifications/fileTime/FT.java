package oc.p.chapters._9_NIO2.understandingFileAttributes.discoveringBasicFileAttributes.fileModifications.fileTime;

import java.nio.file.attribute.FileTime;
import java.time.Instant;
import java.util.concurrent.TimeUnit;

/**
 * public static FileTime fromMillis(long value)
 * public long toMillis()
 *
 * public static FileTime from(long value, TimeUnit unit)
 * public long to(TimeUnit unit)
 *
 * public static FileTime from(Instant instant)
 * public Instant toInstant()
 */
class FT {

    static Instant instant = Instant.now();

    static void m() {
        FileTime ft = FileTime.fromMillis(instant.toEpochMilli());
        System.out.println(ft);
        System.out.println(ft.toMillis());
    }

    static void m2() {
        FileTime ft = FileTime.from(365 * 35, TimeUnit.DAYS);
        System.out.println(ft);
        System.out.println(ft.to(TimeUnit.DAYS));
    }

    static void m3() {
        FileTime ft = FileTime.from(instant);
        System.out.println(ft);
        System.out.println(ft.toInstant());
    }

    public static void main(String[] args) {
//        m();
//        m2();
        m3();
    }
}
