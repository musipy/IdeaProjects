package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        printMap(createMap());
        //int[] a = find(createMap(),4);
        System.out.println(canGoW(createMap()));
    }

    public static int[][] createMap(int r, int c){
        //create new 2d array with r rows, c columns
        int [][] map = new int [r][c];
        //return
        return map;
    }

    public static int[][] createMap(){
        int[][] map = createMap(10,10);
        //first row
        map[0][0] = 1; map[0][1] = 3;
        //second row
        map[1][1] = 3; map[1][3] = 3; map[1][5] = 3; map[1][7] = 3; map[1][8] = 3;
        //third row
        map[2][3] = 3; map[2][7] = 3;
        //fourth row
        map[3][0] = 3; map[3][2] = 3; map[3][4] = 3; map[3][5] = 3; map[3][6] = 3; map[3][9] = 3;
        //fifth row
        map[4][6] = 3; map[4][8] = 3;
        //sixth row
        map[5][1] = 3; map[5][2] = 3; map[5][3] = 3; map[5][7] = 3;
        //seventh row
        map[6][4] = 3; map[6][5] = 3; map[6][9] = 3;
        //eighth row
        map[7][1] = 3; map[7][4] = 3; map[7][6] = 3; map[7][8] = 3;
        //ninth row
        map[8][3] = 3;
        //tenth row
        map[9][1] = 3; map[9][4] = 3; map[9][7] = 3; map[9][9] = 2;
        return map;
    }

    public static String getSymbol(int value){
        //initialize empty string
        String rv = "";
        //set each value equal to corresponding sybol based on requirements
        if(value == 0){
            rv = "_";
        } else if (value == 1){
            rv = "Y";
        } else if (value == 2){
            rv = "F";
        } else if (value == 3){
            rv = "*";
        } else if (value == 4){//next two used for later purpose in the lab
            rv = "U";
        } else if (value == 5){
            rv = "D";
        }
        return rv;
    }

    public static void printMap(int[][] m){
        if(m == null){
            System.out.println("your array is null");
        } else {
            //traverse through 2d array
            for (int r = 0; r < m.length; r++) {
                for (int c = 0; c < m[r].length; c++) {
                    //print in same line the symbol using getSymbol
                    System.out.print(getSymbol(m[r][c]) + " ");
                }
                //start on new line after each row finished printing out
                System.out.println();
            }
        }
    }

    public static String mapToString(int[][] m){
        if(m == null){
            return null;
        }
        //initialize empty string
        String rv = "";
        //traverse through 2d array
        for(int r = 0; r<m.length; r++){
            for(int c = 0; c<m[r].length; c++){
                //add in same line the symbol using getSymbol
                rv += getSymbol(m[r][c])+ " ";
            }
            //start on new line after each row is added to rv
            rv += "\n";
        }
        return rv;
    }

    public static int[] find(int[][] m, int value){
        //null check
        if(m == null){
            return null;
        }
        //initialize array with two values
        int[] point = new int[2];
        //traverse through array
        for(int r = 0; r<m.length; r++){
            for(int c = 0; c<m[r].length; c++){
                //check if the value of current index is equal to the given value
                if(m[r][c] == value){
                    //return a two element array, first element being the row and second being the column
                    point[0] = r;
                    point[1] = c;
                }
            }
        }
        //check if should return null
        //see if point values are 0,0, and if m[0][0] equals the value given
        //if it is then return point
        //if it isn't return null
        if(point[0] == 0 && point[1] == 0 && m[0][0] != value){
            return null;
        } else {
            return point;
        }
    }

    public static boolean canGoN(int[][] m){
        //null check
        if(m == null){
            return false;
        }
        //find the position of where you are, is equal to 1 and there should only be one one
        int[] point = find(m,1);
        //if it is on the top row or there is a wall above you return false else return true
        if(point[0] != 0 && m[point[0]-1][point[1]] != 3){
            return true;
        } else {
            return false;
        }
    }

    public static boolean canGoS(int[][] m){
        //null check
        if(m == null){
            return false;
        }
        //find the position of where you are, is equal to 1 and there should only be one one
        int[] point = find(m,1);
        //if it is on the bottom row or there is a wall below you return false else return true
        if(point[0] != m.length-1 && m[point[0]+1][point[1]] != 3){
            return true;
        } else {
            return false;
        }
    }

    public static boolean canGoE(int[][] m){
        //null check
        if(m == null){
            return false;
        }
        //find the position of where you are, is equal to 1 and there should only be one one
        int[] point = find(m,1);
        System.out.println(point[0]);
        System.out.println(point[1]+1);
        //if it is on the last spot of the row or there is a wall to the right of you return false else return true
        if(point[1] != m[point[0]].length-1 && m[point[0]][point[1]+1] != 3){
            return true;
        } else {
            return false;
        }
    }

    public static boolean canGoW(int[][] m){
        //null check
        if(m == null){
            return false;
        }
        //find the position of where you are, is equal to 1 and there should only be one one
        int[] point = find(m,1);
        //if it is on the first spot of the row or there is a wall to the left of you return false else return true
        if(point[1] != 0 && m[point[0]][point[1]-1] != 3){
            return true;
        } else {
            return false;
        }
    }

    public static int[][][] create3dMap(int r, int c, int numFloors){
        int[][][] map = new int[numFloors][r][c];
        return map;
    }

    public static int[][][] create3dMap(){
        //initialize empty map with three floors
        int[][][] map = create3dMap(19,19,3);
        //first floor
        //first row
        map[0][0][0] = 1;
        //traverse through the entire array and make everything a wall, except conditionals which say which ones must be a blank spot
        for(int r = 0; r<18; r++){//because my last row only has one wall
            for(int c = 1; c<19; c++){//my first column is all blank
                //ninth row exception
                if(r == 9 && (c>=6 && c<=17)){//simple way to refer to all values from 6-17 including 6 and 17
                    map[0][r][c] = 0;
                } else if((r>=10 && r<=14) && (c == 6 || c == 17)){//refer to rows 11-14 and make columns 6 and seventeen blank
                    map[0][r][c] = 0;
                } else if(r == 15 && (c == 4 || c == 5 || c == 6 || c == 17)){//ignoring the ladder for now, can initialize that at the end
                    map[0][r][c] = 0;
                } else if((r == 16 || r == 17) && c == 17){
                    map[0][r][c] = 0;
                } else {
                    map[0][r][c] = 3; //everything not specified is going to be a wall
                }
            }
        }
        map[0][18][18] = 3;
        map[0][15][3] = 4;//up ladder
        //second floor
        //skip first row because all empty but assign first spot as up ladder
        map[1][0][0] = 4;
        //traverse through ro 2 - 15 excluding last column
        for(int r = 1; r<15; r++){
            for(int c = 0; c<18; c++){
                map[1][r][c] = 3;//everything equals walls
            }
        }
        //define the 16th row seperately
        map[1][15][0] = 3; map[1][15][1] = 3; map[1][15][2] = 3; map[1][15][4]= 5;//down or where you came up from
        //now define rest all the way to last column
        for(int r = 16; r<19; r++){
            for(int c = 0; c<19; c++){
                map[1][r][c] = 3;
            }
        }
        //third floor
        //everything is a wall except the center which is the finish line
        for(int r = 0; r<19; r++){
            for(int c = 0; c<19; c++){
                map[2][r][c] = 3;
            }
        }
        //define finish line
        map[2][9][9] = 2;
        return map;
    }

    public static int[][][] create3dMap(int numFloors){
        //initialize array
        int[][][] map = create3dMap(19,19,numFloors);
        for(int r = 0; r<numFloors; r++){
            int rand = (int)(Math.random()*18);
            int rand1 = (int)(Math.random()*18);
            int rand2 = (int)(Math.random()*(numFloors - 1));
            if(map[rand][rand1][rand2] == 0){
                map[rand][rand1][rand2] = 3;//assign random spot
            } else if(map[rand][rand1][rand2] != 0){ //if random spot is taken, assign it a new spot
                rand = (int)(Math.random()*18);
                rand1 = (int)(Math.random()*18);
                rand2 = (int)(Math.random()*(numFloors - 1));
                map[rand][rand1][rand2] = 3;
            }
            //initialize the start and finish --> end points
            map[0][0][0] = 1;
            map[18][18][numFloors-1] = 2;
            //define ladders at random spots
            map[rand][rand1][rand2] = 4;
            if(map[rand][rand1][rand2] != 4){
                map[rand][rand1][rand2] = 5;
            }
        }
        return map;
    }

    public static int[][] createMap(int n){
        //initialize map
        int[][] map = createMap(10,10);
        for(int r = 0; r<n; r++){
            int rand = (int)(Math.random()*9);
            int rand1 = (int)(Math.random()*9);
            if(map[rand][rand1] == 0){//if there is a blank space, make it a wall
                map[rand][rand1] = 3;
            } else if(map[rand][rand1] != 0){
                rand = (int)(Math.random()*9);
                rand1 = (int)(Math.random()*9);
                map[rand][rand1] = 3;
            }
            //set ends to start and finish
            map[0][0] = 1;
            map[9][9] = 2;
        }
        return map;
    }

    public static boolean canGoU(int[][][] m){
        //null check
        if(m == null){
            return false;
        }
        //find the floor where you are
        int[] point = new int[2];
        int floor = 0;
        for(int r = 0; r<m.length; r++){
            if(point[0] ==0 && find(m[r], 1)[0] != 0){
                point[0] = find(m[r], 1)[0];
                point[1] = find(m[r], 1)[1];
                floor = r;//find which floor
            } else {
                point[0] = find(m[r], 1)[0];
                point[1] = find(m[r], 1)[1];
            }
        }
        if(floor != 0 && m[floor-1][point[0]][point[1]] != 3){
            return true;
        } else {
            return false;
        }
    }

    public static boolean canGoD(int[][][] m){
        //null check
        if(m == null){
            return false;
        }
        //find the floor where you are
        int[] point = new int[2];
        int floor = 0;
        for(int r = 0; r<m.length; r++){
            if(point[0] ==0 && find(m[r], 1)[0] != 0){
                point[0] = find(m[r], 1)[0];
                point[1] = find(m[r], 1)[1];
                floor = r;//find which floor
            } else {
                point[0] = find(m[r], 1)[0];
                point[1] = find(m[r], 1)[1];
            }
        }
        if(floor != m.length && m[floor+1][point[0]][point[1]] != 3){
            return true;
        } else {
            return false;
        }
    }

    public static String mapToString(int[][][] m){
        //null check
        if(m == null){
            return "your map is empty/null";
        }
        String rv = "";
        //traverse through array
        for(int n = 0; n<m.length; n++){
            rv += "Level" + n + "\n";//start off with saying which level it is
            for(int r = 0; r<m[n].length; r++){//traverse through each row
                for(int c = 0; c<m[n][r].length; c++){
                    rv += getSymbol(m[n][r][c])+" ";//add symbol to each columnwith space
                }
            }
            rv += "\n";//add new line after each row;
        }
        return rv;
    }

    public static int[][] path(int[][] m){
        //null check
        if(m == null){
            return null;
        }
        //initialize 2d array which has
        int [][] direction = new int[m.length][2];
        for(int r = 0; r<m.length; r++){
            for(int c = 0; c<m[r].length; c++){
                direction[r] = find(m, 0);
            }
        }
        return direction;
    }

}
