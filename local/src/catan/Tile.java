package catan;

import java.util.List;
import javafx.scene.paint.Color;

/**
 * Tile(TileType type, int value, List<Building> buildings) has own type (w/
 * item/resource) and value holds the buildings that are connected to it doesn't
 * know its location
 *
 */
public class Tile {
	int rollValue;
	List<Building> buildings;
	private TileType type; // each Tile.Type affects related Item.Type
	private TileGraphics tileGfx;
	private boolean selected;
	private List<Place> places;
//	private List<Tile> neighbours;

	Tile(TileType type, int rollValue, List<Building> buildings) {
		this.setType(type);
		this.rollValue = rollValue;
		this.setBuildings(buildings);
		tileGfx = new TileGraphics(this);
		//places = hexagon.getPlaces()
	}

	@Override
	public String toString() {
		return "Tile [value=" + rollValue + ", buildings=" + buildings + ", type=" + type + ", places=" + places + "]";
	}
	
	public List<Place> getPlaces() {
		return places;
	}
	
	public void setPlaces(List<Place> places) {
		this.places = places;
	}
	
	public void setRollValue(int value) {
		this.rollValue = value;
	}

	public TileGraphics getTileGraphics() {
		return tileGfx;
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

		tileGfx.redraw();
	}
}