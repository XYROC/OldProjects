
public class Polyp {

	public static boolean failed;
	public static int startHeads;
	public static int heads = 0;
	public static int maxHeads = 0;
	public static int cycles = 0;

	public static void main(String[] args) {
		if (args.length != 1)
			return;
		startHeads = Integer.parseInt(args[0]);
		for (int i = 1; i <= startHeads; i++) {
			heads = i;
			cycles = 0;
			maxHeads = 0;
			failed = false;
			while (heads > 1) {
				if (heads > maxHeads)
					maxHeads = heads;
				if (heads % 2 == 0) {
					heads /= 2;
					cycles++;
					continue;
				}
				if (heads % 3 == 0) {
					heads /= 3;
					cycles++;
					continue;
				}
				if (heads % 5 == 0) {
					heads /= 5;
					cycles++;
					continue;
				}
				heads = heads * heads - 1;
				cycles++;
				if (cycles > 100 || heads < 1) {
					System.out.println("Failed! --> Heads: " + i + " Cycles: " + cycles + " Max Heads: " + maxHeads);
					failed = true;
					break;
				}
			}
			if(!failed) System.out.println("Finished! --> Heads: " + i + " Cycles: " + cycles + " Max Heads: " + maxHeads);
		}
	}

	public static void debug(int i) {
		int h = i;
		System.out.println("Starting with +" + i + " heads.");
		int c = 0;
		int mh = 0;
		while (h > 1) {
			c++;
			if (h > mh)
				mh = h;
			if (h % 2 == 0) {
				h /= 2;
				System.out.print("Current h: " + h + " (/2) \n");
				c++;
				continue;
			}
			if (h % 3 == 0) {
				h /= 3;
				System.out.print("Current h: " + h + " (/3) \n");
				c++;
				continue;
			}
			if (h % 5 == 0) {
				h /= 5;
				System.out.print("Current h: " + h + " (/5) \n");
				c++;
				continue;
			}
			if (c > 1000) {
				System.out.println("Failed! --> h: " + i + " c: " + c + " Max h: " + mh);
				break;
			}
			h = h * h - 1;
			System.out.print("Current h: " + h + " (-) \n");
		}
		System.out.println("Finished! --> h: " + i + " c: " + c + " Max h: " + mh);
	}

}
