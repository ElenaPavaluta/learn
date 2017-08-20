package chapters.c3_core_java_apis.datesAndTimes.formatting.trial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import utils.delimitators.Delimitators;

class Formatting {

	static LocalDate ld = LocalDate.now();
	static LocalTime lt = LocalTime.now();
	
	static LocalDateTime ldt = LocalDateTime.of(ld, lt);
	
	static{
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		Delimitators.newLine();
	}
	
	static void m(){
		System.out.println(ld.getYear());
		System.out.println(ld.getMonth());
		System.out.println(ld.getDayOfYear());
		System.out.println(ld.getDayOfMonth());
		System.out.println(ld.getDayOfWeek());
		Delimitators.newLine();
	}
	
	static void m2(){
		System.out.println(lt.getHour());
		System.out.println(lt.getMinute());
		System.out.println(lt.getSecond());
		System.out.println(lt.getNano());
		Delimitators.newLine();
	}
	
	static void m3(){
		System.out.println(ldt.getDayOfYear());
		System.out.println(ldt.getHour());
	}
	
	static void m4(){
		System.out.println(ld.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(lt.format(DateTimeFormatter.ISO_LOCAL_TIME));
		System.out.println(ldt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		Delimitators.newLine();
	}
	
	static void m5(){
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		
		System.out.println(ld.format(f));
//		System.out.println(lt.format(f));  //runtime exception
		System.out.println(ldt.format(f));
		Delimitators.newLine();
		
		f = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(ld.format(f));
//		System.out.println(lt.format(f));  //runtime exception
		System.out.println(ldt.format(f));
		Delimitators.newLine();
	}
	
	static void m6(){
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
		
//		System.out.println(ld.format(f)); //runtime exception
		System.out.println(lt.format(f));  
		System.out.println(ldt.format(f));
		Delimitators.newLine();
		
		f = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
//		System.out.println(ld.format(f));  //runtime exception
		System.out.println(lt.format(f));  
		System.out.println(ldt.format(f));
		Delimitators.newLine();
	}
	
	static void m7(){
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		
//		System.out.println(ld.format(f)); //runtime exception
//		System.out.println(lt.format(f));  //runtime exception
		System.out.println(ldt.format(f));
		Delimitators.newLine();
		
		f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
//		System.out.println(ld.format(f));  //runtime exception
//		System.out.println(lt.format(f));  //runtime exception
		System.out.println(ldt.format(f));
		Delimitators.newLine();
	}
	
	static void m8(){
		DateTimeFormatter f = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(f.format(ld));
		
		 f = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		 System.out.println(f.format(ld));
	}
	
	
	public static void main(String[] args) {
//		m();
//		m2();
//		m3();
//		m4();
		m5();
		m6();
		m7();
//		m8();
	}
	
	
}
