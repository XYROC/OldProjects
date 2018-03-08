package graphics.graphics2d.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Output extends PrintStream {

	public Output(File file) throws FileNotFoundException {
		super(file);
	}

	@Override
	public void println(String x) {
		String string = x;
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
		string = "[" + sdf.format(new Date()) + "] " + string;
		super.println(string);
	}

}
