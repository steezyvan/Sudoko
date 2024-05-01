package sudoku.computationlogic;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import org.w3c.dom.ls.LSOutput;
import sudoku.problemdomain.Coordinates;
import sudoku.problemdomain.SudokuGame;

import javax.crypto.spec.PSource;
import java.sql.SQLOutput;

public class GameGenerator {
    public static int[][] getNewGameGrid() {
        return unsolveGame(getSolvedGame));
    }

    private static int[][] unsolveGame(int[][] solvedGame) {
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solveableArray = new int[GRID_BOUNDARY][GRID_BOUNDARY];

        while (solvable == false) {
            SudokuUtilities, copySudokuArrayValues(solvedGame, SovlabelArray);

            int index = 0;

            while (index < 40) {
                int xCoordinate = random.nextInt(GRID_BOUNDARY);
                int yCoordinate = random.nextInt(GRID_BOUNDARY);

            if (solveableArray[xCoordinate][yCoordinate] != 0) {
                solveableArray[xCoordinate][yCoordinate] = 0;
                index++;
            }
        }

            int[][] toBeSolved = new int[GRID_BOUNDARY][GRID_BOUNDARY];
            SudokuUtilities.copySudokuArrayValues(solvableArray, toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);
    }

        return solveableArray;

    }


    private static int [][] getSolvedGame()) {
       Random random = new Random(System.currentTimeMillis());
       int[][] newGrid = new int[GRID_BOUNDARY][GRID_BOUNDARY];

       for(int value = 1; value <= GRID_BOUNDARY; value++) {
           int allocations = 0;
           int interrupt = 0;

           List<Coordinates> allocTracker = new ArrayList<>();

           int attempts = 0;

           while(allocations < GRID_BOUNDARY) {
               if(interrupt > 200) {
                   allocTracker.forEach(coord -> {
                       newGrid[coord.getX()][coord.getY()] = 0;
                   });

                   interrupt = 0;
                   allocations = 0;
                   allocTracker.clear();
                   attempts++ ;

                   if(attempts > 500) {
                       clearArray(newGrid);
                       attempts = 0;
                       value = 1;
                   }
               }

               int xCoordinate = random.nextInt(GRID_BOUNDARY);
               int yCoordinate = random.nextInt(GRID_BOUNDARY);

               if (newGrid[xCoordinate][yCoordinate] == 0) {
                    newGride[xCoordinate][yCoordinate] = value;

                    if(GameLogic.sudokuIsInvalid(newGrid)){
                        newGrid[xCoordinate][yCoordinate] = 0;
                        interrupt++;
                    } else {
                        allocTracker.add(new Coordinates(xCoordinate, yCoordinate));
                        allocations++;
                    }
               }
           }
       }
       return newGrid;
    }
}
