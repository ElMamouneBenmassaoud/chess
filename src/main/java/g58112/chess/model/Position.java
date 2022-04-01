/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58112.chess.model;

/**
 * the Position class is used to indicate a position on a game board
 *
 * @author 58112
 */
public class Position {

    private int row;    //line
    private int column; //column

    /**
     * the constructor allows to define the row and the column of the position
     *
     * @param row position line
     * @param column position column
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    /**
     * a getter which serves to get the row value
     *
     * @return an integer that represents the line of the position
     */
    public int getRow() {
        return row;
    }

    /**
     * a getter which serves to get the value of the column
     *
     * @return an integer that represents the column of the position
     */
    public int getColumn() {
        return column;
    }

    /**
     * this method allows you to move a piece depending on the direction
     *
     * @param dir the direction in which the piece will move
     * @return la ligne
     */
    public Position next(Direction dir) {
        return new Position(this.row + dir.getDeltaRow(), this.column + dir.getDeltaColumn());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.row;
        hash = 29 * hash + this.column;
        return hash;
    }

    /**
     * the equals method allows you to check if 2 positions are equal if they
     * have the same rows and the same column
     *
     * @param obj the object i want to compare
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.row != other.row) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }

}
