import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.Vector;
import java.util.Stack;

class SudokuSolver {
	Sudoku s;
	Vector<Vector<Vector<Integer>>> variants;
	Stack<Sudoku> stack;
	SudokuSolver(Sudoku sudoku){
		this.s = sudoku;
		stack = new Stack<Sudoku>();
		//stack.push(s);
		variants = new Vector<Vector<Vector<Integer>>>(9);
		
		for(int i=0; i<9; ++i){
			Vector<Vector<Integer>> var1 = new Vector<Vector<Integer>>(9);
			for(int j=0; j<9; ++j){
				Vector<Integer> var2 = new Vector<Integer>(9);
				var1.add(var2);
			}
			variants.add(var1);
			
		}
		
		
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				if(s.field[i][j]==0){
					variants.get(i).get(j).add(1);
					variants.get(i).get(j).add(2);
					variants.get(i).get(j).add(3);
					variants.get(i).get(j).add(4);
					variants.get(i).get(j).add(5);
					variants.get(i).get(j).add(6);
					variants.get(i).get(j).add(7);
					variants.get(i).get(j).add(8);
					variants.get(i).get(j).add(9);
				}
			}
		}
	}

	void checkSmall(int i, int j){ //Проверяю малые квадраты
		//Определяю квадрат
		int smallX = 0;
		int smallY = 0;
		smallX = (int) Math.ceil((j*1.0+1)/3);
		smallY = (int) Math.ceil((i*1.0+1)/3);
		
		//System.out.println("smallX: " + smallX);
		//System.out.println("smallY: " + smallY);
		
		//Смотрю какие числа уже есть в этом квадрате
		Vector<Integer> have = new Vector<Integer>();
		for(int x=0; x<3; ++x){
			for(int y=0; y<3; ++y){
				int num = s.field[(smallY-1)*3+y][(smallX-1)*3+x];
				if(num != 0 ){
					have.add(num);
				}
			}
		}
		//Удаляю из вариантов найденные числа
		
		
		
		for(int counter=0; counter<have.size(); counter++){
			variants.get(i).get(j).removeElement(have.get(counter));
		}
		
		
		return;
	}

	void checkRow(int i, int j){ //Проверяю строки
		//Определяю строку
		int row = i;
		
		//Смотрю какие числа уже есть в этом квадрате
		Vector<Integer> have = new Vector<Integer>();
		for(int x=0; x<9; ++x){
			int num = s.field[row][x];
			if(num != 0 ){
				have.add(num);
			}
		}
		
		//Удаляю из вариантов найденные числа
		for(int counter=0; counter<have.size(); counter++){
			variants.get(i).get(j).removeElement(have.get(counter));
		}
		
		return;
	}
		void checkColumn(int i, int j){ //Проверяю столбцы
		//Определяю столбец
		int column = j;
		
		//Смотрю какие числа уже есть в этом квадрате
		Vector<Integer> have = new Vector<Integer>();
		for(int x=0; x<9; ++x){
			int num = s.field[x][column];
			if(num != 0 ){
				have.add(num);
			}
		}
		//Удаляю из вариантов найденные числа
		for(int counter=0; counter<have.size(); counter++){
			variants.get(i).get(j).removeElement(have.get(counter));
		}
		
		return;
	}

	void checkAll(){
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				checkSmall(i, j); //Проверяю малые квадраты
				checkRow(i, j);//Проверяю строки
				checkColumn(i, j); //Проверяю столбцы
			}
		}
	}
	
	boolean findObvious(){
		//Ищем ячейки в которых только один вариант
		boolean flag=false;
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				//System.out.println(variants.get(i).get(j).size());
				if(variants.get(i).get(j).size()==1){
					s.field[i][j]=variants.get(i).get(j).firstElement();
					flag=true;
					//return flag;
				}
			}
		}
		return flag;
	}
	
	boolean findPairs(){ 
		//Ищем ячейки в которых 2 варианта
		boolean flag=false;
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				if(variants.get(i).get(j).size()==2){
					stack.push(s);
					s.field[i][j]=variants.get(i).get(j).firstElement();
					flag=true;
				}
			}
		}
		return flag;
	}
	
	int numOfVariants(int i, int j){
		return variants.get(i).get(j).size();
	}
	
	boolean isFailed(){
		return false;
	}
	boolean isFinished(){
		boolean flag = true;
		checkAll();
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				if(variants.get(i).get(j).size()>0){
					flag=false;
				}
			}
		}
		return flag;
	}
	
	
	void solve(){
		int counter=1;
		boolean success=false;
		
		//Проверяю есть ли однозначные клетки
		checkAll();
		
		//SudokuSolver inSS = new SudokuSolver(s);
		//Если однозначные клетки есть - заполняю их
		boolean obv = findObvious();
		//Если нет однозначных - ищу двузначные
		
		
		//Создаю сольвер с первым вариантом поля
		
		//Пытаюсь решить поле полученным сольвером
		
		// Если не сложилось пробую следующий вариант
	
	
		do{
			checkAll();
			//s.print();
			//printVariants(counter++);
		}while(findObvious());
		s.print();
		s.field[1][3]=9;
		s.print();
		System.out.println(isFinished());
	}
	
	
	
	
	void printVariants(int varCount){
		
	
		for(int i=0; i<9; ++i){
			for(int j=0; j<9; ++j){
				System.out.println("vars("+ varCount +"): i=" + i +", j=" + j + ": ");
				
				for(int c=0; c<variants.get(i).get(j).size(); c++){
					System.out.print(variants.get(i).get(j).get(c));
					System.out.println("");
				}
			}
		}
	
	}

}

