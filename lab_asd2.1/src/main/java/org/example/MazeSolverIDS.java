package org.example;

import java.util.Stack;

public class MazeSolverIDS {
    private char[][] maze;
    private boolean[][] visited;
    private int startX, startY, endX, endY;
    private int[][] directions = { {1, 0}, {-1, 0}, {0, 1}, {0, -1} }; // Possible moves: down, up, right, left

    public MazeSolverIDS(char[][] maze, int startX, int startY, int endX,int  endY) {
        this.maze = maze;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;
        this.visited = new boolean[maze.length][maze[0].length];
    }

    public boolean solveMaze() {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {startX, startY});

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            if (x == endX && y == endY) {
                return true; // Path found
            }

            if (isValidMove(x, y)) {
                visited[x][y] = true;
                maze[x][y] = '+';

                for (int[] dir : directions) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    if (isValidCoordinate(newX, newY) && !visited[newX][newY]) {
                        stack.push(new int[] {newX, newY});
                    }
                }
            }
        }

        return false; // No path found
    }

    private boolean isValidMove(int x, int y) {
        return isValidCoordinate(x, y) && maze[x][y] != 'x';
    }

    private boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length;
    }
}
