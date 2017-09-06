package oc.a.chapters.c3_core_java_apis.datesAndTimes.periods.trial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import utils.delimitators.Delimitators;

class PeriodTest {

	static LocalDate ld = LocalDate.now();

	static Period p;
	
	static void m(){
		p = Period.of(1, 1, 1);
		
		System.out.println(p);
		System.out.println(ld.plus(p));
		
		Delimitators.equal();
	}
	
	
	static void m2(){
		p = Period.ofYears(1);
		p = p.plus(Period.ofMonths(1));
		p = p.plus(Period.ofWeeks(1));
		p = p.plus(Period.ofDays(1));
		
		System.out.println(p);
		System.out.println(ld.plus(p));
		Delimitators.equal();
	}
	
	static void m3(){
		p = Period.ofYears(1).ofMonths(1).ofWeeks(1).ofDays(1);  //P1D due to the fact that the interfaceMethods are static

		System.out.println(p);
		Delimitators.equal();
	}
	
	static void m4(){
		p = Period.ofYears(1);
		
		System.out.println(p);
		System.out.println(ld.plus(p));
//		System.out.println(LocalTime.now().plus(p));  //java.time.temporal.UnsupportedTemporalTypeException
		System.out.println(LocalDateTime.now().plus(p));
	}
	
	public static void main(String[] args) {
		m();
		m2();
		m3();
		m4();
	}
}
