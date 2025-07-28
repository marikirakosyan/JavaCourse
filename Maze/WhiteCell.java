package Maze;

import java.util.ArrayList;
import java.util.List;



public class WhiteCell extends Cell {

    // when we call the contructor , we need to call the superclass constructor
    public WhiteCell( Maze maze, int row, int col){
        super( maze,  row,  col);
    }

    public  List<Opening>  find(Cell from) { 
        ArrayList<Opening> list = new ArrayList<>();

       
        if(north != from && north != null){
            list.addAll(north.find(this));
        }
        if(south != from && south != null){
            list.addAll(south.find(this));
        }
        if(east != from && east != null){
            list.addAll(east.find(this));
        }
        if(west != from && west != null){
            list.addAll(west.find(this));
        }


        return list;
    }


    @Override
    public String toString() {
        return ".";
    }
    
}
