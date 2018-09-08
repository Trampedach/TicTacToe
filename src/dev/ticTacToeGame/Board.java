package dev.ticTacToeGame;

import java.lang.reflect.Array;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.effect.Light.Point;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Board extends Application {

	public static int i = 1;

	Rectangle rectangle = new Rectangle();
	// Creating a Group object
	Group root = new Group();
	// Creating a scene object
	Scene scene = new Scene(root, 620, 620, Color.WHITE);

	public static char[][] grid = new char[3][3];

	@Override
	public void start(Stage stage) throws Exception {

		drawBoard();

		// Setting title to the Stage
		stage.setTitle("Tic Tac Toe");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();

		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				handleMouseClick(mouseEvent);
			}
		});

	}

	private void handleMouseClick(MouseEvent t) {

		if (i == 1) {
			Image image = new Image("gfx/circle.png");
			scene.setCursor(new ImageCursor(image, image.getWidth() / 2, image.getHeight() / 2));
			i--;
		} else {
			Image image = new Image("gfx/cross.png");
			scene.setCursor(new ImageCursor(image, image.getWidth() / 2, image.getHeight() / 2));
			i++;
		}

		if ((t.getSceneX() <= 200 && t.getSceneY() <= 200) && (t.getSceneX() > 0 && t.getSceneY() > 0)
				&& grid[0][0] == ' ') {
			System.out.println(t.getSceneX());
			if (i == 0) {
				/* cross 1,1 */
				root.getChildren().add(drawX(20, 20, 200, 200));
				root.getChildren().add(drawX(200, 20, 20, 200));
				grid[0][0] = 'X';
			} else {
				/* circle 1,1 */
				root.getChildren().add(drawO(110, 110, 90));
				grid[0][0] = 'O';
			}
		}

		if ((t.getSceneX() < 400 && t.getSceneY() < 200) && (t.getSceneX() > 200 && t.getSceneY() > 0)
				&& grid[0][1] == ' ') {
			System.out.println(t.getSceneX());
			if (i == 0) {
				/* cross 1,2 */
				root.getChildren().add(drawX(220, 20, 400, 200));
				root.getChildren().add(drawX(400, 20, 220, 200));
				grid[0][1] = 'X';
			} else {
				/* circle 1,2 */
				root.getChildren().add(drawO(310, 110, 90));
				grid[0][1] = 'O';
			}
		}
		
		if ((t.getSceneX() < 600 && t.getSceneY() < 200) && (t.getSceneX() > 200 && t.getSceneY() > 0)
				&& grid[0][2] == ' ') {
			System.out.println(t.getSceneX());
			if (i == 0) {
				/* cross 1,3 */
				root.getChildren().add(drawX(420, 20, 600, 200));
				root.getChildren().add(drawX(600, 20, 420, 200));
				grid[0][2] = 'X';
			} else {
				/* circle 1,3 */
				root.getChildren().add(drawO(510, 110, 90));
				grid[0][2] = 'O';
			}
		}
		
		if ((t.getSceneX() < 200 && t.getSceneY() < 400) && (t.getSceneX() > 0 && t.getSceneY() > 200)
				&& grid[1][0] == ' ') {
			System.out.println(t.getSceneX());
			if (i == 0) {
				/* cross 2,1 */
				root.getChildren().add(drawX(20, 220, 200, 400));
				root.getChildren().add(drawX(200, 220, 20, 400));
				grid[1][0] = 'X';
			} else {
				/* circle 2,1 */
				root.getChildren().add(drawO(110, 310, 90));
				grid[1][0] = 'O';
			}
		}
		
		if ((t.getSceneX() < 400 && t.getSceneY() < 400) && (t.getSceneX() > 0 && t.getSceneY() > 200)
				&& grid[1][1] == ' ') {
			System.out.println(t.getSceneX());
			if (i == 0) {
				/* cross 2,2 */
				root.getChildren().add(drawX(220, 220, 400, 400));
				root.getChildren().add(drawX(400, 220, 220, 400));
				grid[1][1] = 'X';
			} else {
				/* circle 2,2 */
				root.getChildren().add(drawO(310, 310, 90));
				grid[1][1] = 'O';
			}
		}
		
		winner();
	}

	public void winner() {
		
		if (grid[0][0] == 'X' && grid[0][1] == 'X' && grid[0][2] == 'X') {
			System.out.println("X winner!!");
			Line line = new Line(10, 110, 610, 110);
			line.setStroke(Color.RED);
			line.setStrokeWidth(10);

			root.getChildren().add(line);
		}
		
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

	public static void main(String args[]) {

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = ' ';
			}
		}
		Game game = new Game();
		launch(args);
	}

}
