class Solution {
    
    
	
    private static int[] movX = {
        
                    0 , 0 , 0 ,
                    1 , 1 , 1 ,
                   -1 , -1 , -1
                                 };
    
    private static int[] movY = {
        
        0 , 1 , -1 , 
        -1 , 1 , 0 ,
        1 , 0 , -1
        
        
        };
    
    
    public boolean exist(char[][] board, String word) {
        
        for(int x = 0 ; x < board.length;x++)
            for(int y = 0 ; y < board[x].length;y++)
                 if(back( board , word , x , y , 0, new boolean[board.length][board[x].length])) return true;
        
        return false;
    }
    
    public boolean back(char[][] board, String word, int x , int y, int w, boolean[][]b){        
        if( w == word.length()){ // condicao de parada final
            return true;
        }
	else if( x < 0 || x > board.length - 1 || y < 0 || y > board[x].length -  1 ||
          b[x][y] == true
          ){// parada final
            return false;
        }
	else{// execucao "permanente"

            System.out.println(word.charAt(w) +" "+w);
	    //System.out.println(new StringBuilder().append(word.charAt(w)).append(" ").append(w).toString() );
            int posX = x , posY = y;
            if( Character.valueOf(word.charAt(w)).equals(new Character(board[x][y]))){


                b[x][y] = true;

                for(int j = 0 ; j < movX.length; j++){ // for(int j = 1 ; j < movX.length; j++){
                    if(back(board , word , x + movX[j] , y + movY[j] , w + 1,b )){
                        return true;
                    }
                }


            }
            
        }
        return false;
       
    }
}