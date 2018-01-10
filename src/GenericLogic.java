import java.util.Vector;
/**
 * Created by david on 09/01/2018.
 */
public class GenericLogic implements Logic {

    @Override
    public PossibleMove getPossibleMoves(Board board, char playerID) {
        int k, n; // indexes


        PossibleMove pMove = new PossibleMove(); // possible move struct

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                k = i; n = j;

                //upper left
                if (i > 1 && j > 1) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);

                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k - 1, n - 1) != playerID
                    && board.getValueAtIndexes(k - 1, n - 1) != ' ' && k > 1 && n > 1) {
                        Cell newCell = new Cell(k - 1, n - 1);
                        pCells.add(newCell);
                        k--; n--;
                        if (board.getValueAtIndexes(k - 1, n - 1) == playerID) {
                            getEmptyCell(board, i, j, k - 1, n - 1, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // up
                if (i > 1) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k - 1, n) != playerID
                    && board.getValueAtIndexes(k - 1, n) != ' ' && k > 1) {

                        Cell newCell = new Cell(k-1, n);
                        pCells.add(newCell);
                        k--;
                        if (board.getValueAtIndexes(k - 1, n) == playerID) {
                            getEmptyCell(board, i, j, k - 1, n, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // upper right
                if (i > 1 && j < board.getSize() - 2 ) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k - 1, n + 1) != playerID
                    && board.getValueAtIndexes(k - 1, n + 1) != ' ' && k > 1
                    && (n < (board.getSize() - 2))) {
                        Cell newCell = new Cell(k - 1,n + 1);
                        pCells.add(newCell);
                        k--; n++;
                        if (board.getValueAtIndexes(k - 1, n + 1) == playerID) {
                            getEmptyCell(board, i, j, k - 1, n + 1, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // left
                if (j > 1) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k, n - 1) != playerID
                    && board.getValueAtIndexes(k, n - 1) != ' ' && n > 1) {

                        Cell newCell = new Cell(k, n-1);
                        pCells.add(newCell);
                        n--;
                        if (board.getValueAtIndexes(k, n - 1) == playerID) {
                            getEmptyCell(board, i, j, k, n - 1, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // right
                if (j < board.getSize() - 2) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k, n + 1) != playerID
                    && board.getValueAtIndexes(k, n + 1) != ' ' && n < (board.getSize() - 2)) {

                        Cell newCell = new Cell(k, n+1);
                        pCells.add(newCell);
                        n++;
                        if (board.getValueAtIndexes(k, n + 1) == playerID) {
                            getEmptyCell(board, i, j, k, n + 1, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // lower left
                if (i < board.getSize() - 2 && j > 1) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);

                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k + 1, n - 1) != playerID
                    && board.getValueAtIndexes(k + 1, n - 1) != ' '
                    && k < (board.getSize() -2) && n > 1) {
                        Cell newCell = new Cell(k + 1,n - 1);
                        pCells.add(newCell);
                        k++; n--;
                        if (board.getValueAtIndexes(k + 1, n - 1) == playerID) {
                            getEmptyCell(board, i, j, k + 1, n - 1, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // down
                if (i < board.getSize() - 2) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k + 1, n) != playerID
                    && board.getValueAtIndexes(k + 1, n) != ' '
                    && k < (board.getSize() - 2)) {
                        Cell newCell = new Cell(k+1, n);
                        pCells.add(newCell);
                        k++;
                        if (board.getValueAtIndexes(k + 1, n) == playerID) {
                            getEmptyCell(board, i, j, k+1, n, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                    k = i; n = j;
                }
                // lower right
                if (i < board.getSize() - 2 && j < board.getSize() - 2) {
                    // temp vector
                    Vector<Cell> pCells = new Vector<Cell>();
                    Cell thisCell = new Cell(k, n);
                    pCells.add(thisCell);
                    while (board.getValueAtIndexes(i, j) == ' '
                    && board.getValueAtIndexes(k + 1, n + 1) != playerID
                    && board.getValueAtIndexes(k + 1, n + 1) != ' '
                    && k < (board.getSize() - 2) && n < (board.getSize() - 2)) {
                        Cell newCell = new Cell(k + 1, n + 1);
                        pCells.add(newCell);
                        k++; n++;
                        if (board.getValueAtIndexes(k + 1, n + 1) == playerID) {
                            getEmptyCell(board, i, j, k + 1, n + 1, playerID, pMove);
                            pMove.addChangeableCells(pCells);
                        }
                    }
                    //pCells.clear();
                }
            }
        }

        // any possible moves?
        if (!pMove.getMoves().isEmpty()) {
            pMove.setPossible(true);
        } else {
            pMove.setPossible(false);
        }

        return pMove;
    }

    @Override
    public void getEmptyCell(Board board, int i, int j, int k, int n, char playerID, PossibleMove pMove) {
        // possible move for 'X'
        if (playerID == 'X' && board.getValueAtIndexes(k, n) == 'X') {
            Cell cell = new Cell(i, j);
            pMove.addPossibleMove(cell);
        }
        // possible move for 'O'
        if (playerID == 'O' && board.getValueAtIndexes(k, n) == 'O') {
            Cell cell = new Cell(i, j);
            pMove.addPossibleMove(cell);
        }
    }

    @Override
    public int switchCells(Board board, int i, int j, PossibleMove pMove, char playerID) {
        int x, y, u, w, z = 0;
        Cell cell = new Cell(i, j);
        int count = 0;

        // run through all vectors of changeable cells
        for (int s = 0; s < pMove.getChangeableCells().size(); s++) {
            if (!pMove.getChangeableCells().elementAt(s).isEmpty()
                    && cell.equals(pMove.getChangeableCells().elementAt(s).elementAt(0))) {
                char firstCell = board.getValueAtIndexes(pMove.getChangeableCells().elementAt(s).elementAt(0).getX()
                        , pMove.getChangeableCells().elementAt(s).elementAt(0).getY());

                char secondCell = board.getValueAtIndexes(pMove.getChangeableCells().elementAt(s).elementAt(1).getX()
                        , pMove.getChangeableCells().elementAt(s).elementAt(1).getY());

                // if chosen move by user is in a specific vector
                if (firstCell == ' ' && secondCell != playerID) {
                    count += pMove.getChangeableCells().elementAt(s).size() - 1;
                    // change all cells in the a specific vector
                    for (int n = 1; n < (int) pMove.getChangeableCells().elementAt(s).size(); n++) {
                        z = s;
                        x = pMove.getChangeableCells().elementAt(s).elementAt(n).getX();
                        y = pMove.getChangeableCells().elementAt(s).elementAt(n).getY();
                        board.setCell(x, y, playerID);
                    }
                }
            }
        }

        u = pMove.getChangeableCells().elementAt(z).elementAt(0).getX();
        w = pMove.getChangeableCells().elementAt(z).elementAt(0).getY();
        board.setCell(u, w, playerID);
        return count + 1;
    }
}
