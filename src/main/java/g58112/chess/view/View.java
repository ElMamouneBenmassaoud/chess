/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package g58112.chess.view;

import g58112.chess.model.Position;

/**
 *
 * @author mamou
 */
public interface View {
    /**
     * 
     */
    public void displayTitle();
    
    /**
     * 
     */
    public void displayBoard();
    
    /**
     * 
     */
    public void displayWinner();
    
    /**
     * 
     */
    public void displayPlayer();
    
    /**
     * 
     * @return 
     */
    public Position askPosition();
    
    /**
     * 
     * @param message 
     */
    public void displayError(String message);
}
