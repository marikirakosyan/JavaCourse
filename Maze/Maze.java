package Maze;
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Maze {

    // two dimensional array
    private Cell[][] gridCells;

    // store rows and colomomns

    private int rows;
    private int columns;

    public Maze(String filepath) throws FileNotFoundException{

        Scanner scanner = new Scanner(new File(filepath));
        rows = scanner.nextInt(); // reads next int
        columns = scanner.nextInt();
        scanner.nextLine();

        gridCells = new Cell[rows][columns];
        for(int i=0;i<rows;i++){
            String line =  scanner.nextLine();
            for(int j=0; j<columns;j++){
                char currentChar = line.charAt(j);
                if(currentChar == '.'){
                    if(j==0 || i == 0 || j == columns-1 || i == rows-1){
                        gridCells[i][j]= new Opening(this,  i,  j);
                    }else{
                        gridCells[i][j]= new WhiteCell( this,  i,  j);
                    }
                }else if (currentChar == '#'){
                    gridCells[i][j]= new BlackCell(this,  i,  j);
                }
            }
            
        }
        for(int i=0;i<rows;i++){
            
            for(int j=0; j<columns;j++){
                if(i != 0){
                    gridCells[i][j].setNorth(gridCells[i-1][j]);
                }

                if(i != rows-1){
                    gridCells[i][j].setSouth(gridCells[i+1][j]);
                }

                if(j != columns-1){
                    gridCells[i][j].setEast(gridCells[i][j+1]);
                }

                if(j != 0){
                    gridCells[i][j].setWest(gridCells[i][j-1]);
                }

                
                
            }
        
            
        }


    }

    public List<Opening> find(int row, int col) { 

        return gridCells[row][col].find(null);
 
    }






    @Override
    public String toString(){
        String string = "";
        for(int i=0;i<rows;i++){
            for(int j=0; j<columns;j++){
                string += gridCells[i][j].toString(); // cells toString
            }
            string += "\n";
        }

        return string;
    }
    
}



