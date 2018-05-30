package oc.p.chapters._1_AdvancedClassDesign.workingWithEnums.addingContructorFieldsMethods;

class Outer
{
	private interface  I{
		void i();
	}

	enum E implements I{
		E_1("e_1"){
			@Override public void i()
			{
//				System.out.println("1" + s);  //compiler error: can not access s from a static context
				System.out.println("1" + E.E_1.s);
				System.out.println("1" + E_1.s);
			}
		};

		private String s;

		E(String s)
		{
			this.s = s;
		}
	}

	enum E2 implements I{
		E2_1, E2_2;


		@Override public void i()
		{

		}
	}


}
