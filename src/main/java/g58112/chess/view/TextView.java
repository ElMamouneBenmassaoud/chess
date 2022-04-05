/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58112.chess.view;

import g58112.chess.model.Color;
import g58112.chess.model.Model;
import g58112.chess.model.pieces.Piece;
import g58112.chess.model.Player;
import g58112.chess.model.Position;
import java.util.List;
import java.util.Scanner;

/**
 * this class provides us with the game displays
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

        String bienvenue = "CHESS";
        System.out.print("-".repeat(22) + "[");
        System.out.print(bienvenue);
        System.out.println("]" + "-".repeat(22));
        String bienvenueJoueurs = " ".repeat(11) + "Bienvenue aux deux joueurs.";
        System.out.println("_".repeat(51));
        System.out.println(bienvenueJoueurs);
        System.out.println("_".repeat(51));
    }

    @Override
    public void displayBoard() {
        int row = 7;
        int col = 0;
        System.out.println("----------------------------------------------------");
        for (int i = 8; 0 < i; i--) {
            System.out.print(i + "  |"); //affiche les numeros des lignes
            //affiche les differentes cases (occupé par pion blanc, noir) 
            //ou pas occupé 
            for (int j = 0; j < 8; j++) {
                if (col == 8) {
                    col = 0;
                    row--;
                }
                Position pos = new Position(row, col);
                Piece pawn = model.getPiece(pos);
                if (pawn == null) {
                    System.out.print("     |");  //case libre 
                } else {
                    if (pawn.getColor().equals(Color.BLACK)) {
                        System.out.print(" PN  |");    // case avec pion noir
                    } else {
                        System.out.print(" PB  |");   // case avec pion blanc
                    }
                }
                col++;
            }
            System.out.println();
            System.out.println("----------------------------------------------------");
        }
        System.out.println("      a     b     c     d     e     f     g     h");
    }

    @Override
    public void displayWinner() {
        if (model.isGameOver()) {
            Player winner = model.getOppositePlayer();
            System.out.println("Bien joué !");
            System.out.println(winner + "a gagné la partie !");
        }
    }

    @Override
    public void displayPlayer() {
        if (model.getCurrentPlayer().getColor().equals(Color.BLACK)) {
            System.out.println("c'est au tour du joueur BLACK de jouer:");
        } else {
            System.out.println("c'est au tour du joueur WHITE de jouer:");
        }
    }

    @Override
    public Position askPosition() {
        int row = lireEntierRange("Veuillez saisir le numéro de la ligne (entre 1 et 8)", 1, 8, "Le numéro de la ligne n'est pas valide") - 1;
        int column = stringToInt();
        Position newPos = new Position(row, column);
        return newPos;
    }

    /**
     * this method checks whether the keyboard entry is an integer or not
     *
     * @param message the message you receive before entering the keyboard
     * @return the value receipt
     */
    private int lireEntier(String message) {
        Scanner input = new Scanner(System.in);
        System.out.println(message);
        while (!input.hasNextInt()) {
            input.next();
            System.out.println("Le nombre saisi n’est pas un entier.");
            System.out.println(message);
        }
        return input.nextInt();
    }

    /**
     * read an integer between two bounds
     *
     * @param message the message you receive before entering the keyboard
     * @param min the minumum value
     * @param max the maximum value
     * @param exception the error message
     * @return the value receipt
     */
    private int lireEntierRange(String message, int min, int max, String exception) {
        int input = 0;
        do {
            input = lireEntier(message);
            if (input < min || input > max) {
                System.out.println(exception);
            }
        } while (input < min || input > max);
        return input;
    }

    /**
     * receive a letter that is included in the list
     *
     * @return the letter receipt
     */
    private String robusteString() {
        Scanner clavier = new Scanner(System.in);
        List<String> listeChar = List.of("a", "A", "b", "B", "c", "C", "d", "D", "e", "E", "f", "F", "g", "G", "h", "H");
        System.out.println("Veuillez saisir la lettre de la colonne (a à h)");
        String column = clavier.nextLine();
        while (!Character.isLetter(column.charAt(0)) || !listeChar.contains(column)) {
            System.out.println("Lettre non autorisée !");
            System.out.println("Veuillez saisir la lettre de la colonne (a à h):");
            column = clavier.nextLine();
        }

        return column;
    }

    /**
     * change the letter to an integer
     *
     * @return the integer
     */
    private int stringToInt() {
        int column;
        switch (robusteString()) {
            case "A", "a" ->
                column = 0;
            case "B", "b" ->
                column = 1;
            case "C", "c" ->
                column = 2;
            case "D", "d" ->
                column = 3;
            case "E", "e" ->
                column = 4;
            case "F", "f" ->
                column = 5;
            case "G", "g" ->
                column = 6;
            case "H", "h" ->
                column = 7;
            default -> {
                column = -1;
            }
        }
        return column;
    }

    @Override
    public void displayError(String message) {
        System.out.println(message);
    }

}
