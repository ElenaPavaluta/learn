package oc.a.chapters._4_methods_and_encapsulation.encapsulatingData;

public class Swan {

	private int nbOfEggs;

	public int getNbOfEggs() {
		return nbOfEggs;
	}

	public void setNbOfEggs(int nbOfEggs) {
		if (nbOfEggs > 0)  // Guard condition
			this.nbOfEggs = nbOfEggs;
	}

}
