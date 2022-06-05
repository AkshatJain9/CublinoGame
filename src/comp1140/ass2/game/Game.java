/*
 * AUTHORSHIP: Akshat Jain & Chris Kim & Justin Tieu
 * Other Works/Members Cited: N/A
 */
package comp1140.ass2.game;

import comp1140.ass2.base.*;

import java.util.ArrayList;
import java.util.LinkedList;

public abstract class Game implements Cloneable {
    protected BoardState board;
    protected Player turn;

    public Game () {
        this.board = new BoardState("PWa1Wb1Wc1Wd1We1Wf1Wg1va7vb7vc7vd7ve7vf7vg7");
        this.turn = Player.PLAYER1;
    }

    public Game (BoardState b, Player t) {
        this.board = b;
        this.turn = t;
    }

    public void setBoard(BoardState b) {
        board = b;
    }

    /**
     * constructs the board depending on the string
     * also sets the player
     * @param str gameString
     */
    public Game (String str) {
        board = new BoardState(str);
        turn = Character.isUpperCase(str.charAt(0)) ? Player.PLAYER1 : Player.PLAYER2;
    }

    /**
     * Switches the turn to the opposite player
     */
    public void switchTurn() {
        this.turn = this.turn.equals(Player.PLAYER2) ? Player.PLAYER1 : Player.PLAYER2;
    }

    /**
     * gets the owner of the dice
     * @return which player owns the dice
     */
    public Player getTurn () {
        return turn;
    }

    /**
     * gets the board from a game
     * @return the board state
     */
     public BoardState getBoard() {
        return board;
    }

    /**
     * returns an array of possible @see comp1140.ass2.base.Move
     * @return possible moves
     */
     public abstract ArrayList<ArrayList<Move>> getLegalMoves();

    /**
     * returns whether a move is valid within the context of the game state
     * @param m the move to inspect
     * @return whether it is valid
     */
     public boolean isLegalMove (Move m) {
         for (var moves : getLegalMoves()) {
             for (var move : moves) {
                 if (move.equals(m))
                     return true;
             }
         }
         return false;
     }

     public abstract int[] score();

    /**
     * tests for the variant's win condition
     * @return the outcome for player 1
     */
     public abstract Outcome hasWon();

    /**
     * Plays the given move to the board
     * @param m the move to play
     */
     public abstract void play (ArrayList<Move> m);

    // NOTE: variant specific isValid() rules go into the respective subclasses
    // *make sure to call the super isValid first* before overriding this method
    /**
     * Whether the piece placements are valid for *both* games
     * @return Whether this current game state is valid
     */
    public abstract boolean isValid ();

    /**
     * the lowercase first letter of the variant's name
     * eg. p for pur or c for contra
     * @return variant's first letter
     */
    public abstract char getVariantChar();

    /**
     * Generates a copy of the Game object seperate to original
     * @return Copy of gamestate
     */
    @Override
    public abstract Game clone();

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        // variant character
        out.append(getTurn() == Player.PLAYER1 ? Character.toUpperCase(getVariantChar()) : getVariantChar());

        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                Dice d = board.getAtIndex(x, y);
                if (d != null)
                    out.append(d);
            }
        }

        return out.toString();
    }
}
