package oc.a.chapters.c1_building_blocks.default_initialization_of_vars;

public class LocalVariables {

	/*
	 * Local variables must be initialized before use 
	 * They do not have a default value and contain garbage data until initialized
	 */

	static void notValid(){
		int y  = 10;
		int x;
//		int r = x+y; //The compiler doesn't let you read a uninitialized local variable
	}
	
	static void findAnswer(boolean check){
		int answer;
		int onlyOneBrach;
		
		if(check){
			onlyOneBrach = 1;
			answer = 1;
		}else{
			answer = 2;
		}
		System.out.println(answer);
//		System.out.println(onlyOneBrach); //does not compile: the onlyOneBrach var hasn't been initialized for the 'else' case
	}
}

