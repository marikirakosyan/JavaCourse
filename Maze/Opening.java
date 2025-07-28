package Maze;

import java.util.ArrayList;
import java.util.List;

public class Opening extends WhiteCell{
    

    public Opening( Maze maze, int row, int col){
        super( maze,  row,  col);
    }
  
    public  List<Opening> find(Cell from) { 
       ArrayList list = new ArrayList<Opening>() ;
       list.add(this);
       list.addAll(super.find(from));

       return list;
 
    }



    
}
