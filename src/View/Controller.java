package View;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.Tooltip;

public class Controller {

	 private Main main;
	 private ObservableList<Label> mylist;
	 private String pathFile;
	 private String pathAnnotation;
	 
	@FXML
	ListView<Label> list;
	@FXML
	Button open;
	@FXML
	Button mp3;
	@FXML
	Button addAnnotation;
	@FXML
	Label path;
	@FXML
	TextArea annotation;
	
	@FXML
	    private void initialize() throws IOException {			
		//Вид файлов всегда из каталога в котором расположена программа
		createList (new File("."));	
		 pathAnnotation = pathFile + "Annotation";
	   }
	
	    /**
	     * Вызывается главным приложением, которое даёт на себя ссылку.
	     * 
	     * @param mainApp
	     */
	    public void setMain(Main main) {
	        this.main = main;      	       
	    }
	    
	    @FXML
	    public void openButton() throws IOException{
	    	File f = new File(pathFile  + list.getSelectionModel().getSelectedItem().getText());
	    	if (list.getSelectionModel().getSelectedIndex() == 0){
	    		createList (f.getParentFile().getCanonicalFile());
	    	}
	    	if (f.isDirectory()){
	    		createList (f);
	    	}
	    	else {
	    		try{
	    			Desktop.getDesktop().open(f);	
	    		}
	    		catch (IOException e){
	    			JOptionPane.showMessageDialog(null, e.getMessage());
	    		}
	    		
	    	}
	    		
	    }
	    
	    public void createList (File f) throws IOException{	    
	    	mylist = FXCollections.observableArrayList();
	    	pathFile = f.getCanonicalPath()+ File.separator;	
			
			for (int i = 0; i<f.list().length; i++){
				File ff = new File(pathFile +f.list()[i]);
				if (!ff.isHidden()) {
					// пустые метки не вносим в список
					myLabel mL = new myLabel(ff, new FileWork().fileExtention(ff));
					if (!mL.getText().isEmpty()) mylist.add(mL);					
					}
			}
			mylist.add(0, new Label("..")); //удивительная конструкция!!!!	
			
		    list.setItems(mylist);		    
		    list.getSelectionModel().select(0);
		    path.setText(pathFile);
	    }
	    
	    @FXML
	    public void addButton() throws IOException {
	    	String nameFileSelect = list.getSelectionModel().getSelectedItem().getText();
	    	new FileWork().writeFile(pathAnnotation, nameFileSelect, annotation.getText());
	    	
            
	    	}
	    
	    @FXML
	    public void itemListSelect()  {
	    	String nameFileSelect = list.getSelectionModel().getSelectedItem().getText();
	    	File f = new File(pathFile+ "Annotation" +File.separator + nameFileSelect+ ".txt");
	    	
	    		try {
					FileReader r = new FileReader(f);
					BufferedReader reader = new BufferedReader(r);
					String line;			        
						while ((line = reader.readLine()) != null) 
						    annotation.setText(line);
					reader.close();
				} catch (FileNotFoundException e) {					
					//System.out.println(e.getMessage());
					annotation.setText("");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
	    	} 
	    
	    @FXML
	    public void onClick(ActionEvent ae)  {
	    	Button b = (Button)ae.getSource();
	    	System.out.println(b.getId());
	    	} 
	   
}


