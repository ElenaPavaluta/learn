package chapters.c3_core_java_apis.datesAndTimes.formatting;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import utils.delimitators.Delimitators;

public class Formatting {

	static LocalDate date = LocalDate.now();
	static LocalTime time = LocalTime.now();
	static LocalDateTime dateTime = LocalDateTime.of(date, time);

	static void m() {
		System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));

		// System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_DATE));
		// //java.time.temporal.UnsupportedTemporalTypeException
		System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));

		// System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		// //java.time.temporal.UnsupportedTemporalTypeException:
		System.out.println(dateTime
				.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
	}

	// FormatStyle.SHORT FormatStyle.MEDIUM for exam
	static void m2() {
		DateTimeFormatter shortDataType = DateTimeFormatter
				.ofLocalizedDate(FormatStyle.SHORT);

		System.out.println(date.format(shortDataType));

		// System.out.println(time.format(shortDataType)); //
		// java.time.temporal.UnsupportedTemporalTypeException

		System.out.println(dateTime.format(shortDataType)); // outputs only the
															// date in the
															// dateTime object
	}

	static void m3() {
		DateTimeFormatter shortDataType = DateTimeFormatter
				.ofLocalizedTime(FormatStyle.SHORT);

		// System.out.println(date.format(shortDataType)); //
		// UnsupportedTemporalTypeException

		System.out.println(time.format(shortDataType));

		// System.out.println(dateTime.format(shortDataType)); //
		// UnsupportedTemporalTypeException
	}

	static void m4() {
		DateTimeFormatter shortDataType = DateTimeFormatter
				.ofLocalizedDateTime(FormatStyle.SHORT);

		// System.out.println(date.format(shortDataType)); //
		// UnsupportedTemporalTypeException

		// System.out.println(time.format(shortDataType));
		// //UnsupportedTemporalTypeException

		System.out.println(dateTime.format(shortDataType));
	}

	public static void main(String[] args) {
		m();
		Delimitators.equal();
		m2();
		Delimitators.equal();
		m3();
		Delimitators.equal();
		m4();
	}
}
