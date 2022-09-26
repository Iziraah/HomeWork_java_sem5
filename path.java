public class path {
    public static void main(String[] args) {
    
        int[][] pole = new int[10][10];
        for (int i = 0; i < pole.length; i++) {
			for (int j = 0; j < pole[i].length; j++) {
				pole[i][j] = 0;
			}  
        }
        for (int i = 2; i < 8; i++) {pole[i][2] = -1 ;}
        for (int i = 4; i < 8; i++) {pole[4][i] = -1 ;}
        for (int i = 0; i < 10; i++) {pole[0][i] = -1 ;}
        for (int i = 0; i < 10; i++) {pole[i][0] = -1 ;}
        for (int i = 9; i > 0; i--) {pole[i][9] = -1 ;}
        for (int i = 9; i > 0; i--) {pole[9][i] = -1 ;}
        pole[5][1] = 1;//start
        pole[3][8] = -7;//finish
        print(pole);
        findPath(pole, pole[5][1], pole[3][8]); 
        System.out.println("-------");
        print(pole);
        System.out.println(findStep(pole, pole[3][8], 0));
        int step = findStep(pole, pole[3][8], 0);
        System.out.println("-------");
        minPath(pole, -7, 1,step);
        print(pole);
        beautiPole(pole);
        System.out.println("-------");
        print(pole);


    }

    public static void print(int[][] x){
        for (int i = 0; i < x.length; i++) {  
            for (int j = 0; j < x[i].length; j++) {
                if (x[i][j]>=0 && x[i][j]<10) System.out.print(x[i][j] + "   ");
                if (x[i][j]<0 || x[i][j]>=10) System.out.print(x[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public static void findPath(int[][] x, int s, int f){
        for (int i = 0; i < x.length; i++) {  
            for (int j = 0; j < x[i].length; j++) {
                if(x[i][j] == s){
                //if (x[i-1][j] ==f || x[i][j+1] == f || x[i+1][j] ==f || x[i][j-1]==f){ return;}
                if(x[i-1][j] == 0) {x[i-1][j] = s+1; }                
                if(x[i][j+1] == 0) {x[i][j+1] = s+1; }                
                if(x[i+1][j] == 0) {x[i+1][j] = s+1; }                
                if(x[i][j-1] == 0) {x[i][j-1] = s+1; }
                if(x[i][j+1] == f) {return;}
                if(x[i][j-1] == f) {return;}
                if(x[i+1][j] == f) {return;}
                if(x[i-1][j] == f) {return;}                               
            }            
        }    
    }
    findPath(x,s+1,f);
}


public static int findStep(int[][] x, int f, int step){
   for (int i = 0; i < x.length; i++) {  
        for (int j = 0; j < x[i].length; j++) {
            if(x[i][j] == f){
            if (x[i-1][j] >0){step = x[i-1][j];}
            if (x[i][j+1] >0 && x[i][j+1] < step){step = x[i][j+1];}
            if (x[i][j-1] >0 && x[i][j-1] < step){step = x[i][j-1];}
            if (x[i+1][j] >0 && x[i+1][j] < step){step = x[i+1][j];}
                    }
                }
        } 
        return step;
}

public static void minPath(int[][] x, int f, int s, int step){
    for (int i = 0; i < x.length; i++) {  
        for (int j = 0; j < x[i].length; j++) {
            if(step==1){return;}
            if(x[i][j] == f){
            if(x[i-1][j]==1|| x[i][j+1]==1|| x[i+1][j]==1|| x[i][j-1]==1){return;}
            if(x[i-1][j] == step) {x[i-1][j] = -9; }                
            else if(x[i][j+1] == step) {x[i][j+1] = -9; }                
            else if(x[i+1][j] == step) {x[i+1][j] = -9; }                
            else if(x[i][j-1] == step) {x[i][j-1] = -9; } 
            f = -9;                          
                }                        
        }    
    }
    minPath(x,f,s,step-1);
}

public static void beautiPole(int[][] x){
    for (int i = 0; i < x.length; i++) {
        for (int j = 0; j < x[i].length; j++) {
            if(x[i][j]>0 || x[i][j]==1){
            x[i][j] = 0;}

}
}
}
}




