package oc.a.chapters._1_building_blocks.creating_objects.instance_initializer_blocks;

/*
 * There are 3 code blocks here and 1 instance initializer
 */
public class Blocks {

	{
		System.out.println("Snowy");
	}
	
	public static void main(String[] args){
		{
			System.out.println("Feathers");
		}
		new Blocks();
	}
}
