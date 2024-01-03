package honorsProject;

//CSC300-HONORS PORJECT- MAZE CLASS
//THIS GOES WITH MAZE DRIVER
//THIS TRAVERSE A MAZE RECURSIVELY, STICKING TO THE LEFT WALL


public class Maze 
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
    public Maze(String[] stringArray)             
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

        if ((row <= LOWER_ROW_BOUND || row >= UPPER_ROW_BOUND-1) && counter != 0) //if we eventually find an exit we come to these two if stmts
        {
            System.out.println("Left maze at (" + row + "," + column + ")" );     //print where we left
            trueChecker = true;                                                   //this become true when we found and exit
            return true;                                                          //we can be done with this method
        }
        if((column <= LOWER_COLUMN_BOUND || column >= UPPER_COLUMN_BOUND-1) && counter != 0)//see if above
        {
            System.out.println("Left maze at (" + row + "," + column + ")" );
            trueChecker = true;
            return true;
        }


        counter++;                                                                //this is so we do not leave when we enter, i do not think it is actually needed
        maze[row][column] = 'O';                                                  //this is our current location printed as an O in the maze- CAN GET RID OF THIS TO GET SAME PRINT AS SAMPLE RUN
        for (int i=0;i<rows;i++)
        {
            for(int j = 0; j<columns;j++)                                         //another maze printing for loop
            {
                if (j == 29)
                {
                    System.out.println();
                }
                System.out.print(maze[i][j]);
            }
        }//end of maze printing for loop
        maze[row][column] = ' ';                                                  //changes the current location back to a ' ' so we do not mess up or future
        System.out.println();                                                     //barriers
        System.out.println();

        System.out.print("(" + row + "," + column + ")");                         //prints our actual coordinates
        System.out.println();



        double tempAngle=angle;                                                   //i think this is so we do not change the original angle
        double previousAngle = angle;
        for(int i = 0; i<4 ; i++)                                                 //needed a for loop as the rubric says, goes through each angle 
        {
            if(i == 0)                                                            //angle + 90 is left of our current angle, which is why tempangle is equal to angle, we do left on first iteration ( i=0)
            {       
                tempAngle = (angle + 90) %360;
            }
            if(i == 1)                                                            //check straight ahead next
            {
                tempAngle = (angle + 0) % 360;
            }
            if(i == 2)                                                           //check right next
            {
                tempAngle = (angle - 90) %360;
            }
            if(i == 3)                                                           //check right of that right next
            {
                tempAngle =(angle - 180) %360;
            }
            

           if ((tempAngle == 90 || tempAngle == -270) && maze[row - 1][column] == ' ') //if we are clear up  and looking up than we search above us
            {
                if(previousAngle != tempAngle)                                         //these if statements will only print if we change the direction we are going                     
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row-1, column, tempAngle);
            }
            
            else if (tempAngle == 0 && maze[row][column + 1] == ' ')                    //if are clear right and looking right thant we search to our right
            {
                if(previousAngle != tempAngle)                                          
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row, column+1, tempAngle);
            }
            
            else if ((tempAngle == -90 || tempAngle== 270) && maze[row + 1][column] == ' ') //if we are clear downa and looking down we search below us
            {
                if(previousAngle != tempAngle)                                          
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row+1, column, tempAngle);
            }
            
            else if ((tempAngle == -180 || tempAngle == 180) && maze[row][column - 1] == ' ') //if we are clear left and looking left we search to our left
            {
                if(previousAngle != tempAngle)                                          
                {
                    System.out.println("\nChanging angle to "+ (tempAngle)%360);
                }
                search(row, column-1, tempAngle);
            }

            if(trueChecker == true)                                                           //for all the methods that have called a search, when they get out of that search they will end up here after they get their child method back as true
            {
            return true;
            }
            
        }//end of our main angle for loop

        System.out.println("LEFT THE FOR LOOP!!! UH OH");// if we cannot find an apropriate place to go we will eventually end up here(this should not happen)
        return false;                                      //we return false based on the rubric


    }//end of search method
}//end of maze class
