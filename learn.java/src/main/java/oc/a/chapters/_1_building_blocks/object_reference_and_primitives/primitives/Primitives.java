package oc.a.chapters._1_building_blocks.object_reference_and_primitives.primitives;

public class Primitives {
	
	boolean bool = false;
//	boolean bool2 = -1;

	/*
	 * 2^7 - 2^7-1;
	 */
	byte b = 1;
	byte b2 = 0b1011;
	byte b3 = 0_1;
	byte b4 = 0x1;
	
	/*
	 * 2^15 - 2^15-1
	 */
	short s = 1;
	short s2 = 0b01;
	short s3 = 0_7;
	short s4 = 0xa;
	
	/*
	 * 2^31-2^31-1
	 */
	int i = 027;
	int i2 = 0b0_1;
	int i3 = 0_7;
	int i4 = 0xa_b;
	
	/*
	 * 2^63-2^63-1
	 */
	long l = 27l;
	long l2 = 0b01L;
	long l3 = 0_777L;
	long l4 = 0xf_f_f__fL;
	
	/*
	 * 0 2^16-1
	 * 16 bit Unicode value
	 */
	char c = 0;
	char c2 = 0b01;
	char c3 = 011;
	char c4 = 0xf;
	
	/*
	 * 32-bit floating point value
	 */
	float f = 0.1f;
	float f2 = 0b10;
	float f3 = 007;
	float f4 = 0x0fd;
	
	/*
	 * 64-bit floating point value
	 */
	double d = 0.1;
	double d2 = 0b0;
	double d3 = 007f;
	double d4 = 0xa;
}


class Base{
	
	static int binary = 0b1_0_0;
	
	static int octal = 0_7;
	static int o2 = 0_0_0_2;
	
	static int hexadecimal = 0xa_b_c_d_e_f;
	static int h2 = 0x0_1;
	static int h3 = 0x00000000;
	static int h4 = 0x00000003;
	
	static int decimal = 0_1; //it's interpreted as an octal number
	static int d2 = 0xb;
	
	public static void main(String[] args) {
//		System.out.println(octal);
		System.out.println(o2);
		
//		System.out.println(hexadecimal);
//		System.out.println(h2);
//		System.out.println(h3);
//		System.out.println(h4);
		
//		System.out.println(decimal);
	}
}



