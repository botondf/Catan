package catan;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.paint.*;
import java.util.List;
import java.util.ArrayList;
import javafx.stage.Screen;

/**
import catan.BoardUI.*;
import javafx.stage.Popup;
import javax.lang.model.element.Modifier;
import javafx.scene.image.ImageView;
import javafx.scene.effect.*;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import java.lang.Math;
import javafx.geometry.Bounds;
import javafx.animation.AnimationTimer;
**/


public class Main extends Application {
	private static Screen screen = Screen.getPrimary();
	private static Rectangle2D bounds = screen.getVisualBounds();

	public static final double SCREEN_WIDTH = bounds.getWidth();
	public static final double SCREEN_HEIGHT = bounds.getHeight();
	
	final double FONT_SIZE = 20;
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
	boolean rollSetColor;
	boolean tileClicked;
	boolean exit;
	// Stage stage;
	// Turn turn;
	List<Node> playersScreenData;

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
		turnText.setText("Roll");
		turnText.setX(SCREEN_WIDTH / 2);
		turnText.setY(20);

		final int NUM_PLAYERS = 2;
		Player[] players = new Player[NUM_PLAYERS];

		for (int x = 0; x < NUM_PLAYERS; x++) {
			players[x] = new Player(x + 1);
			players[x].getBuildings().add(new Building(BuildingType.CITY, players[x], new Place(PlaceType.INTERSECTION)));
			players[x].checkVP();
		}
		
		playersScreenData = new ArrayList<Node>();
		
		// circle water background
		Circle boardCircle = new Circle();
		boardCircle.setFill(Color.SKYBLUE);
		boardCircle.setRadius(SCREEN_WIDTH / 3.75);
		boardCircle.setCenterX(SCREEN_WIDTH / 2);
		boardCircle.setCenterY(SCREEN_HEIGHT / 2);
		playersScreenData.add(boardCircle);
		
		//
		Circle boardCircleBlank = new Circle();
		boardCircleBlank.setFill(Color.WHITE);
		boardCircleBlank.setRadius(SCREEN_WIDTH / 5.45); //4.9 (1080p) /5.45 * .2
		boardCircleBlank.setCenterX(SCREEN_WIDTH / 2);
		boardCircleBlank.setCenterY(SCREEN_HEIGHT / 2);
		playersScreenData.add(boardCircleBlank);

		// rectangle water background
//		Rectangle rect = new Rectangle();
//		rect.setX(SCREEN_WIDTH / 4);
//		rect.setY(50);
//		rect.setFill(Color.SKYBLUE);
//		rect.setWidth(SCREEN_WIDTH / 2);
//		rect.setHeight(SCREEN_HEIGHT - 100);
//		playersScreenData.add(rect);
		
		for (int x = 0; x < NUM_PLAYERS; x++) {
			Text id = new Text();
			id.setX((players[x].getId() == 1) ? 50 : SCREEN_WIDTH/1.25);
			id.setY(200);
//			id.setLayoutX(100);//SCREEN_WIDTH - id.getLayoutBounds().getMinX());
//			id.setLayoutY(100);//SCREEN_HEIGHT - id.getLayoutBounds().getMinY());
			id.setText("ID: " + Integer.toString(players[x].getId()));

			playersScreenData.add(id);
			playersScreenData.add(new Text( (x == 1) ? 50 : SCREEN_WIDTH/1.25, 250, "VP: " + Integer.toString(players[x].getVp())));
			playersScreenData.add(new Text( (x == 1) ? 50 : SCREEN_WIDTH/1.25, 300, "ITEMS: " + players[x].getItems().toString()));
			playersScreenData.add(new Text( (x == 1) ? 50 : SCREEN_WIDTH/1.25, 700, "CARDS: " + players[x].getCards().toString()));
		}

		group = new Group();

		// turn = new Turn();
		// handle();

		Board board = Board.newBoardWithTiles();

		drawBoard(board);

		Scene scene = new Scene(group, SCREEN_WIDTH, SCREEN_HEIGHT);
//		scene.setOnKeyPressed(event -> handleKeyPressed(event));
//		scene.setOnKeyReleased(event -> handleKeyReleased(event));
//		scene.setOnMousePressed(event -> handleMousePressed(event));
//		scene.setOnMouseReleased(event -> handleMouseReleased(event));
		scene.setFill(Color.WHITE);

		// BackgroundImage = bkgImage = new BackgroundImage();

		stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
//		Image test = new Image(getClass().getResourceAsStream("icon.png"), 1000,0, false, false);
//		ImageView imageView = new ImageView(test); 
//		group.getChildren().add(imageView);

		// Set up the stage
		stage.setFullScreen(fullscreen);
		stage.setTitle("Main");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * List<Shape> shapes = new ArrayList<Shape>();
	 * 
	 * @param board
	 */
	private void drawBoard(Board board) {
		List<Node> children = group.getChildren();
		children.clear();

		List<Node> tileShapes = board.buildTileShapes();

		children.addAll(playersScreenData);
		children.addAll(tileShapes);
		children.add(resetButton);
		children.add(exitButton);
		children.add(rollButton);
		children.add(turnText);
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void handleResetButtonClicked(ActionEvent event) {
		System.out.println("Reset event = " + event);
		board = Board.newBoardWithTiles();
		drawBoard(board);
	}

	private void handleExitButtonClicked(ActionEvent event) {
		System.out.println("Exit event = " + event);
		System.exit(0);
	}

	private void handleRollButtonClicked(ActionEvent event) {
		System.out.println("Roll event = " + event);
		logic.rollDice();
		turnText.setText("Roll: " + logic.roll);
	}

	/*
	 * Method that handles key input from the user
	 */
//	private void handleKeyPressed(KeyEvent event) {
//		KeyCode code = event.getCode();
//
//		if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
//			// board = new Board();
//		}
//
//		if (code == KeyCode.F11) {
//			fullscreen = true;
//		}
//	}

	/*
	 * Makes the paddle stop moving when the user release the directional key
	 */
//	private void handleKeyReleased(KeyEvent event) {
//		KeyCode code = event.getCode();
//
//		if (code == KeyCode.SPACE || code == KeyCode.ENTER) {
//			// board = new Board();
//		}
//
////		if (code == KeyCode.F11) {
////			fullscreen = false;
////		}
//	}
//
//	private void handleMousePressed(MouseEvent event) {
//		MouseButton code = event.getButton();
//
//		if (code == MouseButton.PRIMARY) {
//
//		}
//	}
//
//	private void handleMouseReleased(MouseEvent event) {
//		MouseButton code = event.getButton();
//
//		if (code == MouseButton.PRIMARY) {
//
//		}
//	}

}