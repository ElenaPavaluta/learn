package chapters.c3_core_java_apis.datesAndTimes.create;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZonedDateTime;

public class Create {

	// Contains just a date—no time and no time zone
	static LocalDate localDate = LocalDate.of(2017, Month.APRIL, 5);

	// Contains just a time—no date and no time zone
	static LocalTime localTime = LocalTime.of(14, 39, 00);

	// Contains both a date and time but no time zone
	static LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);

	static ZonedDateTime zonedDateTime;

	static void now() {
		System.out.println(LocalDate.now());
		System.out.println(LocalTime.now());
		System.out.println(LocalDateTime.now());
		System.out.println(ZonedDateTime.now()); // Java uses T to separate the
													// date and time when
													// converting LocalDateTime
													// to a String.
	}

	static void m() {
		localDate = LocalDate.of(2017, 4, 5); // 1-january, 12-december
		System.out.println(localDate);

		localDate = LocalDate.of(2017, Month.APRIL, 5);
		System.out.println(localDate);

		localDate = LocalDate.ofEpochDay(1999999);
		System.out.println(localDate);

		localDate = LocalDate.ofYearDay(2017, 111);
		System.out.println(localDate);
	}

	static void m2() {
		// localDate = LocalDate.of(-5, 13, 5); //java.time.DateTimeException

		// localDate = LocalDate.of(5, 2, 30); //java.time.DateTimeException

		// localDate = LocalDate.of(2017, 2, 29); // java.time.DateTimeException

		localDate = LocalDate.of(2016, 2, 29);
		System.out.println(localDate);
	}

	static void m3() {
		localTime = LocalTime.of(14, 15);
		System.out.println(localTime);

		localTime = localTime.of(14, 15, 15);
		System.out.println(localTime);

		localTime = LocalTime.of(14, 15, 15, 999); // . the separator for nanos
		System.out.println(localTime);

		localTime = LocalTime.ofSecondOfDay(3890);
		System.out.println(localTime);

		localTime = LocalTime.ofNanoOfDay(99999);
		System.out.println(localTime);
	}

	static void m4() {
		// localTime = LocalTime.of(15, 15, 60); //java.time.DateTimeException

		localTime = LocalTime.of(14, 15, 15, 1000);
		System.out.println(localTime); // 9 pozitive digits
	}

	static void m5(){
		localDateTime = LocalDateTime.of(localDate, localTime);
		System.out.println(localDateTime);
		
		localDateTime = LocalDateTime.of(2017, 04, 05, 15, 49);
		System.out.println(localDateTime);
		
		localDateTime = LocalDateTime.of(2017, Month.APRIL, 5, 15, 51);
		System.out.println(localDateTime);
		
		localDateTime = LocalDateTime.of(2017, 04, 05, 15, 51, 59);
		System.out.println(localDateTime);
		
		localDateTime = LocalDateTime.of(2017, Month.APRIL, 05, 15, 53, 23);
		System.out.println(localDateTime);
		
		localDateTime = LocalDateTime.of(2017, 04, 05, 15, 53, 23, 999999999);
		System.out.println(localDateTime);
		
	}
	
	public static void main(String[] args) {
		// now();
		// m();
		// m2();
		// m3();
		// m4();
		m5();
	}

}
