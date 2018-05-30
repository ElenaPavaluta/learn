package oc.p.chapters._1_AdvancedClassDesign.workingWithEnums.addingContructorFieldsMethods;

class Outer2
{
	private interface I
	{
		void i();
	}

	protected enum Ea implements I{
		;  //needs to be here, otherwise compiler error

		@Override public void i()
		{

		}
	}

	protected enum Eb implements I{
		A(){
			@Override public void i()
			{
				System.out.println("specialized");
			}
		},
		B();

		@Override public void i()
		{
			System.out.println("default");
		}
	}

	enum Ec{
		A, B{
			@Override public void ec()
			{
				System.out.println("B ec");
			}
		} ;
		public void ec(){
			System.out.println("default ec");
		}
	}

	public static void main(String[] args)
	{
		Eb.A.i();
		Eb.B.i();

		Ec.A.ec();
		Ec.B.ec();
	}
}

