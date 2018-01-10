/**
 * Created by david on 09/01/2018.
 */
public interface Logic {
    PossibleMove getPossibleMoves(Board board, char playerID);
    void getEmptyCell(Board board, int i, int j, int k, int n, char playerID, PossibleMove pMove);
    int switchCells(Board board, int i, int j, PossibleMove pMove, char playerID);
}
