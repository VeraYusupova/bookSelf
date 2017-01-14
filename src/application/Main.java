package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;



public class Main extends Application {
	private BorderPane root;
	@Override
	public void start(Stage primaryStage) {
		try {
			
			root = (BorderPane) FXMLLoader.load(Main.class.getResource("/View/BookLibrary.fxml"));
			Scene scene = new Scene(root,600,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			try{
				primaryStage.getIcons().add(new Image("ico.png"));
			}
			catch (IllegalArgumentException e) {
				System.out.println("ico.png - " + e.getMessage());
			}
			
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
