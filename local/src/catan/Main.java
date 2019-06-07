package catan;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Bounds;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
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

	public final double SCREEN_WIDTH = bounds.getWidth();;
	public final double SCREEN_HEIGHT = bounds.getHeight();
	final int FONT_SIZE = 20;
	GameTimer timer;
	Scene scene;
	private Group group;
	private boolean fullscreen = true;
	
	boolean reset;
	boolean pressed;
	public Board board;
	private Button resetButton;
	private Button exitButton;
	private Button rollButton;
	private Text turnText;
	private Logic logic;
	boolean rollClicked;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setX(0);
		stage.setY(0);
		stage.setWidth(bounds.getWidth());
		stage.setHeight(bounds.getHeight());
		// stage.setFullScreen(true);

		logic = new Logic();

		resetButton = new Button();
		resetButton.setText("Reset");
		resetButton.setLayoutX(10);
		resetButton.setLayoutY(10);
		resetButton.setOnAction(this::handleResetButtonClicked);

		exitButton = new Button("Exit");
		exitButton.setLayoutX(10);
		exitButton.setLayoutY(50);
		exitButton.setOnAction(this::handleExitButtonClicked);

		rollButton = new Button("Roll");
		rollButton.setLayoutX(10);
		rollButton.setLayoutY(100);
		rollButton.setOnAction(this::handleRollButtonClicked);

		turnText = new Text();
		turnText.setText("Roll: ");
		turnText.setX(SCREEN_WIDTH / 2);
		turnText.setY(20);

		group = new Group();

		Board board = new Board();

		drawBoard(board);

		Scene scene = new Scene(group, SCREEN_WIDTH, SCREEN_HEIGHT);
		scene.setOnKeyPressed(event -> handleKeyPressed(event));
		scene.setOnKeyReleased(event -> handleKeyReleased(event));
		scene.setOnMousePressed(event -> handleMousePressed(event));
		scene.setOnMouseReleased(event -> handleMouseReleased(event));

		// Set up the stage
		stage.setFullScreen(fullscreen);
		stage.setTitle("Main");
		stage.setScene(scene);
		stage.show();

		timer = new GameTimer();
		timer.start();
	}

	/**
	 * List<Shape> shapes = new ArrayList<Shape>();
	 * 
	 * @param board
	 */
	private void drawBoard(Board board) {
		List<Node> children = group.getChildren();
		children.clear();
		List<Shape> shapes = board.buildTileShapes();
		children.addAll(shapes);
		children.add(resetButton);
		children.add(exitButton);
		children.add(rollButton);
		children.add(turnText);
	}

	public static void main(String[] args) {
		launch(args);
	}

	class GameTimer extends AnimationTimer {

		@Override
		public void handle(long now) {
			if (reset) {
				board = new Board();
				drawBoard(board);
				reset = false;
			}
			if (rollClicked) {
				turnText.setText("Roll: " + logic.roll);
				rollClicked = false;
			}
		}
	}

	private void handleResetButtonClicked(ActionEvent event) {
		reset = true;
		System.out.println("Reset event = " + event);
	}

	private void handleExitButtonClicked(ActionEvent event) {
		System.exit(0);
	}

	private void handleRollButtonClicked(ActionEvent event) {
		logic.rollDice();
		rollClicked = true;
	}

	/*
	 * Method that handles key input from the user
	 */
	private void handleKeyPressed(KeyEvent event) {
		KeyCode code = event.getCode();

		if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
			// board = new Board();
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
			// board = new Board();
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