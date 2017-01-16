package View;
import java.io.File;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class myLabel extends Label {

	/**
	 * @param file
	 */
	public myLabel(File file, String extention) {
		if (file.isDirectory())
			setImage("ico.png");			
		
		setText(file.getName());
		
		switch (extention){
		case "png" : {
			setImage("png.png");
			break;
		}
		case "mp3" : {
			setImage("mp3.png");
			break;
		}
		case "m4a" : {
			setImage("mp3.png");
			break;
		}
		case "avi" : {
			setImage("avi.png");
			break;
		}
		case "txt" : {
			setImage("txt.png");
			break;
		}
		case "pdf" : {
			setImage("pdf.png");
			break;
		}
		case "djvu" : {
			setImage("djvu.png");
			break;
		}
		//jar файли и директорию с анотацией будут пустыми строками
		case "annotation" : {
			setText("");
			break;
		}
		case "jar" : {
			setText("");
			break;
		}
		}
		 
		setStyle("-fx-font-family: Helvetica, Arial, sans-serif; -fx-font-size: 11pt;");

		
	}
	

	private void setImage(String nameImage){
		try{
			Image image = new Image(nameImage);			
			ImageView imageview = new ImageView(image);
			imageview.setFitWidth(45);
			imageview.setFitHeight(40);
			setGraphic(imageview);	
		}
		catch (IllegalArgumentException e) {
			System.out.println(nameImage + " - " + e.getMessage());
		}
		
	}
	


	

	 

}
