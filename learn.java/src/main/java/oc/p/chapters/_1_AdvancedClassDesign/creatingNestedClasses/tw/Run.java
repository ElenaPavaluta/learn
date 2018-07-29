package oc.p.chapters._1_AdvancedClassDesign.creatingNestedClasses.tw;

class Run
{
	InnerClassInInterface i = new InnerClassInInterface()
	{
	};
	Impl impl = new Impl();

	void m()
	{
		InnerClassInInterface.I ii = new InnerClassInInterface.I()
		{
			@Override public void m()
			{
			}
		};
		ii.m();
		ii.defaultM();
		InnerClassInInterface.I.staticM();
	}

	void m2(){
		InnerClassInInterface.I ii = new InnerClassInInterface.AI();
		ii.m();
		ii.defaultM();
		InnerClassInInterface.I.staticM();
	}

	void m3(){
		InnerClassInInterface.AI ia = new InnerClassInInterface.AI();
		ia.m();
		ia.defaultM();
		ia.staticMA();
		InnerClassInInterface.AI.staticMA();
		InnerClassInInterface.I.staticM();
	}

	void m4(){
		InnerClassInInterface.I2 ii2 = new InnerClassInInterface.I2()
		{
			@Override public void m()
			{
			}
		};

		ii2.m();
		ii2.defaultM();
		InnerClassInInterface.I2.staticM();
	}

	void m5(){
		InnerClassInInterface.I2 ii2 = new InnerClassInInterface.BI2();
		ii2.m();
		ii2.defaultM();
		InnerClassInInterface.I2.staticM();
	}

	void m6(){
		InnerClassInInterface.BI2  ib= new InnerClassInInterface.BI2();
		ib.m();
		ib.defaultM();
		ib.staticMB();
		InnerClassInInterface.BI2.staticMB();
		InnerClassInInterface.I2.staticM();
	}

	void m7(I i){
		i.m();
	}

	void m8(){
		m7(new I()
		{
//			static int anInt = 5;  //anonymous inner classes can not have either static members or methods

			@Override public void m()
			{
			}
		});
	}
	void m9(){
		class A implements I{
//			static int anInt = 7;  //local inner classes can not have either static members or methods
			@Override public void m()
			{

			}
		}
	}
}
