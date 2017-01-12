/**
 * 
 */
package View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author ПК 09.01/2017
 * Класс обеспечивающий работу с файлом
 *
 */
public class FileWork {
	
	public void writeFile(String path, String nameFile, String text) throws IOException{
		
		
    	File f = new File (path +"Annotation/" + nameFile + ".txt");
    	FileWriter writer = new FileWriter(f, false);
    	if (text.isEmpty()){
    		// TODO Auto-generated catch block
    	}
    	else{
    		try
	        {	    		
	    		 writer = new FileWriter(f, false);
	    	}
	        catch(FileNotFoundException ex){
	        	// System.out.println(ex.getMessage());
	            new File(path+"Annotation").mkdirs();
	            writer = new FileWriter(f, false);
	        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		writer.write(text);
    		writer.flush();
            writer.close();
    	}
	}

}
