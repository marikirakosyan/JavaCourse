package Maze;

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
                    gridCells[i][j]= new WhiteCell();
                }else if (currentChar == '#'){
                    gridCells[i][j]= new BlackCell();
                }
            }
            
        }
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



