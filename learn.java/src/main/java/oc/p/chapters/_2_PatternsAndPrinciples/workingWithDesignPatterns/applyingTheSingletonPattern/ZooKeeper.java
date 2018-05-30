package oc.p.chapters._2_PatternsAndPrinciples.workingWithDesignPatterns.applyingTheSingletonPattern;

class ZooKeeper
{
	static final HayStorage hs = HayStorage.getInstance();

	static void add(){
		hs.addHay(10);
	}

	static void r(){
		hs.removeHay(3);
	}

	static void g(){

	}
}
