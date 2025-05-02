import java.util.ArrayList;

public class MazeRunner {
    private String[][] maze;

    public MazeRunner(String[][] maze) {
        this.maze = maze;
    }


    public boolean inBounds(int row, int col) {
        return row >= 0 && col >= 0 && row < maze.length && col < maze[0].length;
    }


    public boolean goDown(int row, int col) {
        int newRow = row + 1;
        return inBounds(newRow, col) && maze[newRow][col].equals(".");
    }


    public boolean goUp(int row, int col) {
        int newRow = row - 1;
        return inBounds(newRow, col) && maze[newRow][col].equals(".");
    }


    public boolean goRight(int row, int col) {
        int newCol = col + 1;
        return inBounds(row, newCol) && maze[row][newCol].equals(".");
    }


    public boolean goLeft(int row, int col) {
        int newCol = col - 1;
        return inBounds(row, newCol) && maze[row][newCol].equals(".");
    }


    public boolean solveMaze(int row, int col, ArrayList<String> coords) {
        ArrayList<String> visited = new ArrayList<String>();
        visited.add("("+row+","+col+")");

        while (!(row == maze.length - 1 && col == maze[0].length - 1)){

            if(goUp(row,col)&&!visited.contains("("+(row-1)+","+col+")")){
                row--;
                visited.add("("+row+","+col+")");
            }
            else if(goDown(row,col)&&!visited.contains("("+(row+1)+","+col+")")){
                row++;
                visited.add("("+row+","+col+")");
            }

            else if(goRight(row,col)&&!visited.contains("("+row+","+(col+1)+")")){
                col++;
                visited.add("("+row+","+col+")");
            }

            else if(goLeft(row,col)&&!visited.contains("("+row+","+(col-1)+")")){
                col--;
                visited.add("("+row+","+col+")");
            }
            else {
                maze[row][col]="#";
                row = 0;
                col = 0;
                visited.clear();
                visited.add("(" + row + "," + col + ")");
                if(!goDown(row,col)&&!goLeft(row, col)&&!goUp(row, col)&&!goRight(row, col)){
                    return false;
                }
            }



    }
        for (int i = 0; i < visited.size(); i++) {
            coords.add(visited.get(i));
        }
return true;
    }


}