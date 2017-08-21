package oc.a.chapters.c3_core_java_apis.datesAndTimes.manipulate.trial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import utils.delimitators.Delimitators;

class Manipulate {

	static LocalDate ld = LocalDate.now();
	static LocalTime lt = LocalTime.now();

	static LocalDateTime ldt = LocalDateTime.of(ld, lt);

	static {
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		Delimitators.equal();
	}

	static void m() {
		ld = ld.plusYears(1).minusYears(1);
		ld = ld.plusMonths(1).minusMonths(1);
		ld = ld.plusWeeks(1).minusWeeks(1);
		ld.plusDays(1).minusDays(1);

		System.out.println(ld);
		Delimitators.equal();
	}

	static void m2() {
		lt = lt.plusHours(1).minusHours(1);
		lt = lt.plusMinutes(1).minusMinutes(1);
		lt = lt.plusSeconds(1).minusSeconds(1);
		lt = lt.plusNanos(1).minusNanos(1);

		System.out.println(lt);
		Delimitators.equal();
	}

	static void m3() {
		ldt = ldt.plusWeeks(2).minusHours(21).plusHours(21).minusWeeks(2);
		System.out.println(ldt);
		Delimitators.equal();
	}

	public static void main(String[] args) {
		m();
		m2();
		m3();
	}
}
