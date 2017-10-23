package oc.p.chapters.c1_AdvancedClassDesign.creatingNestedClasses.innerClass.member;

class Mic
{
	private int x = 10;

	static void m()
	{
		System.out.println(new Mic().x);

		System.out.println(new Mic().new Mic2().x);

		System.out.println(new Mic().new Mic2().new Mic3().x);

		System.out.println(new Mic().new Mic2().new Mic3().new Mic4().x);
	}

	public static void main(String[] args)
	{
		m();
	}

	class Mic2
	{
		private int x = 10 + Mic.this.x;

		class Mic3
		{
			private int x = 10 + Mic2.this.x;

			class Mic4
			{
				private int x = 10 + Mic3.this.x;
			}
		}
	}
}
