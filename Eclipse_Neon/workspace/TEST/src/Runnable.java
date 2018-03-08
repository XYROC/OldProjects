import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Runnable {

	public static void main(String args[]) throws InterruptedException, IOException {
		List<String> command = new ArrayList<String>();
		command.add("write");
		command.add("binary.BNRY");
		command.add("1;3;-32;23;34359993442;3245;-12423435;322;0");

		ProcessBuilder builder = new ProcessBuilder(command);
		Map<String, String> environ = builder.environment();

		final Process process = builder.start();
	}
}
