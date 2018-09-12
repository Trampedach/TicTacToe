package dev.ticTacToeGame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class GameBoard {

	Group root;
	Scene board;

	public GameBoard(Group root, Scene board) {

		this.root = root;
		this.board = board;
	}

	public Scene drawBoard() {

		Rectangle rectangle = new Rectangle();
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
		return (board);
	}

}
