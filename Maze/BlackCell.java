package Maze;

import java.util.ArrayList;
import java.util.List;

public class BlackCell extends Cell {

    public BlackCell( Maze maze, int row, int col){
        super( maze,  row,  col);
    }
    
    // black cell does not have any opening, base case
    public  List<Opening> find(Cell from) { 
         return new ArrayList<>();
    }


    @Override
    public String toString() {
        return "#";
    }
    
}
