package com.internshala.connect4game;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
	private Controller controller;

	@Override
	public void start(Stage primaryStage) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("game.fxml"));
		GridPane rootGridPane = loader.load();

		controller = loader.getController();
		controller.createPlayground();

		MenuBar menuBar=createMenu();
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

		Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
		menuPane.getChildren().add(menuBar);

		Scene scene=new Scene(rootGridPane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Connect Four");
		primaryStage.setResizable(false);
		primaryStage.show();


	}
	private MenuBar createMenu() {

		Menu fileMenu = new Menu("File");

		MenuItem newGame = new MenuItem("New Game");
		newGame.setOnAction(event -> controller.resetGame());

		MenuItem resetGame = new MenuItem("Reset Game");
		resetGame.setOnAction(event -> controller.resetGame());

		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();
		MenuItem exitGame = new MenuItem("Exit Game");
		exitGame.setOnAction(event -> exitGame());

		fileMenu.getItems().addAll(newGame, resetGame, separatorMenuItem, exitGame);

		Menu helpMenu = new Menu("Help");

		MenuItem aboutGame = new MenuItem("About Connect 4");
		aboutGame.setOnAction(event -> aboutConnect4());
		SeparatorMenuItem separatorItem = new SeparatorMenuItem();
		MenuItem aboutMe = new MenuItem("About Me");
		aboutMe.setOnAction(event -> aboutMe());

		helpMenu.getItems().addAll(aboutGame, separatorItem, aboutMe);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu,helpMenu);

		return menuBar;
	}

	private void exitGame() {
		Platform.exit();
		System.exit(0);
	}

	private void  resetGame(){


	}

	private void aboutConnect4() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About Connect 4 Game");
		alert.setHeaderText("How To Play ?");
		alert.setContentText("Connect Four is a two-player connection game in which the players first choose a color and then take turns dropping colored " +
				"discs from the top into a seven-column, six-row vertically suspended grid. The pieces fall straight down, " +
				"occupying the next available space within the column. The objective of the game is " +
				"to be the first to form a horizontal, vertical, or diagonal line of four of one's own " +
				"discs. Connect Four is a solved game. The first player can always win by playing the right moves.\n\n");


		alert.show();
	}

	private void aboutMe() {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("About The Developer");
		alert.setHeaderText("Kunal Satish Sardar");
		alert.setContentText("Hi! I am Kunal, I am desktop app developer" +
				"  Designing and Coding in Java have been my passion since my 1st Year of Engineering" +
				" the days I started working with computers but I found myself into app" +
				" intuitive and functional applications & websites. Being an Engineer" +
				" I believe in using science to find creative practical solutions." +
				" My other hobbies includes Photography, Cooking & Painting.");

		alert.show();
	}


	public static void main(String[] args) {
		launch();
	}
}
