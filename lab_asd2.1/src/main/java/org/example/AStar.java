package org.example;

import java.util.*;

public class AStar {
    static char[][] labyrinth ;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public AStar(char[][] labyrinth){
        this.labyrinth = labyrinth;
    }


    public void mainAStar(){
        Node start = null, end = null;

        for (int i = 0; i < labyrinth.length; i++) {
            for (int j = 0; j < labyrinth[0].length; j++) {
                if (labyrinth[i][j] == 'S') {
                    start = new Node(i, j);
                } else if (labyrinth[i][j] == 'E') {
                    end = new Node(i, j);
                }
            }
        }

        ArrayList<Node> path = findPath(start, end);

        if (path != null) {
            markPath(labyrinth, path);
            printMaze(labyrinth);
        } else {
            //System.out.println("No path found.");
            //labyrinth = null;
        }
    }
    public ArrayList<Node> findPath(Node start, Node end) {
        PriorityQueue<Node> openList = new PriorityQueue<>(Comparator.comparingInt(node -> node.f));
        Set<Node> closedSet = new HashSet<>();
        Map<Node, Node> cameFrom = new HashMap<>();
        Map<Node, Integer> gScore = new HashMap<>();

        gScore.put(start, 0);
        start.g = 0;
        start.h = heuristic(start, end);
        openList.add(start);

        while (!openList.isEmpty()) {
            Node current = openList.poll();

            if (current.equals(end)) {
                return reconstructPath(cameFrom, current);
            }

            closedSet.add(current);

            for (int[] dir : directions) {
                int newX = current.x + dir[0];
                int newY = current.y + dir[1];
                Node neighbor = new Node(newX, newY);

                if (!isValid(newX, newY) || closedSet.contains(neighbor) || this.labyrinth[newX][newY] == 'X') {
                    continue;
                }

                int tentativeGScore = gScore.get(current) + 1;

                if (!openList.contains(neighbor) || tentativeGScore < gScore.get(neighbor)) {
                    cameFrom.put(neighbor, current);
                    gScore.put(neighbor, tentativeGScore);
                    neighbor.g = tentativeGScore;
                    neighbor.h = heuristic(neighbor, end);
                    openList.add(neighbor);
                }
            }
        }
        return null;
    }
    public static ArrayList<Node> reconstructPath(Map<Node, Node> cameFrom, Node current) {
        ArrayList<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = cameFrom.get(current);
        }
        Collections.reverse(path);
        return path;
    }

    public static int heuristic(Node a, Node b) {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
    }

    public boolean isValid(int x, int y) {
        return x >= 0 && x < this.labyrinth.length && y >= 0 && y < this.labyrinth[0].length;
    }

    public static void markPath(char[][] labyrinth, ArrayList<Node> path) {
        for (Node node : path) {
            if (labyrinth[node.x][node.y] != 'S' && labyrinth[node.x][node.y] != 'E') {
                labyrinth[node.x][node.y] = '+';
            }
        }
    }
    public static void printMaze(char[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j] + " ");
            }
            System.out.println();
        }
    }

}
