package catan;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.*;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.effect.*;
import javafx.scene.paint.*;
import java.lang.Math;
import java.util.*;
import catan.BoardUI.*;

import javafx.stage.Popup;
import javafx.stage.Screen;

public class Main extends Application {
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	
	public final static double SCREEN_WIDTH = 1920;
	public final static double SCREEN_HEIGHT = 1080;
	final int FONT_SIZE = 20;
	GameTimer timer;
    Scene scene;
    Circle circle;
    
    @Override
	public void start(Stage myStage) throws Exception { 	
    	List<Shape> shapes = new ArrayList<Shape>();
//    	circle = new Circle();
//    	circle.setCenterX(SCREEN_WIDTH/2);
//    	circle.setCenterY(SCREEN_HEIGHT/2);
//    	circle.setRadius(50);
//    	circle.setFill(Color.AQUAMARINE);
//    	shapes.add(circle);
    	
    	Board board = new Board();
    	
    	for (Tile tile : board.boardTiles) {
			tile.setShape(new Hexagon(tile.x, tile.y));
			tile.shape.setColor(tile.type.getColor());
			shapes.add(tile.shape.hex);
		}
    	
    	myStage.setX(0);
    	myStage.setY(0);
    	myStage.setWidth(SCREEN_WIDTH);//bounds.getWidth());
    	myStage.setHeight(SCREEN_HEIGHT);//bounds.getHeight());
    	myStage.setFullScreen(true);
    	
    	Group group = new Group();
    	group.getChildren().addAll(shapes);
    	
		timer = new GameTimer();
		timer.start();
		
		Scene scene = new Scene(group, SCREEN_WIDTH, SCREEN_HEIGHT);
        scene.setOnKeyPressed(event -> handleKeyPressed(event));
        scene.setOnKeyReleased(event -> handleKeyReleased(event));
        scene.setOnMousePressed(event -> handleMousePressed(event));
        scene.setOnMouseReleased(event -> handleMouseReleased(event));
        
		// Set up the stage
		myStage.setTitle("Main");
		myStage.setScene(scene);
		myStage.show();
	}
	
	public static void main(String[] args) {
        launch(args);
	}
	
	class GameTimer extends AnimationTimer {
        @Override
        public void handle(long now) {
        	
        }
    }
	
	/*
     * Method that handles key input from the user
     */
    private void handleKeyPressed(KeyEvent event) {
        KeyCode code = event.getCode();
 
        if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
        	
        }
        
        if (code == KeyCode.F11) {
        	
        }
    }

    /*
     * Makes the paddle stop moving when the user release the directional key
     */
    private void handleKeyReleased(KeyEvent event) {
        KeyCode code = event.getCode();

        if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
        	
        }
    }
    
    private void handleMousePressed(MouseEvent event) {
    	MouseButton code = event.getButton();
    	
    	if (code == MouseButton.PRIMARY) {
    		
    	}
    }
    
    private void handleMouseReleased(MouseEvent event) {
    	MouseButton code = event.getButton();
    	
    	if (code == MouseButton.PRIMARY) {
    		
    	}
    }

}