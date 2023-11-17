package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;



public class MainTest {
    static char[][] labyrinthAStar = {
            {'S', ' ', ' ', ' ', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X'},
            {'X', ' ', 'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X'},
            {' ', ' ', 'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
            {' ', ' ', 'X', ' ', ' ', ' ', 'X', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', 'X', ' ', 'X', ' ', 'X', 'X'},
            {'X', ' ', ' ', ' ', 'X', ' ', 'X', ' ', 'X', 'X', 'X', 'X'},
            {'X', ' ', 'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', 'X', 'X'},
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' '},
            {' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E'},
            {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' '},
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '}
    };
    static char[][] resultLabirinthAStar= {
            {'S', '+', '+', '+', 'X', ' ', 'X', 'X', ' ', 'X', 'X', 'X'},
            {'X', ' ', 'X', '+', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', 'X', '+', 'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X'},
            {' ', ' ', 'X', '+', 'X', 'X', 'X', ' ', ' ', ' ', ' ', 'X'},
            {' ', ' ', 'X', '+', '+', '+', 'X', 'X', 'X', 'X', ' ', 'X'},
            {'X', ' ', 'X', 'X', 'X', '+', 'X', ' ', 'X', ' ', 'X', 'X'},
            {'X', ' ', ' ', ' ', 'X', '+', 'X', ' ', 'X', 'X', 'X', 'X'},
            {'X', ' ', 'X', 'X', 'X', '+', '+', '+', '+', '+', 'X', 'X'},
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', ' ', 'X', '+', '+', '+'},
            {' ', ' ', 'X', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', 'E'},
            {' ', ' ', 'X', ' ', 'X', ' ', 'X', ' ', ' ', ' ', ' ', 'X'},
            {'X', ' ', ' ', ' ', 'X', 'X', 'X', ' ', 'X', ' ', ' ', ' '},
            {'X', ' ', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', ' '}
    };

    char[][] labyrinthIDS = {
            {' ', ' ', 'x', ' ', ' ', 'S', 'x', 'x', ' ', ' '},
            {' ', ' ', ' ', 'x', ' ', ' ', ' ', ' ', ' ', ' '},
            {'x', 'x', 'x', ' ', ' ', 'x', ' ', 'x', ' ', ' '},
            {' ', 'x', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' '},
            {' ', ' ', 'x', 'x', 'x', ' ', ' ', 'x', ' ', ' '},
            {'x', 'x', ' ', 'x', 'x', ' ', ' ', ' ', ' ', 'x'},
            {' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' '},
            {' ', ' ', 'x', 'x', ' ', ' ', ' ', ' ', 'x', 'x'},
            {'x', ' ', 'x', ' ', 'E', ' ', ' ', ' ', ' ', ' '}
    };


    char[][] resultLabirinthIDS ={
            {' ', ' ', 'x', '+', '+', '+', 'x', 'x', '+', '+'},
            {' ', ' ', ' ', 'x', '+', '+', '+', '+', '+', '+'},
            {'x', 'x', 'x', '+', '+', 'x', ' ', 'x', '+', '+'},
            {' ', 'x', '+', '+', '+', '+', 'x', '+', '+', '+'},
            {' ', ' ', 'x', 'x', 'x', '+', '+', 'x', '+', '+'},
            {'x', 'x', ' ', 'x', 'x', '+', '+', '+', '+', 'x'},
            {' ', ' ', 'x', '+', 'x', '+', '+', '+', '+', '+'},
            {' ', ' ', 'x', '+', '+', '+', 'x', 'x', 'x', '+'},
            {' ', ' ', 'x', 'x', '+', '+', '+', '+', 'x', 'x'},
            {'x', ' ', 'x', ' ', 'E', '+', '+', '+', ' ', ' '}
    };

    char[][] labyrinthAStar2 = {
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
    char[][] resultLabirinthAStar2 = labyrinthAStar2;
    char[][] labyrinthIDS2 = {
            {' ', ' ', 'x', ' ', 'x', 'S', 'x', 'x', ' ', ' '},
            {' ', ' ', ' ', 'x', 'x', 'x', 'x', ' ', ' ', ' '},
            {'x', 'x', 'x', ' ', ' ', 'x', ' ', 'x', ' ', ' '},
            {' ', 'x', ' ', ' ', ' ', ' ', 'x', ' ', ' ', ' '},
            {' ', ' ', 'x', 'x', 'x', ' ', ' ', 'x', ' ', ' '},
            {'x', 'x', ' ', 'x', 'x', ' ', ' ', ' ', ' ', 'x'},
            {' ', ' ', 'x', ' ', 'x', ' ', ' ', ' ', ' ', ' '},
            {' ', ' ', 'x', ' ', ' ', ' ', 'x', 'x', 'x', ' '},
            {' ', ' ', 'x', 'x', ' ', ' ', ' ', ' ', 'x', 'x'},
            {'x', ' ', 'x', ' ', 'E', ' ', ' ', ' ', ' ', ' '}
    };
    char[][] resultLabyrinthIDS2 = labyrinthIDS2;

    int[] startLabirintIDS = {0, 5};
    int[] endLabirintIDS = {9, 4};

    @Test
    public void testA() {
        Main.solveMazeWithAStar(MainTest.labyrinthAStar);
        assertArrayEquals(MainTest.resultLabirinthAStar, MainTest.labyrinthAStar);
    }
    @Test
    public void testB(){
        Main.solveMazeWithIDS(labyrinthIDS, startLabirintIDS, endLabirintIDS);
        assertArrayEquals(resultLabirinthIDS, labyrinthIDS);
    }
    @Test
    public void testC() {
        Main.solveMazeWithAStar(labyrinthAStar2);
        assertArrayEquals(resultLabirinthAStar2, labyrinthAStar2);
    }
    @Test
    public void testD() {
        Main.solveMazeWithIDS(labyrinthIDS2, startLabirintIDS, endLabirintIDS);
        assertArrayEquals(resultLabyrinthIDS2, labyrinthIDS2);
    }
}
