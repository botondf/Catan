package catan;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.*;
import java.util.List;
import java.util.ArrayList;
import javafx.stage.Screen;

public class Main extends Application {
	private static Screen screen = Screen.getPrimary();
	private static Rectangle2D bounds = screen.getVisualBounds();

	public static final double SCREEN_WIDTH = 1920;//bounds.getWidth();
	public static final double SCREEN_HEIGHT = 1080;//bounds.getHeight();
	
	final double FONT_SIZE = 20;
	final Color backgroundColor = Color.web("2f2f2f"); // 23272A // 2C2F33 //2f2f2f //313238
	final Color contrastColor = Color.WHITE;
	
	private Group group;
	private boolean fullscreen = true;

	public Board board;
	private Logic logic;
	private Text turnText;
	private Player[] players = new Player[NUM_PLAYERS];
	public static int NUM_PLAYERS = 2;

	@Override
	public void start(Stage stage) throws Exception {
		stage.setWidth(SCREEN_WIDTH);//bounds.getWidth());
		stage.setHeight(SCREEN_HEIGHT);//bounds.getHeight());

		logic = new Logic();

		for (int x = 0; x < NUM_PLAYERS; x++) {
			players[x] = new Player(x + 1);
			//players[x].getBuildings().add(new Building(BuildingType.CITY, players[x], new Place(PlaceType.INTERSECTION)));
			//players[x].addItem(new Item(ItemType.BRICK));
			players[x].checkVP();
		}

		group = new Group();

		Board board = Board.newBoardWithTiles();

		drawBoard(board);

		Scene scene = new Scene(group, SCREEN_WIDTH, SCREEN_HEIGHT);
		scene.setFill(backgroundColor);

		stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
		
		// Set up the stage
		//stage.setFullScreen(fullscreen);
		stage.setTitle("Settlers of Catan");
		stage.setScene(scene);
		stage.show();
	}

	/**
	 *  'Draws' (re-adds to group) the entire game board on updates
	 * @param board
	 */
	private void drawBoard(Board board) {
		List<Node> children = group.getChildren();
		children.clear();
		
		List<Node> tileShapes = board.buildTileShapes();
		List<Node> placeShapes = board.buildPlaceShapes();
		
		children.addAll(background());
		children.addAll(ui());
		children.addAll(playerUi());
		children.addAll(tileShapes);
		children.addAll(placeShapes);
		
//		Image pic = new Image(getClass().getResourceAsStream("icon.png"));
//		ImageView picView = new ImageView(pic);
//		picView.setX(1050);
//		picView.setY(350);
		
//		children.add(picView);
	}
	
	private List<Node> mainMenu() {
		List<Node> mainMenu = new ArrayList<Node>();
		
		Text title = new Text();
		title.setText("Settlers of Catan");
		title.setX(SCREEN_WIDTH/2);
		title.setY(SCREEN_HEIGHT/2);
		title.setFont();
		
		mainMenu.add(title);
		
		return mainMenu;
	}
	
	private List<Node> ui() {
		List<Node> ui = new ArrayList<Node>();
		
		Button resetButton = new Button();
		resetButton.setText("Reset");
		resetButton.setLayoutX(5);
		resetButton.setLayoutY(5);
		resetButton.setOnAction(this::handleResetButtonClicked);
		ui.add(resetButton);

		Button exitButton = new Button("Exit");
		exitButton.setLayoutX(60);
		exitButton.setLayoutY(5);
		exitButton.setOnAction(this::handleExitButtonClicked);
		ui.add(exitButton);

		Button rollButton = new Button("Roll");
		rollButton.setLayoutX(110);
		rollButton.setLayoutY(5);
		rollButton.setOnAction(this::handleRollButtonClicked);
		ui.add(rollButton);
		
		turnText = new Text();
		turnText.setText("Roll");
		turnText.setX(SCREEN_WIDTH / 2);
		turnText.setY(20);
		turnText.setFill(contrastColor);
		ui.add(turnText);
		
		return ui;
	}
	
	private List<Node> background() {
		List<Node> background = new ArrayList<Node>();
		
		Circle boardCircle = new Circle();
		boardCircle.setFill(Color.SKYBLUE);
		boardCircle.setRadius(SCREEN_WIDTH / 3.75);
		boardCircle.setCenterX(SCREEN_WIDTH / 2);
		boardCircle.setCenterY(SCREEN_HEIGHT / 2);
		background.add(boardCircle);
		
		Circle boardCircleBlank = new Circle();
		boardCircleBlank.setFill(contrastColor);
		boardCircleBlank.setRadius(SCREEN_WIDTH / 5.1); //4.9 (1080p)  5.1 //5.45 * .2
		boardCircleBlank.setCenterX(SCREEN_WIDTH / 2);
		boardCircleBlank.setCenterY(SCREEN_HEIGHT / 2);
		background.add(boardCircleBlank);
		
		return background;
	}
	
	private List<Node> playerUi() {
		List<Node> playersUi = new ArrayList<Node>();
		
		for (int x = 0; x < NUM_PLAYERS; x++) {
			Text id = new Text();
			id.setX((players[x].getId() == 1) ? 50 : SCREEN_WIDTH/1.25);
			id.setY(50);
			id.setText("ID: " + Integer.toString(players[x].getId()));
			id.setFill(contrastColor);
			
			Text vp = new Text( (x == 1) ? 50 : SCREEN_WIDTH/1.25, 100, "VP: " + Integer.toString(players[x].getVp()));
			vp.setFill(contrastColor);
			
			Text items = new Text( (x == 1) ? 50 : SCREEN_WIDTH/1.25, 150, "ITEMS: " + players[x].getItems().toString());
			items.setFill(contrastColor);
			items.setWrappingWidth(SCREEN_WIDTH/1.25);
			
			Text cards = new Text( (x == 1) ? 50 : SCREEN_WIDTH/1.25, 700, "CARDS: " + players[x].getCards().toString());
			cards.setFill(contrastColor);

			playersUi.add(id);
			playersUi.add(vp);
			playersUi.add(items);
			playersUi.add(cards);
			
		}
		return playersUi;
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
}