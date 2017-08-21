package oc.a.chapters.c1_building_blocks.object_reference_and_primitives.primitives;

public class FloatTest {

	static float f, f2, f3, f32, f33, f4, f5, f6, f7, f8;

	static{
		f = 1;
		f = 1f;
		f = -4;
		f = -5f;
		f = -0000000000000000000001;
		
		f2 = 0b01;
		f2 = -0b01;
//		f2 = 00b01;
		
		f3 = 00;
		f3 = -0000001;
		f3 = 07;
		f3 = 007;
		f3 = 007;
		
//		f32 = 08;
		f32 = 08f;
		
//		f33 = 008;
		f33 = 008f;
		
		f4 = 0xf;
		f4 = 0x0f;
//		f4 = 00xf;
		
		f5 = .1f;
		f5 = 1.1f;
		
//		f6 = .0b10f;
		
		f7 = .07f;
		f7 = .08F;
		f7 = 08.07f;
		
//		f8 = .0xaf;
//		f8 = 0xa.07f;
	}
	
	public static void main(String[] args) {
		System.out.println("f:" + f);
		System.out.println("f2: " +f2);
		System.out.println("f3:" + f3);
		System.out.println("f33: " + f33);
		System.out.println("f4: " + f4);
		System.out.println("f7: " + f7);
	}
}
