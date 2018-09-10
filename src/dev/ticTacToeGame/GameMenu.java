package dev.ticTacToeGame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class GameMenu {
	
	Group root;
	Scene menu;
	
	
	public GameMenu(Group root) {
		
		this.root = root;
	}
	
	public Scene drawLine() {
		root = new Group();
		menu = new Scene(root, 300, 300, Color.YELLOW);
		Line line1 = new Line(210, 10, 210, 610);
		line1.setStroke(Color.BLACK);
		line1.setStrokeWidth(10);
		root.getChildren().addAll(line1);
		return(menu);
	}

}
