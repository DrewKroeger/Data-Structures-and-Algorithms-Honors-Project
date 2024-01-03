package honorsProject;

public class MazeDriver 
{
    public static void main(String[] args)
 {
 String[] mazeStrings = new String[]
 {
 "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX", //0
 "XXXXXXXXXXXX                XX", //1
 "XXXX         XXXXXXXXXXXX XXXX", //2 
 "XXXX XXXXX XXXXXXX         XXX", //3 
 "XXXX XXXXX XXXXXXX XXXXXXXXXXX", //4
 "XXXX       XXXXXXXXXXXXXXXXXXX", //5
 "XXXX XXXXX               XXXXX", //6
 "     XXXXX XXXXXXXXXXXXX XXXXX", //7
 "X XXXXXXXX XXXXXXXXXXXXX XXXXX", //8 
 "X XXXXXXXXXXXXX      XXX   XXX", //9
 "X   XXXXXXXXXXXXXX   XXXXX XXX", //10
 "XXX XXXXXXXXXXXXXX   XXXXX XXX", //11
 "XXX          XXXXX     XXXXXXX", //12
 "XXX XXXXXXXX XXXXXXXXX XXXXXXX", //13
 "XXX XXXXXXXX XXXXXXXXX XXXXXXX", //14
 "XXX     XXXX XXXXXXXXX        ", //15
 "XXX XXX XXXX XXXXXXXXX XXXXXXX", //16
 "XXX     XXXX XXXXXXXXX XXXXXXX", //17
 "XXXXXXXXXXXX           XXXXXXX", //18
 "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"  //20
};
 Maze maze = new Maze(mazeStrings);
 maze.search(7, 0, 0); // start row, start col, start angle
 } // end main
}
