package oc.a.chapters._3_core_java_apis.datesAndTimes.periods;

import java.time.Duration;

public class DurationTest {

	static Duration d;

	static void m() {
		d = Duration.ofDays(1).plusHours(1).plusDays(1).plusMinutes(1)
				.plusSeconds(1).plusNanos(1);
		
		System.out.println(d);
	}
	
	public static void main(String[] args) {
		m();
	}
}
