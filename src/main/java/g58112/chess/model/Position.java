/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58112.chess.model;

/**
 * la classe Position sert a indiquer une position sur un plateau de jeu  
 * @author 58112
 */
public class Position {

    private int row;    //ligne
    private int column; //colonne

    /**
     * 
     * @param row la ligne de la position 
     * @param column la colonne de la position
     */
    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    /**
     * un getter qui sert obtenir la valeur de la ligne
     * @return un nombre entier qui représente la ligne de la position
     */
    public int getRow() {
        return row;
    }

    /**
     * un getter qui sert obtenir la valeur de la colonne
     * @return un nombre entier qui représente la colonne de la position
     */
    public int getColumn() {
        return column;
    }    
}
