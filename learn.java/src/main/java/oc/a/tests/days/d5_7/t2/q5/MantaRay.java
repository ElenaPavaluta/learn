package days.d5_7.t2.q5;

class MantaRay implements CanSwim{

	@Override
	public void swim() {
		System.out.println(SPEED);
	}

	public static void main(String[] args) {
		System.out.println(MantaRay.SPEED);
		System.out.println(CanSwim.SPEED);
		System.out.println(new MantaRay().SPEED);
		new MantaRay().swim();
		
	}
	
}
