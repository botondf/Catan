package catan;

import javafx.scene.Node;
//import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class BuildingGraphics {
	private Place place;
	private Node node;
	private BuildingType buildingType;
	private Color playerColor;

	BuildingGraphics(Place place, BuildingType buildingType, Color playerColor) {
		this.place = place;
		this.buildingType = buildingType;
		this.playerColor = playerColor;
		makeGraphics();
	}

	public Place getPlace() {
		return place;
	}

	public Node getNode() {
		return node;
	}

	public void makeGraphics() {
		switch (buildingType) {
		case ROAD:
			makeRoad();
			break;

		case VILLAGE:
			makeVillage();
			break;

		case CITY:
			makeCity();
			break;
		}
	}

	private void makeCity() {
		ImageView imgvCity = new ImageView();
		// Image is based on player number. 1 = blue, 2 = red
		imgvCity.setImage((Catan.logic.getCurrentPlayer().getId() == 1) ? new Image(getClass().getResourceAsStream("/images/city_blue.png")) : new Image(getClass().getResourceAsStream("/images/city_red.png")));
		imgvCity.setX(place.getPoint().getX() - imgvCity.getLayoutBounds().getWidth() / 2);
		imgvCity.setY(place.getPoint().getY() - imgvCity.getLayoutBounds().getHeight() / 2);
		imgvCity.setScaleX(Catan.scale.getXSmallFont() / 12);
		imgvCity.setScaleY(Catan.scale.getXSmallFont() / 12);
		node = imgvCity;
	}

	private void makeVillage() {
		ImageView imgvVillage = new ImageView();
		// Image is based on player number. 1 = blue, 2 = red
		imgvVillage.setImage((Catan.logic.getCurrentPlayer().getId() == 1) ? new Image(getClass().getResourceAsStream("/images/village_blue.png")) : new Image(getClass().getResourceAsStream("/images/village_red.png")));
		imgvVillage.setX(place.getPoint().getX() - imgvVillage.getLayoutBounds().getWidth() / 2);
		imgvVillage.setY(place.getPoint().getY() - imgvVillage.getLayoutBounds().getHeight() / 2);
		imgvVillage.setScaleX(Catan.scale.getXSmallFont() / 12);
		imgvVillage.setScaleY(Catan.scale.getXSmallFont() / 12);

		node = imgvVillage;
	}

	private void makeRoad() {
		Path path = (Path) place;

		Line line = new Line();
		line.setStartX(path.getA().getPoint().getX());
		line.setStartY(path.getA().getPoint().getY());
		line.setEndX(path.getB().getPoint().getX());
		line.setEndY(path.getB().getPoint().getY());
		line.setStrokeWidth(TileGraphics.GAP + 1);
		line.setStroke(playerColor);

		node = line;
	}
	
	public void setColor(Color color) {
		playerColor = color;
	}
}
