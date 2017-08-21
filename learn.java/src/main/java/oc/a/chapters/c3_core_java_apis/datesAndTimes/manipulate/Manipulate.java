package oc.a.chapters.c3_core_java_apis.datesAndTimes.manipulate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * The date and time classes are immutable, just like String
 *
 */
public class Manipulate {

	static LocalDate date = LocalDate.of(2017, 04, 5);
	static LocalTime time = LocalTime.NOON;
	static LocalDateTime dateTime = LocalDateTime.of(date, time);

	static void m() {
		LocalDate ld = LocalDate.now();
		
		System.out.println(ld.getDayOfYear());
		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getDayOfWeek());
		System.out.println(ld.getEra());
		
		System.out.println();
		LocalTime lt = LocalTime.now();
		
		System.out.println(lt.getHour());
		System.out.println(lt.getMinute());
		System.out.println(lt.getSecond());
		System.out.println(lt.getNano());
	}

	static void m2() {
		date = date.plusDays(2);
		System.out.println(date);

		date = date.plusWeeks(3);
		System.out.println(date);

		date = date.plusYears(2);
		date = date.plusMonths(1);
		System.out.println(date);
	}

	static void m3() {
		System.out.println(time);

		time = time.plusHours(20);
		System.out.println(time);

		time = time.minusSeconds(30);
		System.out.println(time);
	}

	static void m4() {
		time = LocalTime.NOON;

		time = time.plusHours(2).plusMinutes(30).plusSeconds(59); // expected:
																	// 14:30:59;
		System.out.println(time);

		time = LocalTime.of(12, 00, 00).plusHours(2).plusMinutes(30).plusSeconds(59); // expected:
																						// 14:30:59;
		System.out.println(time);
	}

	static void tricks() {
		date = LocalDate.now();
		date.plusDays(5); // date has the sane value due to the fact that it is
							// imutable
		System.out.println(date);

		time = LocalTime.NOON;
		time.plusMinutes(25); // nothing happens with the time object because it
								// is imutable
		System.out.println(time);

		dateTime.plusMonths(5);
		System.out.println(dateTime); // imutable too
	}

	public static void main(String[] args) {
		m();
		// m2();
		// m3();
		// m4()
//		tricks();
	}
}
