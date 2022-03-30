/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58112.chess.controller;

import g58112.chess.model.Model;
import g58112.chess.model.Position;
import g58112.chess.view.View;

/**
 *
 * @author mamou
 */
public class Controller {

    private View view;
    private Model model;

    /**
     * initializes the controller with the view and model passed as parameters.
     * @param model Le model
     * @param view  La vue
     */
    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }
    
    /**
     * This method drives the game.
     */
    public void play(){
        boolean gameIsOver = false;
        view.displayTitle();
        model.start();
        
        while (!gameIsOver){
            view.displayBoard();
            view.displayPlayer();
            System.out.println("La position de départ:");
            Position oldPos = view.askPosition();
            System.out.println("La position d'arriver:");
            Position newPos = view.askPosition();
            model.movePiecePosition(oldPos, newPos);
            if(model.isGameOver()){
                gameIsOver = true;
            }
        }
        view.displayWinner();
    }

}
