package honorsProject;

public class MazeCopyPartialSuccess
{
    public int rows;
    public int columns;
    public double angle;
    public char [][] maze;
    public static final int LOWER_ROW_BOUND = -1;   //these variable are actually out of bounds
    public static final int LOWER_COLUMN_BOUND = -1;
    public static final int UPPER_ROW_BOUND = 20;
    public static final int UPPER_COLUMN_BOUND = 30;

    public MazeCopyPartialSuccess(String[] stringArray)
    {
        this.rows = stringArray.length;
        this.columns = stringArray[0].length();
        this.maze = new char[rows][columns];
        for (int i=0;i<rows;i++)
        {
            for(int j = 0; j<columns;j++)
            {
                maze[i][j] = stringArray[i].charAt(j);
            }
        }
        for (int i=0;i<rows;i++)
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
    }
    
    public boolean search(int row, int column, double angle)
    {
        if (row < LOWER_ROW_BOUND || row >= UPPER_ROW_BOUND-1)
        {
            System.out.println("Left maze at (" + row + "," + column + ")" );
            return true;
        }

        if(column < LOWER_COLUMN_BOUND || column >= UPPER_COLUMN_BOUND-1)
        {
            System.out.println("Left maze at (" + row + "," + column + ")" );
            return true;
        }

        maze[row][column] = '1';
        for (int i=0;i<rows;i++)
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
        System.out.println();
        System.out.println();
        System.out.print("(" + row + "," + column + ")");

        if (maze[row][column] == 'X')
        {
            return false;
        }
        


        int [] angleArr = {90,0,-90,180};
        for(int i = 0; i<4 ; i++)
        {
        int tempAngle = angleArr[i];
            if (tempAngle == 90 && maze[row - 1][column] == ' ') 
            {
                System.out.println("change angle to 90");
                row = row-1;
                angle=tempAngle;
                search(row, column, angle);
            } 
            
            else if (tempAngle == 0 && maze[row][column + 1] == ' ') 
            {
                System.out.println("change angle to 0");
                column = column +1;
                angle= tempAngle;
                search(row, column, angle);
            } 
            
            else if (tempAngle == -90 && maze[row + 1][column] == ' ') 
            {
                System.out.println("change angle to -90");
                row = row +1;
                angle = tempAngle;
                search(row, column, angle);
            } 
            
            else if (tempAngle == 180 && maze[row][column - 1] == ' ') 
            {
                System.out.println("change angle to 180");
                column = column -1;
                angle = tempAngle;
                search(row, column, angle);
            }
        }
        
        return false;
    }//end of search method
}
