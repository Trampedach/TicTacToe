package dev.ticTacToeGame;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Game extends Application {

	public static int i = 1;

	public static boolean closeGame   = false;
	public static int tilesUsed       = 0;

	Button button = new Button();

	// Creating a Group object
	Group root = new Group();
	// Creating a scene object
	Scene menuScene;
	Scene boardScene = new Scene(root, 620, 620, Color.WHITE);
	GameBoard board;

	public static char[][] grid = new char[3][3];

	@Override
	public void start(Stage stage) throws Exception {

		GameMenu menu = new GameMenu(new Group());
		board = new GameBoard(root, boardScene);

		menuScene = menu.drawLine();
		drawMenu(menu.root, menuScene, stage);

		button.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
				menuScene = menu.drawLine();
				drawMenu(menu.root, menuScene, stage);
			}
		});

		menu.startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
				// Setting title to the Stage
				stage.setTitle("Tic Tac Toe");

				if (closeGame) {
					resetGrid();
					tilesUsed = 0;
					root.getChildren().remove(button);
					closeGame = false;
				}

				boardScene = board.drawBoard();

				root = board.root;
				stage.setScene(boardScene);
				Image image = new Image("gfx/cross.png");
				boardScene.setCursor(new ImageCursor(image, image.getWidth() / 2, image.getHeight() / 2));
				i = 1;

				// Displaying the contents of the stage
				stage.show();

			}
		});
		
		boardScene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				handleMouseClick(mouseEvent);
			}
		});
		
		menu.exitButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				stage.close();
			}
		});

	}

	public void drawMenu(Group root, Scene menu, Stage stage) {
		stage.setTitle("Tic Tac Toe");
		stage.setResizable(false);
//		stage.initStyle(StageStyle.UNDECORATED);
		stage.getIcons().add(new Image("gfx/TicTacToe.png"));
		stage.setScene(menu);
		stage.show();
	}

	private boolean available(double sceneX, double sceneY) {

		int x = 0;
		int y = 0;

		if ((sceneX < 200 && sceneY < 200) && (sceneX > 0 && sceneY > 0)) {
			x = 0;
			y = 0;
		}

		if ((sceneX < 400 && sceneY < 200) && (sceneX > 200 && sceneY > 0)) {
			x = 0;
			y = 1;
		}

		if ((sceneX < 600 && sceneY < 200) && (sceneX > 400 && sceneY > 0)) {
			x = 0;
			y = 2;
		}

		if ((sceneX < 200 && sceneY < 400) && (sceneX > 0 && sceneY > 200)) {
			x = 1;
			y = 0;
		}

		if ((sceneX < 400 && sceneY < 400) && (sceneX > 200 && sceneY > 200)) {
			x = 1;
			y = 1;
		}

		if ((sceneX < 600 && sceneY < 400) && (sceneX > 400 && sceneY > 200)) {
			x = 1;
			y = 2;
		}

		if ((sceneX < 200 && sceneY < 600) && (sceneX > 0 && sceneY > 400)) {
			x = 2;
			y = 0;
		}

		if ((sceneX < 400 && sceneY < 600) && (sceneX > 200 && sceneY > 400)) {
			x = 2;
			y = 1;
		}

		if ((sceneX < 600 && sceneY < 600) && (sceneX > 400 && sceneY > 400)) {
			x = 2;
			y = 2;
		}

		if (grid[x][y] != ' ')
			return false;
		else
			return true;
	}

	private void handleMouseClick(MouseEvent t) {

		if (closeGame)
			return;

		if ((t.getSceneX() < 600 && t.getSceneY() < 600) && (t.getSceneX() > 0 && t.getSceneY() > 0)) {

			if (available(t.getSceneX(), t.getSceneY())) {
				if (i == 1) {
					Image image = new Image("gfx/circle.png");
					boardScene.setCursor(new ImageCursor(image, image.getWidth() / 2, image.getHeight() / 2));
					i--;
				} else {
					Image image = new Image("gfx/cross.png");
					boardScene.setCursor(new ImageCursor(image, image.getWidth() / 2, image.getHeight() / 2));
					i++;
				}
			}
		}

		if ((t.getSceneX() <= 200 && t.getSceneY() <= 200) && (t.getSceneX() > 0 && t.getSceneY() > 0)
				&& grid[0][0] == ' ') {
			if (i == 0) {
				/* cross 1,1 */
				root.getChildren().add(drawX(20, 20, 200, 200));
				root.getChildren().add(drawX(200, 20, 20, 200));
				grid[0][0] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 1,1 */
				root.getChildren().add(drawO(110, 110, 90));
				grid[0][0] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 400 && t.getSceneY() < 200) && (t.getSceneX() > 200 && t.getSceneY() > 0)
				&& grid[0][1] == ' ') {
			if (i == 0) {
				/* cross 1,2 */
				root.getChildren().add(drawX(220, 20, 400, 200));
				root.getChildren().add(drawX(400, 20, 220, 200));
				grid[0][1] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 1,2 */
				root.getChildren().add(drawO(310, 110, 90));
				grid[0][1] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 600 && t.getSceneY() < 200) && (t.getSceneX() > 400 && t.getSceneY() > 0)
				&& grid[0][2] == ' ') {
			if (i == 0) {
				/* cross 1,3 */
				root.getChildren().add(drawX(420, 20, 600, 200));
				root.getChildren().add(drawX(600, 20, 420, 200));
				grid[0][2] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 1,3 */
				root.getChildren().add(drawO(510, 110, 90));
				grid[0][2] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 200 && t.getSceneY() < 400) && (t.getSceneX() > 0 && t.getSceneY() > 200)
				&& grid[1][0] == ' ') {
			if (i == 0) {
				/* cross 2,1 */
				root.getChildren().add(drawX(20, 220, 200, 400));
				root.getChildren().add(drawX(200, 220, 20, 400));
				grid[1][0] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 2,1 */
				root.getChildren().add(drawO(110, 310, 90));
				grid[1][0] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 400 && t.getSceneY() < 400) && (t.getSceneX() > 200 && t.getSceneY() > 200)
				&& grid[1][1] == ' ') {
			if (i == 0) {
				/* cross 2,2 */
				root.getChildren().add(drawX(220, 220, 400, 400));
				root.getChildren().add(drawX(400, 220, 220, 400));
				grid[1][1] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 2,2 */
				root.getChildren().add(drawO(310, 310, 90));
				grid[1][1] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 600 && t.getSceneY() < 400) && (t.getSceneX() > 400 && t.getSceneY() > 200)
				&& grid[1][2] == ' ') {
			if (i == 0) {
				/* cross 2,2 */
				root.getChildren().add(drawX(420, 220, 600, 400));
				root.getChildren().add(drawX(600, 220, 420, 400));
				grid[1][2] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 2,3 */
				root.getChildren().add(drawO(510, 310, 90));
				grid[1][2] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 200 && t.getSceneY() < 600) && (t.getSceneX() > 0 && t.getSceneY() > 400)
				&& grid[2][0] == ' ') {
			if (i == 0) {
				/* cross 3,1 */
				root.getChildren().add(drawX(20, 420, 200, 600));
				root.getChildren().add(drawX(200, 420, 20, 600));
				grid[2][0] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 3,1 */
				root.getChildren().add(drawO(110, 510, 90));
				grid[2][0] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 400 && t.getSceneY() < 600) && (t.getSceneX() > 200 && t.getSceneY() > 400)
				&& grid[2][1] == ' ') {
			if (i == 0) {
				/* cross 3,2 */
				root.getChildren().add(drawX(220, 420, 400, 600));
				root.getChildren().add(drawX(400, 420, 220, 600));
				grid[2][1] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 3,2 */
				root.getChildren().add(drawO(310, 510, 90));
				grid[2][1] = 'O';
				tilesUsed += 1;
			}
		}

		if ((t.getSceneX() < 600 && t.getSceneY() < 600) && (t.getSceneX() > 400 && t.getSceneY() > 400)
				&& grid[2][2] == ' ') {
			if (i == 0) {
				/* cross 3,3 */
				root.getChildren().add(drawX(420, 420, 600, 600));
				root.getChildren().add(drawX(600, 420, 420, 600));
				grid[2][2] = 'X';
				tilesUsed += 1;
			} else {
				/* circle 3,3 */
				root.getChildren().add(drawO(510, 510, 90));
				grid[2][2] = 'O';
				tilesUsed += 1;
			}
		}

		if (!closeGame)
			winner('X');
		if (!closeGame)
			winner('O');
	}

	public void showWinner(char win) {

		closeGame = true;
		button.setLayoutX(210);
		button.setLayoutY(250);
		button.setPrefWidth(200);
		button.setPrefHeight(50);
		button.setFont(Font.font("Verdana", 20));
		root.getChildren().remove(button);
		if (win == 'N')
			button.setText("No winner!");
		else
			button.setText(win + " is the winner!");
		root.getChildren().add(button);
	}

	public void winner(char piece) {

		if ((grid[0][0] == piece) & (grid[0][1] == piece) & (grid[0][2] == piece)) {
			Line line = new Line(10, 110, 610, 110);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if ((grid[1][0] == piece) & (grid[1][1] == piece) & (grid[1][2] == piece)) {
			Line line = new Line(10, 310, 610, 310);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if ((grid[2][0] == piece) & (grid[2][1] == piece) & (grid[2][2] == piece)) {
			Line line = new Line(10, 510, 610, 510);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if ((grid[0][0] == piece) & (grid[1][0] == piece) & (grid[2][0] == piece)) {
			Line line = new Line(110, 10, 110, 610);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if ((grid[0][1] == piece) & (grid[1][1] == piece) & (grid[2][1] == piece)) {
			Line line = new Line(310, 10, 310, 610);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if ((grid[0][2] == piece) & (grid[1][2] == piece) & (grid[2][2] == piece)) {
			Line line = new Line(510, 10, 510, 610);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if ((grid[0][0] == piece) & (grid[1][1] == piece) & (grid[2][2] == piece)) {
			Line line = new Line(20, 20, 600, 600);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if ((grid[2][0] == piece) & (grid[1][1] == piece) & (grid[0][2] == piece)) {
			Line line = new Line(600, 20, 20, 600);
			line.setStroke(Color.RED);
			line.setStrokeWidth(5);
			root.getChildren().add(line);
			showWinner(piece);
		}
		else
		if (tilesUsed >= 9 & !closeGame & piece != 'X') 
			showWinner('N');
			

	}

	public Line drawX(int a, int b, int c, int d) {

		Line cross1 = new Line(a, b, c, d);
		cross1.setStroke(Color.BLACK);
		cross1.setStrokeWidth(10);
		return cross1;
	}

	public Circle drawO(int a, int b, int c) {

		Circle circle = new Circle(a, b, c);
		circle.setFill(null);
		circle.setStrokeWidth(10);
		circle.setStroke(Color.BLACK);
		return circle;
	}

	public void drawBoard() {

		// Setting the properties of the rectangle
		Rectangle rectangle = new Rectangle();
		rectangle.setX(10);
		rectangle.setY(10);
		rectangle.setWidth(600);
		rectangle.setHeight(600);
		rectangle.setStrokeWidth(10);
		rectangle.setStroke(Color.BLACK);
		rectangle.setFill(Color.WHITE);
		Line line1 = new Line(210, 10, 210, 610);
		line1.setStroke(Color.BLACK);
		line1.setStrokeWidth(10);
		Line line2 = new Line(410, 10, 410, 610);
		line2.setStroke(Color.BLACK);
		line2.setStrokeWidth(10);
		Line line3 = new Line(10, 210, 610, 210);
		line3.setStroke(Color.BLACK);
		line3.setStrokeWidth(10);
		Line line4 = new Line(10, 410, 610, 410);
		line4.setStroke(Color.BLACK);
		line4.setStrokeWidth(10);

		root.getChildren().addAll(rectangle, line1, line2, line3, line4);
	}

	public static void resetGrid() {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = ' ';
			}
		}
	}

	public static void main(String args[]) {

		resetGrid();
		launch(args);
	}

}
