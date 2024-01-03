package honorsProject;

//CSC300-HONORS PORJECT- MAZE CLASS
//THIS GOES WITH MAZE DRIVER
//THIS TRAVERSE A MAZE RECURSIVELY, STICKING TO THE LEFT WALL


public class Maze2 
{
    public int rows;
    public int columns;
    public double angle;
    public char [][] maze;
    public static final int LOWER_ROW_BOUND = 0;   //these four variables are for finding out of bounds and returning true
    public static final int LOWER_COLUMN_BOUND = 0;
    public static final int UPPER_ROW_BOUND = 20;
    public static final int UPPER_COLUMN_BOUND = 30;
    public static int counter =0;                 //this variable makes sure we do not leave the maze on when we enter the maze(i do not think it is needed when the maze is bounded right, but I kept it)
    public static boolean trueChecker = false;    //this is here as my recursive methods would no go back up properly, but this becomes true when we exit the maze, then we can do this over and over


    //-----------------------------------------------------------

    //this is the maze constructor
    public Maze2(String[] stringArray)             
    {
        this.rows = stringArray.length;                 //makes the amount of row the length of the amount of strings
        this.columns = stringArray[0].length();         //this finds the amount of columns by reading the amount of chars in the first string in teh stringarray
        this.maze = new char[rows][columns];            //instead of using an array of strings, i would rather make it a 2d array of chars, so i can work with [][] instead of string[].charAt()
        for (int i=0;i<rows;i++)                        //this fills another 2d array
        {
            for(int j = 0; j<columns;j++)
            {
                maze[i][j] = stringArray[i].charAt(j);
            }
        }


        for (int i=0;i<rows;i++)                        //this prints the maze so we can see if it prints right
        {
            for(int j = 0; j<columns;j++)
            {
                if (j == 29)
                {
                    System.out.println();
                }
                System.out.print(maze[i][j]);
            }
        }
        System.out.println();                           //just a barrier
        System.out.println();
    }
    //-------------------------------------------------------------

    //this finds a way out of a 2d array of chars given a colum, row, and heading
    //if there is no exit it will eventually make its way out the entrance(the way it came in)
    //if there is no entrance or exit and it was parachuted in, it will go forever
    public boolean search(int row, int column, double angle)
    {

        if(trueChecker == true)//this is a so we do not keep looking for an exit if we already found one
        {
            return true;
        }

        if (maze[row][column] == 'X')                                             //if we "land" on an x this appears
        {
            System.out.println("This location is an x, try another coordinate?");
            return false;
        }

        if ((row <= LOWER_ROW_BOUND || row >= UPPER_ROW_BOUND-1) && counter != 0) 
        {
            System.out.println("Left maze at (" + row + "," + column + ")" );     
            trueChecker = true;                                                   
            return true;                                                          
        }
        if((column <= LOWER_COLUMN_BOUND || column >= UPPER_COLUMN_BOUND-1) && counter != 0)
        {
            System.out.println("\nLeft maze at (" + row + "," + column + ")" );
            trueChecker = true;
            return true;
        }


        counter++;                                                                                                                 

        System.out.print("(" + row + "," + column + ")");
        


        double tempAngle=angle;  
        double previousAngle = angle;                                                 
        for(int i = 0; i<4 ; i++)                                                  
        {
            if(i == 0)                                                            
            {       
                tempAngle = (angle + 90) %360;
            }
            if(i == 1)                                                            
            {
                tempAngle = (angle + 0) % 360;
            }
            if(i == 2)                                                           
            {
                tempAngle = (angle - 90) %360;
            }
            if(i == 3)                                                           
            {
                tempAngle =(angle - 180) %360;
            }
            

           if ((tempAngle == 90 || tempAngle == -270) && maze[row - 1][column] == ' ') 
            {
                if(previousAngle != tempAngle)
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row-1, column, tempAngle);
            }
            
            else if (tempAngle == 0 && maze[row][column + 1] == ' ')                    
            {
                if(previousAngle != tempAngle)                                          
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row, column+1, tempAngle);
            }
            
            else if ((tempAngle == -90 || tempAngle== 270) && maze[row + 1][column] == ' ') 
            {
                if(previousAngle != tempAngle)
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row+1, column, tempAngle);
            }
            
            else if ((tempAngle == -180 || tempAngle == 180) && maze[row][column - 1] == ' ') 
            {
                if(previousAngle != tempAngle)
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row, column-1, tempAngle);
            }

            if(trueChecker == true)                                                          
            {
            return true;
            }
            
        }//end of our main angle for loop

        System.out.println("LEFT THE FOR LOOP!!! UH OH");
        return false;                                     


    }//end of search method
}//end of maze class
