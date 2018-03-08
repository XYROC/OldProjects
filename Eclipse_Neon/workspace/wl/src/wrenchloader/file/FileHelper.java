package wrenchloader.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHelper {
	
	public static byte[] readFromFile(String path) throws IOException{
		return Files.readAllBytes(Paths.get(path));
	}
	
	public static void writeToFile(String filePath, byte[] bytes) throws IOException{
		Files.write(Paths.get(filePath),bytes);
	}

}
