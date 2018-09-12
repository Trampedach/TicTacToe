package dev.ticTacToeGame;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
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
		if (menu == null) {
			menu = new Scene(root, 600, 600, Color.BLACK);

			startButton.setLayoutX(100);
			startButton.setLayoutY(400);
			startButton.setPrefWidth(400);
			startButton.setPrefHeight(50);
			startButton.setFont(Font.font("Verdana", 20));
			startButton.setText("Start Game");

			exitButton.setLayoutX(100);
			exitButton.setLayoutY(470);
			exitButton.setPrefWidth(400);
			exitButton.setPrefHeight(50);
			exitButton.setFont(Font.font("Verdana", 20));
			exitButton.setText("Exit Game");
			
			Image backGround = new Image("gfx/TicTacToe.png");
			
	         // simple displays ImageView the image as is
	         ImageView iv1 = new ImageView();
	         iv1.setImage(backGround);
	         iv1.setFitWidth(600);
			
			root.getChildren().addAll(startButton, exitButton, iv1);
		}
		return (menu);
	}

}
