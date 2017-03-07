// package project1;
// package project/path/goes/here;

public class Test {

	public static void main(String[] args) {
		ClassicMult classic = new ClassicMult();
		DNCMult dnc = new DNCMult();
		StrassenMult strassen = new StrassenMult();
		
		long initTime;
		long finalTime;
		
		double n = 0;
		
		for(int i = 1; i < 15; i++){
			n = Math.pow(2, i);
			System.out.println("Dimension: " + n);
			initTime = System.currentTimeMillis();
			//classic.classicMult((int) n);
			//dnc.dncMult((int) n);
			strassen.strassenMult((int) n);
			finalTime = System.currentTimeMillis();
			System.out.println("Execution time for classic matrix multiplication: ");
			System.out.print (finalTime - initTime + " milliseconds.");
			System.out.println();
		}
	}

}
