package oracle.chapters.c_3_lexicalStructure.literals.floatingPoint.hex;
import static utils.print.Print.*;

public class FlotingPoint {

	static float f;
	static double d;
	
	static void ft(){
		f = 0xa; //integer literal widened to a float
		print("f", f);
		
		f = 0xap0f;  //hex floating literal
		print("f2", f);
		
		f= 0xa.p0f;
		print("f3", f);
		
		f = 0xa_a.p1_0f;
//		f = .e3f; //not allowed
		
		f = 0xa_a.a_ep1f;
		print("f4", f);
		
		f = 0x.ap0_0_0f;
		print("f5", f);
		
		f = .00e3f; //decimal floating porint
		print("f6", f);
		
	}
	
	static void dt(){
		d=0xa; //integer literal widened to a double
		
		d = 0xap0;
		d = 0xa.p0;
		
		d = 0x.ap0;
		d = 0xa.0ap0_0_0_0;
	}
	
	static void ft2(){
		f = 007;
		f = 0b01;
		f = 23;
		f = 0xa;
		f = '\uf000';
		
		f = 009f;
		f = 009e-009f;
		f = 009.0e002f;
		
		f = 0xap0f;
		f = 0x0000.000p000f;
		
//		f = 0X.p0f; invalid hex number
		f = 0x0.p0f;
		f = 0x.0p0f;
		
	}
	
	public static void main(String[] args) {
		ft();
	}
}
