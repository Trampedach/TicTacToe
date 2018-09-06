package dev.ticTacToeGame;

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

	@Override
	public void start(Stage stage) throws Exception {

		// Drawing a Rectangle
//	      Rectangle rectangle = new Rectangle();  
//	      
//	      //Setting the properties of the rectangle 
//	      rectangle.setX(10); 
//	      rectangle.setY(10); 
//	      rectangle.setWidth(600); 
//	      rectangle.setHeight(600);
//	      rectangle.setStrokeWidth(10);
//	      rectangle.setStroke(Color.BLACK);
//	      rectangle.setFill(Color.WHITE);

		drawBoard();

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

		// Setting title to the Stage
		stage.setTitle("Tic Tac Toe");

		// Adding scene to the stage
		stage.setScene(scene);

		// Displaying the contents of the stage
		stage.show();

		scene.setOnMouseClicked(e -> handleMouseClick());

	}
	

	private void handleMouseClick() {

		MouseEvent t = new MouseEvent(scene, null, null, 0, 0, 0, 0, null, 0, false, false, false, false, false, false, false, false, false, false, null);
		
		if (i == 1) {
			Image image = new Image("gfx/circle.png");
			scene.setCursor(new ImageCursor(image, image.getWidth() / 2, image.getHeight() / 2));
			i--;
		} else {
			Image image = new Image("gfx/cross.png");
			scene.setCursor(new ImageCursor(image, image.getWidth() / 2, image.getHeight() / 2));
			i++;
		}

		if (i == 0) {
			if ((t.getSceneX() <= 200 && t.getSceneY() <= 200) && (t.getSceneX() > 0 && t.getSceneY() > 0)) {
				System.out.println(t.getSceneX());
				/* cross 1,1 */
				root.getChildren().add(drawX(20, 20, 200, 200));
				root.getChildren().add(drawX(200, 20, 20, 200));
			}

			if ((t.getSceneX() < 400 && t.getSceneY() < 200) && (t.getSceneX() > 200 && t.getSceneY() > 0)) {
				System.out.println(t.getSceneX());
				/* cross 1,2 */
				root.getChildren().add(drawX(220, 20, 400, 200));
				root.getChildren().add(drawX(400, 20, 220, 200));
			}
		} else {
			if ((t.getSceneX() <= 200 && t.getSceneY() <= 200) && (t.getSceneX() > 0 && t.getSceneY() > 0)) {
				System.out.println(t.getSceneX());
				/* cross 1,1 */
				Circle circle = new Circle(10,10, 10);
				root.getChildren().add(circle);
			}

			if ((t.getSceneX() < 400 && t.getSceneY() < 200) && (t.getSceneX() > 200 && t.getSceneY() > 0)) {
				System.out.println(t.getSceneX());
				/* cross 1,2 */
				Circle circle = new Circle(30,30,30);
				root.getChildren().add(circle);
			}
		}
	}

	public Line drawX(int a, int b, int c, int d) {

		Line cross1 = new Line(a, b, c, d);
		cross1.setStroke(Color.BLACK);
		cross1.setStrokeWidth(10);
		return cross1;
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

	}

	public static void main(String args[]) {
		launch(args);
	}

}
