import java.util.Date;

public class Main {

	public static void main(String... args){
		
		
		final int NUM = 1000;
		long start = new Date().getTime();
		//=============================
		
			Sudoku s = new Sudoku();
			SudokuSolver ss = new SudokuSolver(s);
			
			//ss.checkSmall(8,8);			
			ss.solve();

		//=============================
		long end = new Date().getTime();

		long msec = end-start;
		
		System.out.println("exec time: " + msec + " msec");
		
		
	}

}
