package cn.edu.pku;

import cn.edu.pku.ui.WelcomeStage;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.fxml.FXMLLoader;


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {

		try {

			/** Project Structure Example:
			 *
			 * 	src/main/java
			 * 		|
			 * 		cn.edu.pku
			 * 			|
			 * 			controllers
			 * 				|
			 * 				Screen1controller.java
			 * 				Screen2controller.java
			 * 			service
			 * 				|
			 * 				Service1.java
			 * 			dao(persist)
			 * 				|
			 * 				SaveProducts.java
			 * 			Main.java
			 *
			 * 	src/main/resources
			 * 		|
			 * 		view
			 * 			|
			 * 			screen1.fxml
			 * 			screen2.fxml
			 * 		css
			 * 			|
			 * 			style.css
			 * 		images
			 * 			img1.jpg
			 * 			img2.jpg
			 *
			 * */

			// Resources Paths
			final String __indexpath = "/view/Index.fxml";
			final String __iconpath = "/images/cas.png";
			
		
			// Load root scene
			FXMLLoader indexLoader = new FXMLLoader(getClass().getResource(__indexpath));
			Parent root = indexLoader.load();
			Scene scene = new Scene(root);

			// Set CSS Files
			String cssFile1 = this.getClass().getResource("/css/application.css").toExternalForm();
			String cssFile2 = this.getClass().getResource("/css/tab.css").toExternalForm();
			scene.getStylesheets().addAll(cssFile1,cssFile2);


			// Set icon and title
			primaryStage.getIcons().add(new Image(getClass().getResourceAsStream(__iconpath)));
			primaryStage.setTitle("CAS Raman Spectrum Viewer");
			primaryStage.setScene(scene);
			//primaryStage.show();
			
			// Set welcome interface
			 
			WelcomeStage welcome = new WelcomeStage();
			welcome.welcome_stage(primaryStage, __iconpath);
			 
		} catch(Exception e) {
			e.printStackTrace();
		} // end of try catch

	} // end of start()



	public static void main(String[] args) {

		launch(args);

	} // end of main()

}
