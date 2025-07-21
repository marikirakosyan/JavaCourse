package Maze;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        try {
            Maze maze = new Maze("/Users/maria/Desktop/ACA/Maze/maze.txt");
            System.out.println(maze);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        


    }
    
}
