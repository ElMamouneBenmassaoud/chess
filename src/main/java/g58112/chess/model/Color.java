/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package g58112.chess.model;

/**
 * Classe qui représente la couleur d'un joueur, d'une case ou d'une pièce du jeu 
 * @author 58112
 */
public enum Color {
    
    WHITE,  //White color
    BLACK;  // Black color
    
    /**
     * Cette méthode renvoie une couleur opposée d'une couleur donnée 
     * @return La couleur opposée a celle qui est fournie
     */
    public Color opposite(){
        if(this == WHITE){
            return BLACK;
        }
        else{
            return WHITE;
        }
    }
}
