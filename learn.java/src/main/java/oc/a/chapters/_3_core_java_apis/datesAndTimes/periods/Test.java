package oc.a.chapters._3_core_java_apis.datesAndTimes.periods;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

import utils.delimitators.Delimitators;

public class Test {

	static LocalDate date = LocalDate.now();
	static LocalTime time = LocalTime.now();
	static LocalDateTime dateTime = LocalDateTime.of(date, time);

	static {
		System.out.println(dateTime); // T separator between date and time; .
										// separator for nono seconds
		Delimitators.equal();
	}

	static void m() {
		Period p = Period.ofDays(1);

		date = date.plus(p);
		// time = time.plus(p); // UnsupportedTemporalTypeException:
		dateTime = dateTime.plus(p);

		print();
		Delimitators.equal();
	}


	
	static void m2(){
		Duration d = Duration.ofDays(1);
		
//		date = date.plus(d);  //UnsupportedTemporalTypeException
		time = time.plus(d);
		dateTime = dateTime.plus(d);
		
		print();
	}

	public static void main(String[] args) {
		m();
		m2();
	}
	
	private static void print() {
		System.out.println(date);
		System.out.println(time);
		System.out.println(dateTime);
	}
}
