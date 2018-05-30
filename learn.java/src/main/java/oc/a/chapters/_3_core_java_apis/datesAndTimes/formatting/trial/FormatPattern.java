package oc.a.chapters._3_core_java_apis.datesAndTimes.formatting.trial;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import utils.delimitators.Delimitators;

class FormatPattern {
	
	static LocalDate ld = LocalDate.now();
	static LocalTime lt = LocalTime.now();
	
	static LocalDateTime ldt = LocalDateTime.of(ld, lt);
	
	static{
		System.out.println(ld);
		System.out.println(lt);
		System.out.println(ldt);
		Delimitators.newLine();
	}

	static String pd = "dd MMMM yyyy";
	static String pt = "hh:mm:ss.n A";
	static String pdt = pd + " " +pt;
	
	
	static void m(){
		DateTimeFormatter f = DateTimeFormatter.ofPattern(pd);
		
		System.out.println(f.format(ld));
//		System.out.println(f.format(lt));  //runtime exception
		System.out.println(f.format(ldt));
		Delimitators.newLine();
	}
	
	static void m2(){
		DateTimeFormatter f = DateTimeFormatter.ofPattern(pt);
		
//		System.out.println(f.format(ld));  //runtime exception
		System.out.println(f.format(lt));  
		System.out.println(f.format(ldt));
		Delimitators.newLine();
	}
	
	static void m3(){
		DateTimeFormatter f = DateTimeFormatter.ofPattern(pdt);
		
//		System.out.println(f.format(ld));  //runtime exception
//		System.out.println(f.format(lt));  
		System.out.println(f.format(ldt));
		Delimitators.newLine();
	}
	
	public static void main(String[] args) {
//		m();
//		m3();
		m3();
	}
	
 }
