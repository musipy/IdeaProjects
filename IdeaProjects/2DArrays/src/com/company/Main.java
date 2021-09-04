package com.company;

public class Main {

    public static void main(String[] args) {
        int[]a = {10,2,3,4,5};
        int[][]b = {{1,-1,1},{1,-1,0},{1,-1,-1}};
        System.out.println(arrayToString(b));
        System.out.println(ticTacToe(b));
    }

    public static int [][] expand (int[][]a){
        //initialize new 2d array
        int [][] rv = new int[a.length*2][];
        //null check
        if(a == null){
            return null;
        }
        for (int r = 0; r<a.length; r++){ //set length of each row(have to double each row)
            rv[r*2] = new int [a[r].length*2];//first row
            rv[2*r+1] = new int [a[r].length*2];//second row
            for(int c = 0; c<a[r].length; c++){//transverse through array (must double elements within each row)
                rv[r*2][c*2] = a[r][c];
                rv[2*r][2*c+1] = a[r][c];
                rv[2*r+1][c*2] = a[r][c];
                rv[2*r+1][2*c+1] = a[r][c];
            }
        }
        return rv;
    }

    public static String arrayToString(int[]a){
        //null check
        if(a == null){
            return null;
        }
        //initialize string
        String rv = "{";
        //traverse and add comma then element
        for (int i = 0; i<a.length; i++){
            //if first element then no comma before is added
            if (i == 0){
                rv += a[i];
            } else {
                //comma then element if not first element
                rv += "," + a[i];
            }
        }
        //return with close brace
        return rv + "}";
    }

    public static String arrayToString(int[][]a){
        //null check
        if(a==null){
            return null;
        }
        //initialize empty stirng
        String rv = "";
        //traverse through string
        for(int i = 0; i<a.length; i++){
            if(i == 0){
                //not add new line in beginning of array ( {{1,2,3, )
                rv += arrayToString(a[i]);
            } else {
                //add comma then go to next row and print
                rv += ",\n " + arrayToString(a[i]);
            }
        }
        //return with braces
        return "{" + rv + "}";
    }


     public static int totalSum (int[][]a){
         //null check
         if (a == null){
             return 0;
         }
         //intitialize sum variable
         int rv = 0;
         //transverse through array
         for(int r = 0; r<a.length; r++){
             for(int c = 0; c<a[r].length; c++){
                 //add on to count when transversing
                 rv += a[r][c];
             }
         }
         //return variable
         return rv;
     }

     public static int majorSum (int[][]a){
         //null check
         if(a == null){
             return 0;
         }
         //initialize sum variable
         int rv = 0;
         //initialize index counter --> increments after traversing through first element/array of 2d array
         int indexCount = 0;
         //transverse through array
         for(int r = 0; r<a.length; r++){
             //add to sum (a[0][0])
             rv += a[r][indexCount];
             //increment index counter
             indexCount++;
         }
         return rv;
     }

     public static int minorSum (int[][]a){
         //null check
         if(a == null){
             return 0;
         }
         //initialize sum variable
         int rv = 0;
         //initialize index counter --> this time set to last index of the array (square array means a.length-1 or a[0].length-1
         int indexCount = a[0].length-1;
         //transverse through array
         for(int r = 0; r<a.length; r++){
             //add to sum
             rv += a[r][indexCount];
             //decrement indexCounter
             indexCount--;
         }
         //return
         return rv;
     }

     public static int min(int[] a){
         //null check
         if(a == null){
             return 0;
         }
         //initialize rv --> first element of the array
         int rv = a[0];
         //transverse through array starting with second element/index 1
         for(int i = 1; i<a.length; i++){
             //check if current element is greater than rv
             //if it is replace with current element
             if(a[i] < rv){
                 rv = a[i];
             }
         }
         //return
         return rv;
     }

    public static int min(int[][] a){
        //null check
        if(a == null){
            return 0;
        }
        //initialize minimum variable --> use task 7 to get minimum of first row
        int rv = min(a[0]);
        //traverse through array
        for(int r = 1; r<a.length; r++){
            //compare min of first row to min of current row
            if(min(a[r]) < rv){
                rv = min(a[r]);
            }
        }
        //return
        return rv;
    }

    public static int min2(int[][] a) {
        //null check
        if(a == null){
            return 0;
        }
        //initialize minimum variable --> first element of array a[0][0]
        int rv = a[0][0];
        //traverse array
        for(int r = 0; r<a.length; r++){
            for(int c = 0; c<a[r].length; c++){
                //compare current element with rv
                if(a[r][c] < rv){
                    rv = a[r][c];
                }
            }
        }
        //return
        return rv;
    }

    /*
    1. null check
    2. store the two other columns in two seperate variables.
     */
    public static int[][] rotate(int[][]a){
        //null check
        if(a == null){
            return null;
        }
        int temp = 0;
        //traverse through array
        for(int r = 0; r<a.length; r++){
            for(int c = r; c<a.length-1-r; c++){
                temp = a[r][c];
                a[r][c] = a[a.length -1 -c][r];
                a[a.length-1-c][r] = a[a.length-1-r][a.length-1-c];
                a[a.length-1-r][a.length-1-c] = a[c][a.length-1-r];
                a[c][a.length-1-r] = temp;
            }
        }
        //return
        return a;
    }

    public static void patternPrint (){
        //task a
        int [][] a = new int [5][];
        //assign length of each sub array
        for(int r = 0; r<a.length; r++){
            a[r] = new int[r+1];
            //traverse through array
            for(int c = 0; c<a[r].length; c++){
                a[r][c] = c+1;
                //print
                System.out.print(a[r][c]);
            }
            //start on a new line after each sub array
            System.out.println();
        }
        //task b
        int[][]b = new int [5][];
        //assign length of each sub array
        for(int r = 0; r<b.length;r++){
            b[r] = new int [b.length - r];
            //traverse through array and assign
            for(int c = 0; c<b[r].length; c++){
                b[r][c] = b[r].length-c;
                //print
                System.out.print(b[r][c]);
            }
            //new line
            System.out.println();
        }
        //task c
        int[][]c = new int [5][];
        //assign length for each sub array
        for(int i = 0; i<c.length; i++){
            c[i] = new int [i+1];
            //traverse array
            for(int j = 0; j<c[i].length; j++){
                c[i][j] = c.length - i;
                //print
                System.out.print(c[i][j]);
            }
            //new line
            System.out.println();
        }
    }

    public static int[][] pascalsTriangle(int n){
        //create empty array
        int [][] rv = new int [n][];
        //assign length of each row
        for(int r = 0; r<rv.length; r++){
            rv[r] = new int [r+1];
            //traverse through array
            for(int c = 0; c<rv[r].length; c++){
                //check which position element is (ends or middle)
                if(c == 0|| c == r){ //if end or start equals one
                    rv[r][c] = 1;
                } else {
                    rv[r][c] = rv[r-1][c-1] + rv[r-1][c];//add top two elements
                }
            }
        }
        return rv;
    }

    public static int ticTacToe (int[][]a){
        //initialize winner variable
        int winnerx = 0;
        int winnero = 0;
        //check horizontals first
        //add one to x win --> helps in the end to determine if there is a tie somewhere in the game (x wins are equal to o wins)
        for(int r = 0; r<3; r++){
            if(a[r][0] == a[r][1] && a[r][0] == a[r][2] && a[r][0] == 1){
                winnerx ++;
            } else if (a[r][0] == a[r][1] && a[r][0] == a[r][2] && a[r][0] == -1){
                winnero ++;
            }
        }
        //check vertical
        for(int r = 0; r<3; r++){
            if(a[0][r] == a[1][r] && a[0][r] == a[2][r] && a[0][r] == 1){
                winnerx ++;
            } else if (a[0][r] == a[1][r] && a[0][r] == a[2][r] && a[0][r] == -1){
                winnero ++;
            }
        }
        //check diagonals
        //right to left diagonal
        if(a[0][0] == a[1][1] && a[0][0] == a[2][2] && a[0][0] == 1){
            winnerx ++;
        } else if (a[0][0] == a[1][1] && a[0][0] == a[2][2] && a[0][0] == -1){
            winnero ++;
        }
        //left to right diagonal
        if(a[0][0] == a[1][1] && a[0][0] == a[2][2] && a[0][0] == 1){
            winnerx ++;
        } else if (a[0][0] == a[1][1] && a[0][0] == a[2][2] && a[0][0] == -1){
            winnero ++;
        }
        //decide who winner is
        if(winnero>winnerx){
            return -1;
        } else if (winnerx>winnero){
            return 1;
        } else {
            return 0;
        }
    }
}
