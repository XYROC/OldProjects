package wrenchloader;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import wrenchloader.file.FileHelper;

public class WrenchLoader {
	
	public static final File log = new File("log.txt");
	public static final Logger logger = Logger.getLogger("log");  
	
	public static void main(String[] args) throws IOException {
		System.out.println("Logging at: "+log.getAbsolutePath());
		//logger.setUseParentHandlers(false);
		if(!log.exists()) log.createNewFile();
	    FileHandler fh;  
	    try {  

	        fh = new FileHandler(log.getAbsolutePath());  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);
	        
	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }
	    if(args.length > 1) new WrenchLoader(args);
	    
	}
	
	public WrenchLoader(String[] args) throws IOException {
		String command = args[0];
		if(command.equalsIgnoreCase("write") && args.length >= 3){
			String path = args[1];
			System.out.println("WRITING: "+path);
			String[] data = args[2].split(";");
			byte[] bytes = new byte[data.length];
			for(int i = 0;i<data.length;i++){
				bytes[i] = Byte.parseByte(data[i]);
			}
			FileHelper.writeToFile(path, bytes);
			log("WRITE: Total file lentgh: "+bytes.length);
		}
		if(command.equalsIgnoreCase("read") && args.length >= 2){
			String path = args[1];
			System.out.println("READING: "+path);
			byte[] bytes = FileHelper.readFromFile(path);
			log("READ: Total file lentgh: "+bytes.length);
			for(byte b : bytes){
				System.out.println(b);
				log(""+b);
			}
			
		}
		
	}
	
	public static void log(String message){
		logger.info(message);
	}

}
