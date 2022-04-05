package g58112.chess.controller;

import g58112.chess.model.Model;
import g58112.chess.model.Position;
import g58112.chess.view.View;

/**
 * this class will allow us to make the link the link between the view and the
 * model
 *
 * @author mamou
 */
public class Controller {

    private View view;
    private Model model;

    /**
     * initializes the controller with the view and model passed as parameters.
     *
     * @param model the main logic of the application
     * @param view the presentation and interaction with the user
     */
    public Controller(Model model, View view) {
        this.view = view;
        this.model = model;
    }

    /**
     * This method drives the game.
     */
    public void play() {
        boolean gameIsOver = false;
        view.displayTitle();
        model.start();

        while (!gameIsOver) {
            view.displayBoard();

            movePiece();

            gameIsOver = model.isGameOver();
        }
        view.displayWinner();
    }

    /**
     * this private method is used to ask for the start and end position, in
     * case of illegal argument exception it displays me the error message and
     * restarts my movePiece() method.
     */
    private void movePiece() {
        try {
            view.displayPlayer();

            System.out.println("La position de départ:");
            Position oldPos = view.askPosition();
            System.out.println("La position d'arrivée:");
            Position newPos = view.askPosition();
            model.movePiecePosition(oldPos, newPos);
        } catch (IllegalArgumentException e) {
            view.displayError(e.getMessage());
            movePiece();
        }
    }
}
