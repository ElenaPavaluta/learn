package days.d5_7.t;

class Triangle {

	static double area;
	int b = 3, h = 3;

	public static void main(String[] args) {
		double p, b, h;
		if (area == 0) {
			b = 3;
			h = 4;
			p = 0.5;
		}
		// area = p * b * h; // compiler error if p, b, h aren't initialized
		System.out.println("area: "  + area);
	}
}
