package cn.edu.pku.ui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class WelcomeStage {
	
	
	public void welcome_stage(Stage primaryStage, final String __iconpath) {
		Stage welcomeStage=new Stage();
		HBox stageBox0 = new HBox(10);
		stageBox0.setId("welcome");
		Label label1 = new Label();
		label1.setText("CAS Raman Spectrum Viewer");
		label1.setTranslateX(-100);
		label1.setStyle("-fx-font: 25 arial; -fx-text-fill : white;");
		Button but = new Button();
		Button but2 = new Button();
		but.setStyle("-fx-font: 20 arial; -fx-base: green;");
		but2.setStyle("-fx-font: 20 arial; -fx-base: red;");
		but.setTranslateX(100.0);
		but.setTranslateY(200.0);
		but2.setTranslateX(300.0);
		but2.setTranslateY(but.getTranslateY());
		DropShadow shadow = new DropShadow();
		but.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		    but.setEffect(shadow);
		});
		but.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		    but.setEffect(null);
		});
		but2.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
		    but2.setEffect(shadow);
		});
		but2.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent e) -> {
		    but2.setEffect(null);
		});
		but.setText("开始使用");
		but2.setText("退出软件");
		stageBox0.getChildren().addAll(but,but2,label1);
		Scene scene0=new Scene(stageBox0,590,350);
		scene0.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
		welcomeStage.getIcons().add(new Image(getClass().getResourceAsStream(__iconpath)));
		welcomeStage.setScene(scene0);
		welcomeStage.setTitle("欢迎您的使用");
		welcomeStage.setResizable(false);
		welcomeStage.show();
		but.setOnAction((e) -> {
			welcomeStage.close();
			primaryStage.show();
		 });
		but2.setOnAction((e) -> {
			welcomeStage.close();
			primaryStage.close();
		 });
	}
}
