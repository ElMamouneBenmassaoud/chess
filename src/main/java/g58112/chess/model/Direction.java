/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package g58112.chess.model;

/**
 * this enum represents the movement of a piece
 *
 * @author g58112
 */
public enum Direction {
    NW(1, -1), //North west
    N(1, 0), //North 
    NE(1, 1), //North east
    W(0, -1), //West 
    E(0, 1), //East
    SW(-1, -1), //South west
    S(-1, 0), //South
    SE(-1, 1); //South east

    private int deltaRow;
    private int deltaColumn;

    /**
     * The constructor will take care of initializing the values ​​of deltaRow
     * and deltaColumn
     *
     * @param deltaRow represents moving from one line to another in our plan
     * @param deltaColumn represents moving from one column to another in our
     * plan
     */
    private Direction(int deltaRow, int deltaColumn) {
        this.deltaRow = deltaRow;
        this.deltaColumn = deltaColumn;
    }

    /**
     * this getter is used to get the displacement value for the rows
     *
     * @return the displacement value for the rows
     */
    public int getDeltaRow() {
        return deltaRow;
    }

    /**
     * this getter is used to get the displacement value for the column
     *
     * @return the displacement value for the column
     */
    public int getDeltaColumn() {
        return deltaColumn;
    }

}
