import javax.swing.JFrame;

public class Main extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public Main() {
		super();
		setLayout(null);
		setVisible(false);
		setSize(800, 600);
		setExtendedState(MAXIMIZED_BOTH);
		setUndecorated(true);
		setContentPane(new Panel());
		setVisible(true);
	}
	
	public static double a(int x){
		return 0.5*(Math.pow(x, 2));
	}
	
	public static double f(double x, double m, double t){
		return m*x+t;
	}
	
	public static double f(double x, double a, double d, double e){
		return a*(Math.pow(x,2)-d)+e;
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
