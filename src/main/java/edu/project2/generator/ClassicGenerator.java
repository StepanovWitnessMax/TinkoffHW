package edu.project2.generator;

import edu.project2.Cell;
import edu.project2.Coordinate;
import edu.project2.Maze;
import edu.project2.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class ClassicGenerator implements GeneratorInterface {

    public Maze generateMazeFromTemplate(Maze maze) {
        int height = maze.getHeight();
        int width = maze.getWidth();
        Cell[][] field = maze.getGrid();

        Stack<Coordinate> stack = new Stack<>();
        HashSet<Coordinate> visited = new HashSet<>();
        visited.add(new Coordinate(1, 1));
        stack.push(new Coordinate(1, 1));

        while (!stack.empty()) {
            Coordinate current = stack.pop();
            List<Coordinate> neighbours = getNeighbours(height, width, visited, current);

            if (neighbours.isEmpty()) {
                continue;
            } else if (neighbours.size() > 1) {
                stack.push(current);
            }

            Random randomGenerator = new Random();
            int nextIdx = randomGenerator.nextInt(neighbours.size());
            Coordinate next = neighbours.get(nextIdx);

            field[(next.row() + current.row()) / 2][(next.col() + current.col()) / 2] =
                new Cell((next.row() + current.row()) / 2, (next.col() + current.col()) / 2, Type.PASSAGE);

            visited.add(next);
            stack.push(next);
        }

        return new Maze(height, width, field);
    }

}
