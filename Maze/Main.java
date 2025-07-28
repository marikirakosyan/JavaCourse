package Maze;

import java.io.FileNotFoundException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            Maze maze = new Maze("/Users/maria/Desktop/ACA/Maze/maze.txt");
            System.out.println(maze);
            List<Opening> list = maze.find(1,2);
            for(Opening opening: list){
                System.out.println("row: " + opening.getRow() + " and, column: "+ opening.getCol());
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        /* 

        try {
            Maze maze1 = new Maze("/Users/maria/Desktop/ACA/Maze/mazeRecurs1.txt");
            System.out.println(maze1);
        } catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        try {
            Maze maze2 = new Maze("/Users/maria/Desktop/ACA/Maze/mazeRecurs2.txt");
            System.out.println(maze2);
        } catch (FileNotFoundException e2) {
            // TODO Auto-generated catch block
            e2.printStackTrace();
        }

       */ 
        
    }
    
}
