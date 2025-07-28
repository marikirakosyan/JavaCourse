package Maze;

import java.util.List;

public abstract class Cell {

    private int row;
    private int col;

    private Maze maze;

    protected Cell north;
    protected Cell south;
    protected Cell west;
    protected Cell east;

    // constructor 

    public Cell( Maze maze, int row, int col ){

        this.maze = maze;
        this.row = row;
        this.col = col;
        
    }


    // abstract must be overrided and doea not have body can only be impl in abstract class
    public abstract List<Opening> find(Cell from);

    public void setNorth(Cell c){
        this.north = c;
    }

    public void setSouth(Cell c){
        this.south = c;
    }

    public void setWest(Cell c){
        this.west = c;
    }

    public void setEast(Cell c){
        this.east = c;
    }

    public int getCol(){
        return col;
    }

    public int getRow(){
        return row;
    }



   
    
}
