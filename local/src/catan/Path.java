package catan;

import java.util.ArrayList;
import java.util.List;

public class Path extends Place {

	private Intersection a;
	private Intersection b;

	Path(Intersection a, Intersection b) {
		super(PlaceType.PATH);
	}

	public Path(Point pathPoint) {
		
	}

	public Intersection getA() {
		return a;
	}

	public Intersection getB() {
		return b;
	}
	
	

}
