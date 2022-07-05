package eapli.base.agvmanagement.domain;

import eapli.base.warehousemanagement.domain.Aisle;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.base.warehousemanagement.domain.Dock;
import eapli.base.warehousemanagement.domain.Plant;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RoutePlanner {

    private final int warehouseLength;
    private final int warehouseWidth;
    private final boolean[][] visitedMatrix;

    static int[] dRow = {-1, 0, 0, 1};
    static int[] dCol = {0, -1, 1, 0};


    public RoutePlanner(Plant plant) {
        this.warehouseLength = (int) plant.length();
        this.warehouseWidth = (int) plant.width();
        this.visitedMatrix = warehouseMatrixWithObstacles(plant);
    }

    public Route shortestPathBetweenTwoPoints(Coordinates src, Coordinates dest) {
        return pathMoves(new int[warehouseLength][warehouseWidth], visitedMatrix, src, dest);
    }

    public List<Coordinates> canGo(Plant plant) {
        int minLen = 1;
        int minWi = 1;
        int maxLen = (int) (plant.length() / plant.square());
        int maxWi = (int) (plant.width() / plant.square());
        List<Aisle> aisleList = plant.aisles();
        List<Dock> docksList = plant.docks();
        List<Coordinates> total = new ArrayList<>();
        for (int i = minLen; i <= maxLen; i++) {
            for (int j = minWi; j <= maxWi; j++) {
                Coordinates coordinates = new Coordinates(String.valueOf(i), String.valueOf(j));
                total.add(coordinates);
            }
        }
        for (Aisle aisle : aisleList) {
            for (int i = (int) aisle.begin().length(); i <= (int) aisle.depth().length(); i++) {
                for (int j = (int) aisle.begin().width(); j <= (int) aisle.depth().width(); j++) {
                    Coordinates coordinates = new Coordinates(String.valueOf(i), String.valueOf(j));
                    total.remove(coordinates);
                }
            }
        }
        for (Dock dock : docksList) {
            for (int i = (int) dock.begin().length(); i <= (int) dock.depth().length(); i++) {
                for (int j = (int) dock.begin().width(); j <= (int) dock.depth().width(); j++) {
                    Coordinates coordinates = new Coordinates(String.valueOf(i), String.valueOf(j));
                    total.remove(coordinates);
                }
            }
        }
        return total;
    }

    public boolean[][] warehouseMatrixWithObstacles(Plant plant) {
        boolean[][] visited = new boolean[warehouseLength][warehouseWidth];
        for (Coordinates obstacle : canGo(plant)) {
            visited[(int) obstacle.length()][(int) obstacle.width()] = true;
        }
        return visited;
    }

    // Check if the given cell is valid or not
    public boolean isValid(int row, int col) {
        return (row >= 0) && (col >= 0) &&
                (row < warehouseLength) && (col < warehouseWidth);
    }


    public Route pathMoves(int[][] mat, boolean[][] visited, Coordinates src, Coordinates dest) {


        List<String> movementList = new ArrayList<>();
        List<Coordinates> pointList = new ArrayList<>();
        // Stores the distance for each
        // cell from the source cell
        int[][] d = new int[warehouseLength][warehouseWidth];
        int[][] moves = new int[warehouseLength][warehouseWidth];
        for (int[] dd : d)
            Arrays.fill(dd, -1);

        // Distance of source cell is 0
        d[(int) src.length()][(int) src.width()] = 0;

        // Initialize a visited array

        // Mark source cell as visited
        visited[(int) src.length()][(int) src.width()] = true;

        // Create a queue for BFS
        ArrayDeque<Node> q = new ArrayDeque<>();

        // Distance of source cell is 0
        Node s = new Node(src, 0);

        // Enqueue source cell
        q.addLast(s);

        // Keeps track of whether
        // destination is reached or not
        boolean ok = false;

        // Iterate until queue is not empty
        while (!q.isEmpty()) {
            // Deque front of the queue
            Node curr = q.removeFirst();
            Coordinates pt = curr.pt;

            // If the destination cell is
            // reached, then find the path
            if (pt.length() == dest.length() && pt.width() == dest.width()) {
                int xx = (int) pt.length(), yy = (int) pt.width();
                int dist = curr.dist;

                // Assign the distance of
                // destination to the
                // distance matrix
                d[(int) pt.length()][(int) pt.width()] = dist;
                System.out.println("Distance: ");
                System.out.println(dist);

                // Stores the smallest path

                // Iterate until source is reached
                while (xx != src.length() || yy != src.width()) {

                    // Append D
                    if (xx > 0 &&
                            d[xx - 1][yy] == dist - 1) {
                        moves[xx][yy] = 1;
                        movementList.add("Right");
                        pointList.add(new Coordinates(String.valueOf(xx), String.valueOf(yy)));
                        xx--;
                    }

                    // Append U
                    if (xx < warehouseWidth - 1 &&
                            d[xx + 1][yy] == dist - 1) {
                        moves[xx][yy] = 1;
                        movementList.add("Left");
                        pointList.add(new Coordinates(String.valueOf(xx), String.valueOf(yy)));
                        xx++;
                    }

                    // Append R
                    if (yy > 0 &&
                            d[xx][yy - 1] == dist - 1) {
                        moves[xx][yy] = 1;
                        movementList.add("Down");
                        pointList.add(new Coordinates(String.valueOf(xx), String.valueOf(yy)));
                        yy--;
                    }

                    // Append L
                    if (yy < warehouseWidth - 1 &&
                            d[xx][yy + 1] == dist - 1) {
                        moves[xx][yy] = 1;
                        movementList.add("Up");
                        pointList.add(new Coordinates(String.valueOf(xx), String.valueOf(yy)));
                        yy++;
                    }
                    dist--;
                }
                for (int i = 0; i < warehouseLength; i++) {
                    for (int j = 0; j < warehouseWidth; j++) {
                        System.out.print(moves[i][j] + ",");
                        //stringMatrix[i][j] = "Empty";
                    }
                    System.out.println();
                }

                ok = true;

                break;
            }

            // Explore all adjacent directions
            for (int i = 0; i < 4; i++) {
                int row = (int) (pt.length() + dRow[i]);
                int col = (int) (pt.width() + dCol[i]);

                // If the current cell is valid
                // cell and can be traversed

                if (isValid(row, col) &&
                        mat[row][col] == 0 &&
                        !visited[row][col]) {
                    // Mark the adjacent cells as visited
                    visited[row][col] = true;

                    // Enqueue the adjacent cells
                    Node adjCell = new Node(new Coordinates(String.valueOf(row), String.valueOf(col)), curr.dist + 1);
                    q.addLast(adjCell);

                    // Update the distance
                    // of the adjacent cells
                    d[row][col] = curr.dist + 1;
                }
            }
        }

        // If the destination
        // is not reachable
        if (!ok) {
            System.out.println("It is not possible to get to the destination. ");
        }

        return new Route(pointList, movementList, moves);
    }

    // Stores coordinates of
    // a cell and its distance
    static class Node {
        Coordinates pt;
        int dist;

        Node(Coordinates p, int dist) {
            this.pt = p;
            this.dist = dist;
        }

    }

}
