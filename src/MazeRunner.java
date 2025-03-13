import java.util.ArrayList;

public class MazeRunner {
    private String[][] maze;

    public MazeRunner(String[][] maze){
        this.maze = maze;
    }

    public boolean deadEnd(String next){
        if (next=="#"){
            return true;
        }
        return false;
    }

    public boolean goDown(String[][] data, ArrayList<String> coords){

    }

    public boolean goRight(String[][] data, ArrayList<String> coords, int row){
        
    }
}
