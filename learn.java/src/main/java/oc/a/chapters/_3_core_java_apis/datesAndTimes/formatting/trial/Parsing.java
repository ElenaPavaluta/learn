package oc.a.chapters._3_core_java_apis.datesAndTimes.formatting.trial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import utils.delimitators.Delimitators;

class Parsing {

	static String pd = "dd MM yyyy";
	static String pt = "hh:mm:ss.n a";
	static String pdt = pd + " " +pt;
	
	static DateTimeFormatter fd = DateTimeFormatter.ofPattern(pd);
	static DateTimeFormatter ft = DateTimeFormatter.ofPattern(pt);
	static DateTimeFormatter fdt = DateTimeFormatter.ofPattern(pdt);
	
	
	static String sd = "05 05 2017";
	static String st = "12:12:12.345 AM";
	static String sdt = sd + " " + st;
	
	static LocalDate ld;
	static LocalTime lt;
	static LocalDateTime ldt;

	static void m(){
		ld = LocalDate.parse("2017-05-05");
		System.out.println(ld);
		
		lt = LocalTime.parse("15:12:23");
		System.out.println(lt);
		
		ldt = LocalDateTime.parse("2017-05-05T15:12:23");
		System.out.println(ldt);
		Delimitators.newLine();
	}
	
	static void m2(){
//		ld = LocalDate.parse("2017-05-05T15:12:23");  //Runtime exception
//		System.out.println(ld);
		
//		lt = LocalTime.parse("2017-05-05T15:12:23");  //RunTime exception
//		System.out.println(lt);
		
		ldt = LocalDateTime.parse("2017-05-05T15:12:23");
		System.out.println(ldt);
		Delimitators.newLine();
	}
	
	
	static void m3(){
		ld = LocalDate.parse(sd, fd);
		System.out.println(ld);
		
		lt = LocalTime.parse(st, ft);
		System.out.println(lt);
		
		ldt = LocalDateTime.parse(sdt, fdt);
		System.out.println(ldt);
		Delimitators.newLine();
	}
	
	static void m4(){
//		ld = LocalDate.parse(sdt, fd);  //RuntimeException
//		System.out.println(ld);
		
//		lt = LocalTime.parse(sdt, ft);  //RuntimeException
//		System.out.println(lt);
		
		ldt = LocalDateTime.parse(sdt, fdt);
		System.out.println(ldt);
		Delimitators.newLine();
	}
	
	static void m5(){
		System.out.println(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE));
	}
	
	static void m6(){
		ldt = LocalDateTime.parse(sd, fdt);  //RuntimeException
	}
	
	static void m7(){
		ld = LocalDate.parse(sdt, fd);  //RuntimeException
	}
	
	public static void main(String[] args) {
//		m();
//		m3();
//		m4();
//		m4();
//		m5();
//		m6();
//		m7();
	}
}



