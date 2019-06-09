package catan;

public class Path extends Place {

	private Intersection a;
	private Intersection b;

	Path(Intersection a, Intersection b) {
		super(PlaceType.PATH);
	}

	public Intersection getA() {
		return a;
	}

	public Intersection getB() {
		return b;
	}

}
