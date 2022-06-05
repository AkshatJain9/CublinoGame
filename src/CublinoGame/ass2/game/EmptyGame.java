/*
 * AUTHORSHIP: Akshat Jain & Chris Kim & Justin Tieu
 * Other Works/Members Cited: N/A
 */
package CublinoGame.ass2.game;

import CublinoGame.ass2.base.Move;
import CublinoGame.ass2.base.Outcome;

import java.util.ArrayList;

/**
 * used exclusively for replays
 */
public class EmptyGame extends Game {
    /**
     * returns an array of possible @see comp1140.ass2.base.Move
     *
     * @return possible moves
     */
    @Override
    public ArrayList<ArrayList<Move>> getLegalMoves() {
        return new ArrayList<>();
    }

    @Override
    public int[] score() {
        return new int[0];
    }

    /**
     * tests for the variant's win condition
     *
     * @return the outcome for player 1
     */
    @Override
    public Outcome hasWon() {
        return Outcome.ONGOING;
    }

    /**
     * Plays the given move to the board
     *
     * @param m the move to play
     */
    @Override
    public void play(ArrayList<Move> m) {

    }

    /**
     * Whether the piece placements are valid for *both* games
     *
     * @return Whether this current game state is valid
     */
    @Override
    public boolean isValid() {
        return false;
    }

    /**
     * the lowercase first letter of the variant's name
     * eg. p for pur or c for contra
     *
     * @return variant's first letter
     */
    @Override
    public char getVariantChar() {
        return 'r';
    }

    /**
     * Generates a copy of the Game object seperate to original
     *
     * @return Copy of gamestate
     */
    @Override
    public Game clone() {
        return null;
    }
}
