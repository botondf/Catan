package catan;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Bounds;
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

public class Main extends Application {
	final int SCREEN_WIDTH = 800;
	final int SCREEN_HEIGHT = 600;
	final int FONT_SIZE = 20;
	GameTimer timer;
    Scene scene;
    boolean pressed;
    int timesPressed;
    Text Message1;
    Polygon tile;
    Circle circle;
    

    @Override
	public void start(Stage myStage) throws Exception {
    	Message1 = new Text("Times Space or Enter Pressed: " + timesPressed);
    	Message1.setFont(Font.font(FONT_SIZE));
    	Message1.setX(Message1.maxWidth(FONT_SIZE));
    	Message1.setY(SCREEN_HEIGHT/2-Message1.maxHeight(FONT_SIZE));
    	
    	List<Shape> shapes = new ArrayList<Shape>();
    	
    	int[] tileCoordsX = { 20, 100, 300, 300 };
    	int[] tileCoordsY = { 20, 100, 300, 400 };
    	
    	for (int x = 0; x < tileCoordsX.length; x++) {
    		shapes.addAll(BoardUI.makeTile(tileCoordsX[x],tileCoordsY[x]));
    	}
    	
    	Group group = new Group(Message1);
    	group.getChildren().addAll(shapes);

		timer = new GameTimer();
		timer.start();
		
		Scene scene = new Scene(group, SCREEN_WIDTH, SCREEN_HEIGHT);
        scene.setOnKeyPressed(event -> handleKeyPressed(event));
        scene.setOnKeyReleased(event -> handleKeyReleased(event));
        scene.setOnMousePressed(event -> handleMousePressed(event));
        scene.setOnMouseReleased(event -> handleMouseReleased(event));
        
		// Set up the stage
        MotionBlur motionBlur = new MotionBlur();
        motionBlur.setRadius(5);
        motionBlur.setAngle(-15.0);
        Message1.setFill(Color.web("0x3d226d"));
        Message1.setFont(Font.font("Comic Sans MS", FontWeight.NORMAL, FONT_SIZE)); //FontWeight.BOLD
        Message1.setEffect(motionBlur);
        
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
        		timesPressed++;
//        		txtTimesPressed.setX(Math.random() * 100 + SCREEN_WIDTH/2-txtTimesPressed.maxWidth(FONT_SIZE));
//        		txtTimesPressed.setY(Math.random() * 100 + SCREEN_HEIGHT/2-txtTimesPressed.maxHeight(FONT_SIZE));
        	}
//        	if (pressed) {
//        		//player.incrementItems(player.itemsList.get(z), 10);
//        	}
        	Message1.setText("Times Space or Enter Pressed: " + timesPressed);
    		
        }
    }
	
	/*
     * Method that handles key input from the user
     */
    private void handleKeyPressed(KeyEvent event) {
        KeyCode code = event.getCode();
 
        if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
            pressed = true;
            timesPressed++;
        }
    }
    
    
    
    /*
     * Makes the paddle stop moving when the user release the directional key
     */
    private void handleKeyReleased(KeyEvent event) {
        KeyCode code = event.getCode();

        if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
            pressed = false;
        }
    }
    
    private void handleMousePressed(MouseEvent event) {
    	MouseButton code = event.getButton();
    	
    	if (code == MouseButton.PRIMARY) {
    		pressed = true;
    		//timesPressed++;
    		//System.out.println("LMB DOWN " + event.getX() + ", " + event.getY());
    	}
    }
    
    private void handleMouseReleased(MouseEvent event) {
    	MouseButton code = event.getButton();
    	
    	if (code == MouseButton.PRIMARY) {
    		pressed = false;
    	}
    }

}