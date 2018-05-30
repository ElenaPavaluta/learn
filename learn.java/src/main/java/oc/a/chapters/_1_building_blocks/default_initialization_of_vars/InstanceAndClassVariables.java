package oc.a.chapters._1_building_blocks.default_initialization_of_vars;

import static utils.print.Print.print;

import java.util.Date;

public class InstanceAndClassVariables {

	static boolean b;
	static private Date d;
	static private float f;
	
	double id;
	java.sql.Date isd;
	char ic;

	public static void main(String[] args) {
		print("b", b);
		print("d", d);
		print("f", f);
		
		InstanceAndClassVariables inst = new InstanceAndClassVariables();
		print("id", inst.id);
		print("isd", inst.isd);
		print("ic", inst.ic);
	}
}
