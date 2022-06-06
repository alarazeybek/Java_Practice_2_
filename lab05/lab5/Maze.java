//********************************************************************
//  Maze.java       Author: Lewis/Loftus
//
//  Represents a maze of characters. The goal is to get from the
//  top left corner to the bottom right, following a path of 1s.
//********************************************************************

public class Maze
{
   private final int TRIED = 3;
   private final int PATH = 7;
   private final int PORTAL1 = 9;
   private final int PORTAL2 = 8;
   private final int PORTAL3 = 5;
   private final int INACTIVEPORTAL = 2;

   private int co_x=0;
   private int co_y=0;
   

   private int[][] grid_CLose1 = { {1,1,1,0,1,1,0,0,0,1,1,1,1},
                            {1,0,1,1,1,0,1,1,1,1,0,0,1},
                            {0,0,0,0,1,0,1,0,1,0,1,0,0},
                            {1,1,1,0,1,1,1,0,1,0,1,1,1},
                            {1,0,1,0,0,0,0,1,1,1,0,0,1},
                            {1,0,1,1,1,1,1,1,0,1,1,1,1},
                            {1,0,0,0,0,0,0,0,0,0,0,0,0},
                            {1,1,1,1,1,1,1,1,1,1,1,1,1} }; 

    private int[][] grid_ ={ {1,0,0,0,0,0},
                            {1,1,9,0,0,0},
                            {0,0,0,0,9,1}};

    private int[][] gridö = {{1,1,0,0,0,0},
                            {1,1,9,1,1,0},
                            {1,1,1,9,1,0},
                            {0,0,0,1,1,1}};

    private int[][] gridl = {{1,1,1,9,1,1},
                            {0,1,1,1,1,1},
                            {0,1,0,0,0,0},
                            {0,0,0,9,0,1},};

    private int[][] grid = {{1,9,0,9,1,1},
                            {0,0,0,0,0,8},
                            {0,0,0,1,0,0},
                            {0,0,0,0,0,0},
                            {8,5,0,0,5,1}};

   //-----------------------------------------------------------------
   //  Attempts to recursively traverse the maze. Inserts special
   //  characters indicating locations that have been tried and that
   //  eventually become part of the solution.
   //-----------------------------------------------------------------
   public boolean traverse (int row, int column)
   {
      boolean done = false;
      
      if (valid (row, column))
      {
        if(grid[row][column] == PORTAL1 || grid[row][column] == PORTAL2 || grid[row][column] == PORTAL3 ){
            portal(grid, row, column, grid[row][column]);
            row=co_x;
            column=co_y;
         }
         grid[row][column] = TRIED;  // this cell has been tried
         
         if (row == grid.length-1 && column == grid[0].length-1)
            done = true;  // the maze is solved
         else
         {
            done = traverse (row+1, column);     // down
            if (!done)
               done = traverse (row, column+1);  // right
            if (!done)
               done = traverse (row-1, column);  // up
            if (!done)
               done = traverse (row, column-1);  // left
         }

         if (done)  // this location is part of the final path
            grid[row][column] = PATH;
      }
      
      return done;
   }
   
   //-----------------------------------------------------------------
   //  Determines if a specific location is valid.
   //-----------------------------------------------------------------
   private boolean valid (int row, int column)
   {
      boolean result = false;
 
      // check if cell is in the bounds of the matrix
      if (row >= 0 && row < grid.length &&
          column >= 0 && column < grid[row].length)

         //  check if cell is not blocked and not previously tried
         if (grid[row][column] == 1 || grid[row][column] == PORTAL1 || grid[row][column] == PORTAL2 || grid[row][column] == PORTAL3){
            result = true;
         }

      return result;
   }

   //PART 2 HELPER method
   public void portal(int[][] mazeArray,int row,int column, int searchFor){
        mazeArray[row][column]=INACTIVEPORTAL;
        for(int i =0; i<mazeArray.length;i++){
            for(int j = 0; j<mazeArray[0].length;j++){
                if(mazeArray[i][j] == searchFor){
                    co_x=i;
                    co_y=j;
                    mazeArray[i][j]=INACTIVEPORTAL;
                }
            }
        } 
    }

   //-----------------------------------------------------------------
   //  Returns the maze as a string.
   //-----------------------------------------------------------------
   public String toString ()
   {
      String result = "\n";

      for (int row=0; row < grid.length; row++)
      {
         for (int column=0; column < grid[row].length; column++)
            result += grid[row][column] + "";
         result += "\n";
      }

      return result;
   }
}
