/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package g58112.chess.view;

import g58112.chess.model.Player;
import g58112.chess.model.Position;

/**
 *
 * @author mamou
 */
public interface View {

    /**
     * Displays a title and a welcome message to players.
     */
    public void displayTitle();

    /**
     * Displays the game board.
     */
    public void displayBoard();

    /**
     * Shows the winning player.
     */
    public void displayWinner();

    /**
     * Displays a message inviting the current player (white or black) to play.
     */
    public void displayPlayer();

    /**
     * Requests a valid position on the board from the user.
     * @return The position received by the user
     */
    public Position askPosition();

    /**
     * displays the error message passed in parameter.
     * @param message
     */
    public void displayError(String message);
    
    /**
     * displays a message informing the next player of a check situation.
     */
    public void displayCheck();
    
    /**
     * displays a message informing of the end of the game and identifying the winner.
     * @param winner the player who won the game
     */
    public void displayMat(Player winner);
    
    /**
     * displays a message informing of a stalemate situation.
     */
    public void displayStaleMat();
}
