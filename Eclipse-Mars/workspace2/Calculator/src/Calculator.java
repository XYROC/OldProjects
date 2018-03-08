import java.math.BigDecimal;

public class Calculator {
	
	
	public Calculator() {
		for(int i = 0;i<30;i++){
			System.out.println(fac(i));
		}
		System.out.println("\n"+Long.MAX_VALUE);
	}
	
	BigDecimal s = new BigDecimal("");
	
	
	public static void main(String[] args) {
		new Calculator();
	}
	
	public long fac(float n){
		/**
		 * n should not be higher than 20
		 */
		long r = 1;
		for(long i = 1; i < n; i++){
			r *= i;
		}
		if(r < 1) System.out.println("Error (Calculating "+n+")");
		return r;
	}
	
	
}
