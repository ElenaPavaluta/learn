package chapters.c3_core_java_apis.datesAndTimes.periods;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {

	static Period p;

	static void m() {
		p = Period.ofYears(1).ofMonths(1); // same as: p = Period.ofYears(1); p
											// = Period.ofMonths(1);

		System.out.println(p.getYears());
		System.out.println(p.getMonths());

		p = Period.ofYears(1);
		p = Period.ofMonths(1);

		System.out.println(p.getYears());
		System.out.println(p.getMonths());
	}

	static void m2() {
		LocalDate d = LocalDate.of(1, 1, 1).of(2, 2, 2); // same as: d =
															// LocalDate.of(1,
															// 1, 1); d =
															// LocalDate.of(2,
															// 2, 2);
		System.out.println(d);

		d = LocalDate.of(1, 1, 1);
		d = LocalDate.of(2, 2, 2);
		System.out.println(d);
	}

	static void m3() {
		p = Period.ofYears(1).plusMonths(1).plusDays(1);
		System.out.println(p.getYears());
		System.out.println(p.getMonths());
		System.out.println(p.getDays());
	}

	public static void main(String[] args) {
		// m();
		// m2();
		m3();
	}
}
