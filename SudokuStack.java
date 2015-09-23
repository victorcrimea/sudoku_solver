import java.util.Stack;


public class SudokuStack{
	private Stack<Sudoku> stack;
	private Stack<Integer> variants;
	
	public SudokuStack(){
		Stack<Sudoku> stack = new Stack<Sudoku>();
		Stack<Integer> variants = new Stack<Integer>();
	}
	
	public Sudoku pop(){
		variants.pop();
		return stack.pop();
	}
	public void push(Sudoku s, int vars){
		stack.push(s);
		variants.push(vars);
	}
	public Sudoku peek(){
		return stack.peek();
	}
	public int peekVariants(){
		return variants.peek();
	}
	public void changeVariants(int vars){
		variants.pop();
		variants.push(vars);
	}
	
	public int size(){
		return stack.size();
	}
	
}
