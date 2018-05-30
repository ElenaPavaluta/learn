package oc.a.chapters._3_core_java_apis.datesAndTimes.create.wrk;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

import utils.delimitators.Delimitators;

class Create {

	static LocalDate ld = LocalDate.now();
	static LocalTime lt = LocalTime.now();
	
	static LocalDateTime ldt = LocalDateTime.of(ld, lt);
	
	static{
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
	}
	
	static void m(){
		ld = LocalDate.of(1997, 5, 02);
		System.out.println(ld);
		
		ld = LocalDate.of(2036, Month.MARCH, 31);
		System.out.println(ld);
	}
	
	static void m2(){
//		lt = LocalTime.of(14, 65);  //DateTimeException
//		lt = LocalTime.of(25, 22);  //DateTimeException
		
		lt = LocalTime.of(14, 14);
		lt = LocalTime.of(14, 14, 14);
		lt = LocalTime.of(14, 14, 14, 14);
		System.out.println(lt);
	}
	
	public static void main(String[] args) {
		Delimitators.equal();
		
		m();
		Delimitators.equal();
		
		m2();
	}
}
