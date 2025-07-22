package Maze;

public abstract class Cell {

    private int row;
    private int col;

    private Maze maze;

    private Cell north;
    private Cell south;
    private Cell west;
    private Cell east;

    // constructor 

    public Cell( Cell north,Cell south, Cell west,Cell east){

        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
        
    }

   
    
}
