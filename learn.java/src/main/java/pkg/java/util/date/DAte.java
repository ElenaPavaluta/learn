package pkg.java.util.date;

import com.sun.org.apache.xerces.internal.impl.dv.DTDDVFactory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

class DAte {

    static void m() throws ParseException {
        java.util.Date d = new java.util.Date ( );
        System.out.println ( d );

        DateFormat df = new SimpleDateFormat ( "dd.MM.yyyy HH:mm");
        System.out.println ( df.format ( d ));

        Date d2 = df.parse ( "22.08.2017 14:31" );

        System.out.println (d2);
        System.out.println (df.format ( d2 ));

    }

    public static void main(String[] args) throws ParseException {
        m ();
    }
}
