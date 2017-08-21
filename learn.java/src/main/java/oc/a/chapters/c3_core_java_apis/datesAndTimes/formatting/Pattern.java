package oc.a.chapters.c3_core_java_apis.datesAndTimes.formatting;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * April 05, 2017, 07:34:55.79100000055 PM
 * 
 * 
 * M: 4 MM: 04 MMM: Apr MMMM: April
 *
 * d: 5 dd: 05
 *
 * y: 2017 yy: 17 yyy: 2017 yyyy: 2017 yyyyy: 02017
 *
 * h: 7 hh: 07, HH: hour in 24 h fomrmat
 *
 * m: 34 mm: 34 //max
 *
 * s: 5 ss: 05 //max
 *
 * n, ns, nss for nano seconds
 *
 * a //one single
 *
 */
public class Pattern {

	static LocalDateTime dateTime = LocalDateTime.now().minusHours(12);

	static void m() {
		DateTimeFormatter dtf = DateTimeFormatter
				.ofPattern("MMMM dd, YYYY, a HH:m:ss.nss ");

		System.out.println(dateTime.format(dtf));
	}

	public static void main(String[] args) {
		m();
	}
}
