package oc.a.chapters._3_core_java_apis.javaArrays.creatingAnArrayOfPrimitives;

class Array {

	/*
	 * Valid declarations
	 */
	int[] numbers;

	int [] numbers2; // space between int and []

	int numbers3[];

	int numbers4 []; // space between numbers4 and []

	
	/*
	 * initialization
	 */
	{
		numbers = new int[3]; // in this case all the elements will be
								// initialized to the dbType defaulT value

		numbers2 = new int[] { 1, 2, 3, };

		// numbers3 = {1,2,3,};// compiler error

		// numbers4 = new int[3]{1,2,3,}; compiler error

		int[] numbers5 = { 1, 2, 3, }; // anonymous array: don't specify the
										// dbType and size
	}

	
	static void m(){
		Array a = new Array();
		for(int i:a.numbers){
			System.out.println(i);
		}
	}
	
	static void m2(){
		int[] ia = {1,2,3};
		for(int i: ia){
			System.out.println(i);
		}
	}
	
	static void m3(){
		int[] ids, types;
		
		ids = new int[3];
		types = new int[]{1,2,3};
		
		System.out.println("int[] ids, types;  //types it's an array here");
	}
	
	static void m4(){
		int ids[], types;
		
		ids = new int[3];
		types = 5;
		
		System.out.println("nt ids[], types;  //types it's just an int here");
	}
	
	
	public static void main(String[] args) {
//		createAndPopulate();
//		m3();
		m3();
		m4();
	}
}
