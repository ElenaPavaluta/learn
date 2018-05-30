package oc.p.chapters._2_PatternsAndPrinciples.introducingFunctionalProgramming.definingAFunctionalInterface.pex;

import java.time.LocalDate;


class Run
{
	void m(FI fi){
		fi.m();
	}

	void m2(FI.I fii){
		fii.m("a");
	}

	void m3(FI.I2 fii2){
		fii2.m(LocalDate.now(), "now");
	}

	void m11(){
		m(new FI()
		{
			@Override public boolean m()
			{
				return false;
			}
		});

		m(()->true);
		m(()->{return true;});
	}

	void m22(){
		m2(new FI.I()  //anonymous inner class
		{
			@Override public void m(String a)
			{

			}
		});

		m2(d ->{});
		m2((String s)-> System.out.println("1"));
		m2((s)->{return;});
	}

	void m33(){
		m3(new FI.I2()
		{
			@Override public boolean m(LocalDate ld, String s)
			{
				return false;
			}
		});  //needs ; because it's a statement (a method call)

		m3((ld, s)->true);
		m3((ld, s)->{return true;});
		m3((LocalDate ls, String s)->{int a = 3; return a!=0;});
	}

}
