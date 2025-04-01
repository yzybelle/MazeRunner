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

    public boolean solveMaze(int row, int col, ArrayList<String> path) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path.add("(" + row + ", " + col + ")"+"--->");
            return true;
        }

        maze[row][col] = "#";


        if (goDown(row, col) && solveMaze(row + 1, col, path)&& inBounds(row+1,col)) {
            path.add(0, "(" + row + ", " + col + ")"+"--->");
            return true;
        }

        if (goRight(row, col) && solveMaze(row, col + 1, path)&&inBounds(row,col+1)) {
            path.add(0, "(" + row + ", " + col + ")"+"--->");
            return true;
        }

        if (goUp(row, col) && solveMaze(row - 1, col, path)&&inBounds(row-1,col)) {
            path.add(0, "(" + row + ", " + col + ")"+"--->");
            return true;
        }

        if (goLeft(row, col) && solveMaze(row, col - 1, path)&&inBounds(row,col-1)) {
            path.add(0, "(" + row + ", " + col + ")"+"--->");
            return true;
        }


        maze[row][col] = ".";
        return false;
    }


}