package catan;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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

import javax.lang.model.element.Modifier;

import catan.BoardUI.*;

import javafx.stage.Popup;
import javafx.stage.Screen;


public class Main extends Application {
	Screen screen = Screen.getPrimary();
	Rectangle2D bounds = screen.getVisualBounds();
	
	public final double SCREEN_WIDTH = 1920;
	public final double SCREEN_HEIGHT = 1980;
	final int FONT_SIZE = 20;
	GameTimer timer;
    Scene scene;
    Circle circle;
    Button reset;
	boolean fs;
	boolean close;
	//Board board;
	boolean pressed;
	public Board board;
	
    @Override
	public void start(Stage myStage) throws Exception { 	
    	List<Shape> shapes = new ArrayList<Shape>();
    	
    	
    	
    	Board board = new Board();
    	
    	reset = new Button();
    	reset.setText("Reset");
    	reset.setLayoutX(10);
    	reset.setLayoutY(10);
    	reset.setOnAction((event -> System.out.println(board.toString())));//handleButtonClick(event)));
    	
    	for (Tile tile : board.boardTiles) {
			tile.setShape(new Hexagon(tile.x, tile.y, tile.value));
			tile.shape.setColor(tile.type.getColor());
			shapes.add(tile.shape.hex);
			shapes.add(tile.shape.circle);
			shapes.add(tile.shape.text);
		}
    	
    	myStage.setX(0);
    	myStage.setY(0);
    	myStage.setWidth(bounds.getWidth());//bounds.getWidth());
    	myStage.setHeight(bounds.getHeight());//bounds.getHeight());
    	myStage.setFullScreen(true);
    	//myStage.setFullScreenExitHint("ESC to exit fullscreen");
    	
    	Group group = new Group();
    	group.getChildren().addAll(shapes);
    	group.getChildren().add(reset);
    	
		timer = new GameTimer();
		timer.start();
		
//		Button exitButton = new Button("Exit");
//		exitButton.setOnAction(event -> handleButtonClicked(event));
		
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
        	if (pressed) {
	        	System.out.println("aa");
	        	board = new Board();
        	}
        }
    }
	
	private void handleButtonClick(ActionEvent event) {
		if (event.getSource().equals(reset)) {
			pressed = true;
		}
	}
	
	/*
     * Method that handles key input from the user
     */
    private void handleKeyPressed(KeyEvent event) {
        KeyCode code = event.getCode();
 
        if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
        	//board = new Board();
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
        	//board = new Board();
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