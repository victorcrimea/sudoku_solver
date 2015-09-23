class Sudoku {
	public int[][] field;
	
	Sudoku(){
		field = new int[9][];
		
		/* easy 1
		field[0]= new int []{0,0,0,0,0,0,0,9,0};
		field[1]= new int []{0,0,0,9,0,1,6,2,0};
		field[2]= new int []{2,9,0,5,7,0,8,4,1};
		field[3]= new int []{4,0,0,0,6,0,9,0,2};
		field[4]= new int []{0,3,9,2,0,4,1,8,0};
		field[5]= new int []{5,0,2,0,1,0,0,0,4};
		field[6]= new int []{8,5,4,0,9,7,0,1,6};
		field[7]= new int []{0,2,6,1,0,5,0,0,0};
		field[8]= new int []{0,7,0,0,0,0,0,0,0};
		*/
		
		/* medium 1 */
		field[0]= new int []{0,0,0,0,6,4,8,1,0};
		field[1]= new int []{0,4,0,0,5,0,0,6,2};
		field[2]= new int []{0,0,9,0,1,0,3,0,0};
		field[3]= new int []{0,0,3,0,4,0,6,0,7};
		field[4]= new int []{0,0,8,1,0,7,5,0,0};
		field[5]= new int []{7,0,4,0,3,0,1,0,0};
		field[6]= new int []{0,0,6,0,7,0,2,0,0};
		field[7]= new int []{4,3,0,0,8,0,0,9,0};
		field[8]= new int []{0,1,7,3,9,0,0,0,0};
		
		
		/* hard 1
		field[0]= new int []{0,6,2,7,0,0,0,0,0};
		field[1]= new int []{0,9,0,0,1,0,0,0,0};
		field[2]= new int []{8,0,5,4,0,0,6,0,2};
		field[3]= new int []{0,8,0,0,6,0,0,0,9};
		field[4]= new int []{4,0,0,1,0,2,0,0,6};
		field[5]= new int []{2,0,0,0,4,0,0,3,0};
		field[6]= new int []{9,0,8,0,0,4,3,0,5};
		field[7]= new int []{0,0,0,0,8,0,0,9,0};
		field[8]= new int []{0,0,0,0,0,1,8,6,0};
		*/
	}
	
	
	void print(){
		for (int i=0; i<9; ++i) {
			for(int j=0; j<9; ++j){
				if(field[i][j]==0){
					System.out.print(" ");
				}else {
					System.out.print(field[i][j]);
				}
				if((j+1)%3==0)System.out.print("|");
			}
			
			System.out.println();
			if((i+1)%3==0) System.out.println("---+---+---");
		}
	}


}



/*
000|000|090
000|901|620
290|570|841
---+---+---
400|060|902
039|204|180
502|010|004
---+---+---
854|097|016
026|105|000
070|000|000

*/
