package chapters.c3_core_java_apis.datesAndTimes.parsing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import utils.delimitators.Delimitators;

public class Parsing {

	static LocalDate date;
	static LocalTime time;
	static LocalDateTime dateTime;

	static DateTimeFormatter dtf = DateTimeFormatter
			.ofPattern("MM dd yyyy HH:mm");

	static String s = "09 05 2017 11:11";

	static void m() {

		// date = LocalDate.parse("9 5 1986 15:12", dtf);
		// //java.time.format.DateTimeParseException

		// date = LocalDate.parse("09 05 1986 15:12", dtf);
		// //java.time.format.DateTimeParseException:

		date = LocalDate.parse(s, dtf);
		System.out.println(date);
	}

	static void m2(){
		time = LocalTime.parse(s, dtf);
		System.out.println(time);
	}
	
	static void m3(){
		dateTime = LocalDateTime.parse(s, dtf);
		System.out.println(dateTime);
	}
	
	public static void main(String[] args) {
		m();
		Delimitators.equal();
		m2();
		Delimitators.equal();
		m3();
	}

}
