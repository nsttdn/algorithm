package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get maze size and generate a random maze
        char[][] maze = {
                {'S', 'X', ' ', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X'},
                {'X', 'X', 'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
                {'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X'},
                {' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
                {' ', ' ', 'X', ' ', ' ', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
                {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X'},
                {'X', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X'},
                {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X'},
                {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', 'X'},
                {'X', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' '},
                {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'E'}
        };
        //printMaze(maze);

        // Get start and end points from the user
        int[] start = getPointFromUser(scanner, "start");
        int[] end = getPointFromUser(scanner, "end");

        // Set the start and end points in the maze
        maze[start[0]][start[1]] = 'S';
        maze[end[0]][end[1]] = 'E';

        // Choose the algorithm and solve the maze
        String answer = getAlgorithmChoice(scanner);

        if (answer.equalsIgnoreCase("IDS")) {
            solveMazeWithIDS(maze, start, end);
        } else if (answer.equalsIgnoreCase("A*")) {
            solveMazeWithAStar(maze);
        } else {
            System.out.println("Invalid choice. Please enter 'IDS' or 'A*'.");
        }

        scanner.close();
    }

    // Function to get maze size and generate a random maze
 //public static char[][] getMazeFromUser(Scanner scanner) {
 //    System.out.print("Enter the size of the maze (N x M): ");
 //    int rows = scanner.nextInt();
 //    int columns = scanner.nextInt();
 //    return generateRandomMaze(rows, columns);
 //}

    // Function to get a point (x, y) from the user
    public static int[] getPointFromUser(Scanner scanner, String pointName) {
        System.out.println("Enter the " + pointName + " point (x y):");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        return new int[] { x, y };
    }

    // Function to choose the algorithm
    public static String getAlgorithmChoice(Scanner scanner) {
        System.out.println("Do you need to compute with the IDS or A* algorithm?");
        return scanner.next();
    }

    // Function to solve the maze using the IDS algorithm
    public static void solveMazeWithIDS(char[][] maze, int[] start, int[] end) {
        MazeSolverIDS solver = new MazeSolverIDS(maze, start[0], start[1], end[0], end[1]);
        solver.solveMaze();
    }

    // Function to solve the maze using the A* algorithm
    public static void solveMazeWithAStar(char[][] maze) {
        AStar aStar = new AStar(maze);
        aStar.mainAStar();
    }

    public static char[][] generateRandomMaze(int rows, int columns) {
        char[][] maze = new char[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (Math.random() < 0.3) {
                    maze[i][j] = 'x'; // Set an obstacle (X) with a certain probability.
                } else {
                    maze[i][j] = ' '; // Leave it empty (passable) with another probability.
                }
            }
        }
        return maze;
    }
 //public static void printMaze(char[][] maze) {
 //    for (int i = 0; i < maze.length; i++) {
 //        for (int j = 0; j < maze[i].length; j++) {
 //            System.out.print(maze[i][j] + " ");
 //        }
 //        System.out.println();
 //    }
 //}
}

