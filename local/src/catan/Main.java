package catan;

import javafx.application.Application;
import javafx.scene.control.ColorPicker;
import javafx.geometry.VPos;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
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
	private final Color backgroundColor = Color.web("2f2f2f"); // 23272A // 2C2F33 //2f2f2f //313238
	private final Color contrastColor = Color.WHITE;
	
	private Group window = new Group();
	private Scene scene;

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
		
		//window.getChildren().addAll(mainMenu(stage));

		logic = new Logic();

		for (int x = 0; x < NUM_PLAYERS; x++) {
			players[x] = new Player(x + 1);
			//players[x].getBuildings().add(new Building(BuildingType.CITY, players[x], new Place(PlaceType.INTERSECTION)));
			//players[x].addItem(new Item(ItemType.BRICK));
			players[x].checkVP();
		}
		
//		board = Board.newBoardWithTiles();
//		drawBoard();
		window.getChildren().addAll(mainMenu());
		scene = new Scene(window, SCREEN_WIDTH, SCREEN_HEIGHT);
		scene.setFill(backgroundColor);
		
		stage.getIcons().add(new Image(getClass().getResourceAsStream("icon.png")));
		
		// Set up the stage
		stage.setFullScreen(fullscreen);
		stage.setTitle("Settlers of Catan");
		stage.setScene(scene);
		stage.show();
		
	}
	private void redrawBoard() {
//		List<Node> children = window.getChildren();
//		children.clear();
		drawBoard();
	}

	/**
	 *  'Draws' (re-adds to group) the entire game board on updates
	 * @param board
	 */
	private void drawBoard() {
		List<Node> children = window.getChildren();
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
		title.setX(SCREEN_WIDTH/2 - title.getBoundsInLocal().getWidth()*2);
		title.setY(SCREEN_HEIGHT/2);
		title.setTextOrigin(VPos.CENTER);
		title.setTextAlignment(TextAlignment.CENTER);
		title.setFont(new Font(65));
		title.setFill(contrastColor);
		mainMenu.add(title);
		
		Button tutorialButton = new Button();
		tutorialButton.setText("Tutorial");
		tutorialButton.setLayoutX(SCREEN_WIDTH/2 - tutorialButton.getBoundsInLocal().getWidth()*2);
		tutorialButton.setLayoutY(SCREEN_HEIGHT/2 + title.getBoundsInLocal().getHeight());
		tutorialButton.setOnAction((event) -> changeGroup());
		mainMenu.add(tutorialButton);
		
		Button playButton = new Button();
		playButton.setText("Play");
		playButton.setLayoutX(SCREEN_WIDTH/2);
		playButton.setLayoutY(SCREEN_HEIGHT/2+50);
		playButton.setOnAction(this::handlePlayButtonClicked);
		mainMenu.add(playButton);
		
		Button exitButton = new Button("Exit");
		exitButton.setLayoutX(SCREEN_WIDTH/2);
		exitButton.setLayoutY(SCREEN_HEIGHT/2 + 125);
		exitButton.setOnAction(this::handleExitButtonClicked);
		mainMenu.add(exitButton);
		
		MenuButton playerColorPicker = new MenuButton();
		playerColorPicker.setText("Player Colour Picker");
		playerColorPicker.setLayoutX(SCREEN_WIDTH/2);
		playerColorPicker.setLayoutY(SCREEN_HEIGHT/2 + 165);
		
		boolean player1ColorVis = false;
		ColorPicker player1ColorPicker = new ColorPicker();
		player1ColorPicker.setLayoutX(SCREEN_WIDTH/2-175);
		player1ColorPicker.setLayoutY(SCREEN_HEIGHT/2 + 165);
		player1ColorPicker.setVisible(player1ColorVis);
		mainMenu.add(player1ColorPicker);
		
		boolean player2ColorVis = false;
		ColorPicker player2ColorPicker = new ColorPicker();
		player2ColorPicker.setLayoutX(SCREEN_WIDTH/2+200);
		player2ColorPicker.setLayoutY(SCREEN_HEIGHT/2 + 165);
		player2ColorPicker.setVisible(player2ColorVis);
		mainMenu.add(player2ColorPicker);
	
		
		MenuItem player1Color = new MenuItem();
		MenuItem player2Color = new MenuItem();
		player1Color.setOnAction(event -> player1ColorPicker.setVisible((player1ColorVis) ? false : true));
		player2Color.setOnAction(event -> player2ColorPicker.setVisible((player2ColorVis) ? false : true));
		player1Color.setText("Player 1 Color Picker");
		player2Color.setText("Player 2 Color Picker");

		playerColorPicker.getItems().addAll(player1Color, player2Color);
		mainMenu.add(playerColorPicker);
		
		return mainMenu;
	}
	
	private void changeGroup() {
		window.getChildren().clear();
		window.getChildren().addAll(tutorial());
		}

	private List<Node> tutorial() {
		List<Node> tutorial = new ArrayList<Node>();
		
//		Text text1 = new Text();
//		text1.setText("12312");
//		text1.setX(SCREEN_WIDTH/2 - text1.getBoundsInLocal().getWidth()*2);
//		text1.setY(SCREEN_HEIGHT/2);
//		text1.setTextOrigin(VPos.CENTER);
//		text1.setTextAlignment(TextAlignment.CENTER);
//		text1.setFont(new Font(FONT_SIZE));
//		text1.setFill(contrastColor);
//		tutorial.add(text1);
		
		Text tutorialText = new Text();
		tutorialText.setText("Settlers come from far away to the prosperous island of Catan to build their new civilization.\n"
				+ "The goal of the game is to be the first settler to have the greater settlement by having 10+ Victory Points (VPs).\n"
				+ "Two players strategically place their first buildings on the randomized board.\n"
				+ "The rich land of Catan offers the settlers with untapped resources: .\n"
				+ "Brick from the Hills, Ore from the Mountains, Wool from the Pastures,\n"
				+ "Grain from the Fields, and Lumber from the Forests.\n"
				+ "To gain earn VPs and resources players must build settlements, villages or cities, on a tile.\n"
				+ "These settlements can only be placed on the red intersections and after 2 roads have been built.\n"
				+ "Roads must go on the sides of the tiles, the white path markers.\n"
				+ "Once a settlement is built on a tile, the player who owns the building will earn that resource\n"
				+ "when the tile's value, displayed on beige markers, is rolled.\n"
				+ "");
		tutorialText.setX(50);
		tutorialText.setY(50);
		tutorialText.setTextOrigin(VPos.TOP);
		tutorialText.setTextAlignment(TextAlignment.LEFT);
		tutorialText.setFont(new Font(FONT_SIZE));
		tutorialText.setFill(contrastColor);
		tutorial.add(tutorialText);
		
		Button playButton = new Button();
		playButton.setText("Play");
		playButton.setLayoutX(SCREEN_WIDTH/2);
		playButton.setLayoutY(SCREEN_HEIGHT/2);
		playButton.setOnAction(this::handlePlayButtonClickedUI);
		tutorial.add(playButton);
		
		Button exitButton = new Button("Exit");
		exitButton.setLayoutX(SCREEN_WIDTH/2);
		exitButton.setLayoutY(SCREEN_HEIGHT/2 + 50);
		exitButton.setOnAction(this::handleExitButtonClicked);
		tutorial.add(exitButton);
		
		Button backButton = new Button("Back");
		backButton.setLayoutX(SCREEN_WIDTH/2);
		backButton.setLayoutY(SCREEN_HEIGHT/2 + 100);
		backButton.setOnAction(event -> { window.getChildren().clear(); window.getChildren().addAll(mainMenu()); });
		tutorial.add(backButton);

		return tutorial;
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
		exitButton.setLayoutX(65);
		exitButton.setLayoutY(5);
		exitButton.setOnAction(this::handleExitButtonClicked);
		ui.add(exitButton);

		Button rollButton = new Button("Roll");
		rollButton.setLayoutX(115);
		rollButton.setLayoutY(5);
		rollButton.setOnAction(this::handleRollButtonClicked);
		ui.add(rollButton);
		
		turnText = new Text();
		turnText.setText("Roll");
		turnText.setX(SCREEN_WIDTH / 2);
		turnText.setY(20);
		turnText.setFill(contrastColor);
		ui.add(turnText);
		
		Button tutorialButton = new Button();
		tutorialButton.setText("Tutorial");
		tutorialButton.setLayoutX(175);
		tutorialButton.setLayoutY(5);
		tutorialButton.setOnAction((event) -> changeGroup());
		ui.add(tutorialButton);
		
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
	
	private void handlePlayButtonClickedUI(ActionEvent event) {
		System.out.println("Play Uievent = " + event);
		drawBoard();
	}
	
	private void handlePlayButtonClicked(ActionEvent event) {
		System.out.println("Play event = " + event);
		window.getChildren().clear();
		board = Board.newBoardWithTiles();
		drawBoard();
	}

	private void handleResetButtonClicked(ActionEvent event) {
		System.out.println("Reset event = " + event);
		board = Board.newBoardWithTiles();
		drawBoard();
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