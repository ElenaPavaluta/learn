package oc.a.chapters._3_core_java_apis.datesAndTimes.periods;

import java.time.LocalDate;
import java.time.Period;

public class Zoo {

	public static void main(String[] args) {
		LocalDate sd = LocalDate.now();
		LocalDate ed = sd.plusMonths(3);
		
//		newToy(sd, ed);
		
		Period p = Period.ofWeeks(2);
		newToy(sd, ed, p);
	}

	static void newToy(LocalDate sd, LocalDate ed) {
		LocalDate upTo = sd;
		while (upTo.isBefore(ed)) {
			System.out.println("give me new toy: " + upTo);
			upTo = upTo.plusMonths(1);
		}
	}
	
	static void newToy(LocalDate sd, LocalDate ed, Period p){
		LocalDate upTo = sd;
		while (upTo.isBefore(ed)) {
			System.out.println("give me new toy: " + upTo);
			upTo = upTo.plus(p);
		}
	}
}
