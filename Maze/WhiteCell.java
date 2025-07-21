package Maze;

public class WhiteCell extends Cell {

    // when we call the contructor , we need to call the superclass constructor
    public WhiteCell(){
        super();

    }

    @Override
    public String toString() {
        return ".";
    }
    
}
