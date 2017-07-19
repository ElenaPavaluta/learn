package books.thinkigInJava4ThEdition.chapters.annotations.generalPurpose;

class SubInfo extends Info{

	@SuppressWarnings("deprecation")
	@Override
	void m() {
		super.m();
	}
	
	public static void main(String[] args) {
		new SubInfo().m();
	}

	
}
