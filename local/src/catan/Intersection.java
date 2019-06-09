package catan;

import java.util.ArrayList;
import java.util.List;

public class Intersection extends Place {
	private List<Path> paths;
	private Point point;

	Intersection(Point point) {
		super(PlaceType.INTERSECTION);
		this.point = point;
	}

	@Override
	public String toString() {
		return "Intersection [paths=" + paths + ", point=" + point + "]";
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void addNeighbour(Intersection intersection) {
		Path path = new Path(this, intersection);
		paths.add(path);
	}
	
	public List<Intersection> getNeighbours() {
		List<Intersection> neighbours = new ArrayList<>();
		
		paths.forEach(path -> neighbours.add(path.getB()));
		
		return neighbours;
	}

	public Point getPoint() {
		return point;
	}
}