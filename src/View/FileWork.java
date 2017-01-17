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
	
	public String fileExtention (File file){
		String name = file.getName();
		return name.substring(name.lastIndexOf(".")+1).toLowerCase();		
	}
	
	public void writeFile(String path, String nameFile, String text) throws IOException{
		
		new File(path).mkdirs();
    	File f = new File (path + File.separator + nameFile + ".txt");
    	
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
	            new File(path).mkdirs();
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
