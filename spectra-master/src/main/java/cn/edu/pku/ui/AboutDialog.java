package cn.edu.pku.ui;

import cn.edu.pku.util.PropertiesUtils;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AboutDialog {
	final Stage stage = new Stage();
	final Button closeButton = new Button();
	final Hyperlink link1 = new Hyperlink();
	final Hyperlink link2 = new Hyperlink();
	final Hyperlink link3 = new Hyperlink();

	public AboutDialog(Stage primaryStage) {
		prepareStage(primaryStage);
		addListeners();
		stage.setScene(prepareScene());
	}

	public void showAbout() {
		stage.show();
	}

	private void prepareStage(Stage primaryStage) {
		stage.initStyle(StageStyle.TRANSPARENT);
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(primaryStage);
		stage.getIcons().add(new Image(getClass().getResourceAsStream("/images/cas.png")));
	}

	private Scene prepareScene() {
		VBox stageBox = new VBox(10);
		stageBox.setId("about");
		stageBox.setPadding(new Insets(0, 0, 0, 10));
		HBox closeBox = new HBox();
		closeButton.setId("close");
		closeBox.setAlignment(Pos.TOP_RIGHT);
		closeBox.getChildren().add(closeButton);
		Label name = new Label(PropertiesUtils.readDetails().get("name"));
		name.setId("header1");
		Label version = new Label(PropertiesUtils.readDetails().get("version"));
		version.setId("version");
		link1.setText("中国科学院地理科学与资源研究所");
		link1.setId("link");
		link2.setText("北京大学");
		link2.setId("link2");
		link3.setText("中国科学院半导体研究所");
		link3.setId("link3");
		stageBox.getChildren().addAll(closeBox, name, version,link1,link2,link3);
		Scene scene = new Scene(stageBox, 400, 250);
		scene.getStylesheets().add(getClass().getResource("/css/application.css").toExternalForm());
		return scene;
	}

	private void addListeners() {
		closeButton.setOnAction((e) -> stage.close());

		link1.setOnAction((e) -> {
			try {
				Desktop.getDesktop().browse(new URI(PropertiesUtils.readDetails().get("link")));
			} catch (IOException e1) {
				e1.printStackTrace();
			} catch (URISyntaxException e1) {
				e1.printStackTrace();
			}
		});
		link2.setOnAction((e) -> {
			try {
				Desktop.getDesktop().browse(new URI(PropertiesUtils.readDetails().get("link2")));
			} catch (IOException e2) {
				e2.printStackTrace();
			} catch (URISyntaxException e2) {
				e2.printStackTrace();
			}
		});
		link3.setOnAction((e) -> {
			try {
				Desktop.getDesktop().browse(new URI(PropertiesUtils.readDetails().get("link3")));
			} catch (IOException e3) {
				e3.printStackTrace();
			} catch (URISyntaxException e3) {
				e3.printStackTrace();
			}
		});
	}

}
