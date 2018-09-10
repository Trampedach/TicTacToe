package dev.ticTacToeGame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class GameMenu {
	
	
	Group root;
	Scene menu;
	
	Button startButton = new Button();
	Button exitButton = new Button();
	
	public GameMenu(Group root) {
		
		this.root = root;
	}
	
	public Scene drawLine() {
		root = new Group();
		menu = new Scene(root, 600, 600, Color.BLACK);

		startButton.setLayoutX(100);
		startButton.setLayoutY(200);
		startButton.setPrefWidth(400);
		startButton.setPrefHeight(50);
		startButton.setFont(Font.font ("Verdana", 20));
		startButton.setText("Start Game");
		
		exitButton.setLayoutX(100);
		exitButton.setLayoutY(300);
		exitButton.setPrefWidth(400);
		exitButton.setPrefHeight(50);
		exitButton.setFont(Font.font ("Verdana", 20));
		exitButton.setText("Exit Game");
		
		root.getChildren().addAll(startButton,exitButton);
		return(menu);
	}

}
