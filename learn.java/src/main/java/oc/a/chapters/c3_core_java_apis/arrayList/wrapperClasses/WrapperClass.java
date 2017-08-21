package oc.a.chapters.c3_core_java_apis.arrayList.wrapperClasses;

class WrapperClass {

	final static void m(){
		
		Boolean B = new Boolean(true);
		B = new Boolean("true");
	
		B = Boolean.valueOf(true);
		B = Boolean.valueOf("false");

		boolean b = Boolean.parseBoolean("true");		
	}
	
	final static void m2(){
		Byte wrapper = new Byte((byte)2);
		wrapper = new Byte("2");
		
		wrapper = Byte.valueOf((byte)3);
		wrapper = Byte.valueOf("2");
		wrapper = Byte.valueOf("F", 16);  //15
		System.out.println(wrapper);
		
		byte primitive =  Byte.parseByte("5");
		primitive =  Byte.parseByte("0101", 2);
		System.out.println(primitive);
	}
	
	final static void m3(){
		Short wrapper = new Short((short) 5);
		wrapper = new Short("5");
		
		wrapper = Short.valueOf((short) 5);
		wrapper = Short.valueOf("2");
		wrapper = Short.valueOf("007", 8);
		System.out.println(wrapper);
		
		short primitive = Short.parseShort("25");
		primitive = Short.parseShort("AA", 16);
		System.out.println(primitive);

	}
	
	static void m4(){
		Character wrapper = new Character('c');
		wrapper = new Character((char)4);
		
		wrapper = Character.valueOf('c');
		wrapper = Character.valueOf((char)4);
		
		//doesn't have a parse method as all the primitives wrapper classes have
	}
	
	
	static void m5(){
		Integer warpper = new Integer(007);
		warpper = new Integer("5");  //
		
		warpper = Integer.valueOf(10);
		warpper = Integer.valueOf("10");
		warpper = Integer.valueOf("10", 10);
		
		int primitive  = Integer.parseInt("10");
		primitive = Integer.parseInt("10", 10);
		
		primitive = Integer.parseUnsignedInt("+10");
		primitive = Integer.parseUnsignedInt("+10", 10);
		System.out.println(primitive);
		
	}
	
	static void m6(){
		Long wrapper = new Long(1);
		wrapper = new Long("1");
		
		wrapper = Long.valueOf(1);
		wrapper = Long.valueOf("1");
		wrapper = Long.valueOf("1", 2);
		System.out.println(wrapper);
		
		long primitive = Long.parseLong("1");
		primitive = Long.parseLong("1", 2);
		System.out.println(primitive);
	}
	
	
	static void m7(){
		Float wrapper = new Float(1.0f);  //float value
		wrapper = new Float(1.0);  //double value
		wrapper = new Float("1.5");
		
		wrapper = Float.valueOf(15);
		wrapper = Float.valueOf(2.0f);
		wrapper = Float.valueOf("15");
		System.out.println(wrapper);
		
		float primitive = Float.parseFloat("25.0");
		System.out.println(primitive);
	}
	
	final static void m8(){
		Double wrapper = new Double(1.0f);  //the float value is widened to a double
		wrapper = new Double(5.22);
		wrapper = new Double("5.33");
		
		wrapper = Double.valueOf(2.2f);
		wrapper = Double.valueOf("2.2");
		System.out.println(wrapper);
		
		double primitive = Double.parseDouble("2.36");
		System.out.println(primitive);
	}

	
	public final static void main(final String[] args) {
		
//		m2();
//		m3();
//		m5();
//		m6();
//		m7();
		m8();
	}
}
