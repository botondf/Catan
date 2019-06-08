package catan;

import java.util.*;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;


/**
 * Tile(TileType type, int value, List<Building> buildings)
 * has own type (w/ item/resource) and value
 * holds the buildings that are connected to it
 * doesn't know its location
 *
 */
public class Tile {
	int rollValue;
	List<Building> buildings;
	private TileType type; // each Tile.Type affects related Item.Type
	private Hexagon hexagon;
	private boolean selected;

	// Button button;
	// Graphics
	// Polygon tileShape;
	// private int[] pos; // (x,y) does the tile actually need to know where it is?
	// or can board handle that?

	Tile(TileType type, int rollValue, List<Building> buildings) { //
		// this.id = id; // does tile need to know its id?
		this.setType(type);
		this.rollValue = rollValue;
		this.setBuildings(buildings);
		hexagon = new Hexagon(this);
	}

	@Override
	public String toString() {
		return "Tile [value=" + rollValue + ", buildings=" + buildings + ", type=" + type + "]";
	}

	public void setRollValue(int value) {
		this.rollValue = value;
	}

	public Hexagon getHexagon() {
		return hexagon;
	}

	public TileType getType() {
		return type;
	}

	public void setType(TileType type) {
		this.type = type;
	}

	public List<Building> getBuildings() {
		return buildings;
	}

	public void setBuildings(List<Building> buildings) {
		this.buildings = buildings;
	}

	public int getRollValue() {
		return rollValue;
	}

	public boolean isSelected() {
		return selected;
	}

	public Color getColor() {
		return type.getColor();
	}

	public void toggleSelected() {
		System.out.println("Tile selected = " + toString());
		boolean oldSelected = this.selected;
		this.selected = !oldSelected;

		hexagon.redraw();
	}
}