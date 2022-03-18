/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package g58112.chess.model;

/**
 * Class that represents the color of a player, space, or game piece 
 * @author 58112
 */
public enum Color {
    
    WHITE,  //White color
    BLACK;  // Black color
    
    /**
     * This method returns an opposite color of a given color
     * @return This method returns an opposite color of a given color
     */
    public Color opposite(){
        if(this == WHITE){
            return BLACK;
        }
        return WHITE;     
    }
}
