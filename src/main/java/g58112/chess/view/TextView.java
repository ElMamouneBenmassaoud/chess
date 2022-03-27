/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58112.chess.view;

import g58112.chess.model.Model;
import g58112.chess.model.Position;

/**
 *
 * @author mamou
 */
public class TextView implements View {
    
    private Model model;

    public TextView(Model model) {
        this.model = model;
    }

    
    @Override
    public void displayTitle() {
        System.out.println("Bienvenue au jeu des échecs !");
    }

    @Override
    public void displayBoard() {
    }

    @Override
    public void displayWinner() {
    }

    @Override
    public void displayPlayer() {
    }

    @Override
    public Position askPosition() {
        return null;
    }

    @Override
    public void displayError(String message) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
