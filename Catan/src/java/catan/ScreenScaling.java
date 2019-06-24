package catan;

public class ScreenScaling {
	private double tileEdge;
	private double tileHeight;
	private double tileGap;
	private double hexStrokeWidthDefault;
	private double hexStrokeWidthSelected;
	private double tileFontSize;
	private double placeCircleRadius;
	private double pointNearbyRadius;
	
	private double smallFont;
	private double xSmallFont;
	private double mediumFont;
	private double largeFont;
	private double xLargeFont;
	
	public ScreenScaling(double screenW, double screenH) {
		tileHeight = screenH / 14; // 2x5 tile h's + 2x2 gaps
		tileEdge = tileHeight / Math.sin(Math.toRadians(60));
		// Tile graphical properties calculated using percentages based on the calculated edge
		tileGap = tileEdge * 0.047;
		hexStrokeWidthDefault = tileEdge * 0.038;
		hexStrokeWidthSelected = tileEdge * 0.062;
		tileFontSize = tileEdge * 0.14;
		placeCircleRadius = tileEdge * 0.124;
		pointNearbyRadius = tileEdge * 0.095;
		
		xSmallFont = tileHeight * 0.14;
		smallFont = tileHeight * 0.15;
		mediumFont = tileHeight * 0.3;
		largeFont = tileHeight * 0.45;
		xLargeFont = tileHeight * 0.75;
	}

	public double getXSmallFont() {
		return xSmallFont;
	}

	public double getTileEdge() {
		return tileEdge;
	}

	public double getTileHeight() {
		return tileHeight;
	}

	public double getTileGap() {
		return tileGap;
	}

	public double getHexStrokeWidthDefault() {
		return hexStrokeWidthDefault;
	}

	public double getHexStrokeWidthSelected() {
		return hexStrokeWidthSelected;
	}

	public double getTileFontSize() {
		return tileFontSize;
	}

	public double getPlaceCircleRadius() {
		return placeCircleRadius;
	}

	public double getPointNearbyRadius() {
		return pointNearbyRadius;
	}

	public double getSmallFont() {
		return smallFont;
	}

	public double getMediumFont() {
		return mediumFont;
	}

	public double getLargeFont() {
		return largeFont;
	}

	public double getXLargeFont() {
		return xLargeFont;
	}
	
	
}
