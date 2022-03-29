/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package g58112.chess.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mamou
 */
public class Game implements Model {

    private Board board;
    private Player white;
    private Player black;
    private Player currentPlayer;

    public Game() {
        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
        board = new Board();
    }

    @Override
    public void start() {
        for (int i = 0; i < 8; i++) {
            board.setPiece(new Piece(Color.WHITE), new Position(board.getInitialPawnRow(Color.WHITE), i));
        }
        for (int j = 0; j < 8; j++) {
            board.setPiece(new Piece(Color.BLACK), new Position(board.getInitialPawnRow(Color.BLACK), j));
        }
        currentPlayer = white;
    }

    @Override
    public Piece getPiece(Position pos) {
        return board.getPiece(pos);
    }

    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    @Override
    public Player getOppositePlayer() {
        Player oppositePlayer = black;
        if (currentPlayer == black) {
            oppositePlayer = white;
        }
        return oppositePlayer;
    }

    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        boolean isCurrentPlayerPosition = false;
        if (board.getPiece(pos).getColor() == currentPlayer.getColor()) {
            isCurrentPlayerPosition = true;
        }
        return isCurrentPlayerPosition;
    }

    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if (!board.contains(oldPos) || !board.contains(newPos)) {
            throw new IllegalArgumentException("la position n'existe pas sur l'échequier");
        }

        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("La position de départ ne contient pas de pièce");
        }

        if (!isCurrentPlayerPosition(oldPos)) {
            throw new IllegalArgumentException("la pièce n'appartient pas au joueur actuel");
        }

        if (!getPossibleMoves(oldPos).contains(newPos)) {
            throw new IllegalArgumentException("La position jouée n'est pas valide");
        }

        if(!isGameOver()) {
            board.setPiece(getPiece(oldPos), newPos);
            board.dropPiece(oldPos);
            currentPlayer = getOppositePlayer();
        }
    }

    @Override
    public boolean isGameOver() {
        List<Position> currentPos = board.getPositionOccupiedBy(currentPlayer);
        int i = 0;
        while (getPossibleMoves(currentPos.get(i)).isEmpty() && i < currentPos.size()) {
            i++;
        }
        return i == currentPos.size();
    }

    @Override
    public List<Position> getPossibleMoves(Position position) {
        Piece piece = board.getPiece(position);
        return piece.getPossibleMoves(position, board);
    }

}
