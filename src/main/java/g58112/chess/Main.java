/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58112.chess;

import g58112.chess.controller.Controller;
import g58112.chess.model.Game;
import g58112.chess.model.Model;
import g58112.chess.view.TextView;

/**
 * this class is used to play the game
 *
 * @author mamou
 */
public class Main {

    public static void main(String[] args) {
        Model game = new Game();
        Controller controller = new Controller(game, new TextView(game));
        controller.play();
    }

}
