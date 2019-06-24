package catan;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

public class Place {

	private PlaceType placeType;

	private Group group;
	private List<Tile> tiles = new ArrayList<>();
	private Building building;
	private Point point;

	Place(PlaceType placeType, Point point) {
		this.placeType = placeType;
		this.point = point;
		group = new Group();
	}
	
	public Building getBuilding() {
		return building;
	}

	public Point getPoint() {
		return point;
	}

	@Override
	public String toString() {
		return "Place [placeType=" + placeType + "]";
	}
	
	public PlaceType getPlaceType() {
		return placeType;
	}

	public void addBuilding(Building building) {
		this.building = building;
	}
	
	public void setShape(Node shape) {
		shape.setOnMouseClicked((event) -> this.handleClicked());
		group.getChildren().clear();
		group.getChildren().add(shape);
	}
	
	public Node getShape() {
		return group;
	}

	public void addTile(Tile tile) {
		tiles.add(tile);		
	}

	public List<Tile> getTiles() {
		return tiles;
	}
	
	public void setBuilding(Building newBuilding) {
		building = newBuilding;
	}
	
	public Shape makeEmptyShape() {
		Circle circle = new Circle();
		circle.setRadius(TileGraphics.PLACE_CIRCLE_RADIUS);
		circle.setCenterX(getPoint().getX());
		circle.setCenterY(getPoint().getY());
		circle.setFill(getPlaceType().getColor());
		circle.setStroke(Color.BLACK);
		return circle;
	}

	public Node makeBuildingShape(Player player) {
		
		BuildingGraphics buildingGraphics = new BuildingGraphics(this, getBuilding().getType(), player.getColor());
		return buildingGraphics.getNode();
	}
	
	protected void handleClicked() {
		throw new RuntimeException("handleClicked Not implemented");
	}

}
