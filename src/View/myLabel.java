package View;
import java.io.File;
import java.io.FileNotFoundException;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class myLabel extends Label {

	public myLabel(File file) {
		if (file.isDirectory())
			setImage("ico.png");			
		String name = file.getName();
		//узнаем расширение файла
		String s = name.substring(name.lastIndexOf(".")+1);
		//System.out.println(name.substring(name.lastIndexOf(".")+1)+" ");
		
		switch (s){
		case "png" : {
			setImage("png.png");
			break;
		}
		case "mp3" : {
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
		}
		 
		
		setText(name);
	}
	

	private void setImage(String nameImage){
		try{
			Image image = new Image(nameImage);			
			ImageView imageview = new ImageView(image);
			imageview.setFitWidth(25);
			imageview.setFitHeight(25);
			setGraphic(imageview);	
		}
		catch (IllegalArgumentException e) {
			System.out.println(nameImage + " - " + e.getMessage());
		}
		
	}
	


	

	 

}
