package View;
import java.io.File;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class myLabel extends Label {

	public myLabel(File name) {
		if (name.isDirectory()){
			Image image = new Image("ico.png");
			ImageView image1 = new ImageView(image);
	    	image1.setFitWidth(25);
	    	image1.setFitHeight(25);
			setGraphic(image1);
		}
		
		/*String s = name.substring(name.lastIndexOf(".")+1);

		System.out.println(name.substring(name.lastIndexOf(".")+1)+" ");
	
		switch (s){
		case "png" : {
			Image image = new Image("ico.png");
			ImageView image1 = new ImageView(image);
	    	image1.setFitWidth(25);
	    	image1.setFitHeight(25);
			setGraphic(image1);	
		}
		}*/
		 
		
		setText(name.getName());
	}
	
	


	

	 

}
