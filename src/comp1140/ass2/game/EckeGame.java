/*
 * AUTHORSHIP: Akshat Jain
 * Other Works/Members Cited: N/A
 */
package comp1140.ass2.game;

import comp1140.ass2.base.BoardState;
import comp1140.ass2.base.Move;
import comp1140.ass2.base.Outcome;
import comp1140.ass2.base.Player;
import comp1140.ass2.helpers.Position;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Aim of the game is to get both dice to other opponent's corners 1v1 battles only
 */
public class EckeGame extends Game {
    public EckeGame() {super();}
    public EckeGame(BoardState b, Player t) { super(b, t);}
    public EckeGame(String str) {super(str);}

    /**
     * returns an array of possible @see comp1140.ass2.base.Move
     * @return possible moves
     */
    @Override
    public ArrayList<ArrayList<Move>> getLegalMoves() {
        ArrayList<ArrayList<Move>> legalMoves = new ArrayList<>();
        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    if (board.getAtIndex(col,row).getTurn().equals(this.turn)) {
                        Position current = new Position(col,row);
                        ArrayList<Position> ends = current.getTiltPositions();
                        ends.addAll(current.getDiagonalTiltPositions());
                        ends.addAll(current.getJumpPositions());
                        ends.addAll(current.getDiagonalJumpPositions());
                        for (Position end : ends) {
                            Move m = new Move(current,end,this.turn);
                            ArrayList<Move> innerMoves = new ArrayList<>(Collections.singletonList(m));
                            legalMoves.add(innerMoves);
                        }
                    }
                }
            }
        }
        legalMoves.removeIf(m -> !(board.tiltDice(m.get(0))) && !(board.jumpDice(m.get(0)))
                && !(board.diagonalTilt(m.get(0))) && !(board.diagonalJump(m.get(0))));
        return legalMoves;

    }

    /**
     * tests for the variant's win condition
     *
     * @return true iff the dice placements are such that a win/draw condition is met
     */
    @Override
    public int[] score() {
        int[] status = {0};
        boolean whiteLeft = false;
        boolean whiteRight = false;
        boolean blackLeft = false;
        boolean blackRight = false;
        int whiteDie = 0;
        int blackDie = 0;
        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    if (board.getAtIndex(col,row).getTurn() == Player.PLAYER1) {
                        whiteDie++;
                        if (row == 6 && col == 0) blackLeft = true;
                        if (row == 6 && col == 6) blackRight = true;
                    }
                    else if (board.getAtIndex(col,row).getTurn() == Player.PLAYER2) {
                        blackDie++;
                        if (row == 0 && col == 0) whiteLeft = true;
                        if (row == 0 && col == 6) whiteRight = true;
                    }

                }
            }
        }
        if (blackDie < 2 || (blackLeft && blackRight)) {
            status[0] = 1;
            return status;
        }
        if (whiteDie < 2 || (whiteLeft && whiteRight)) {
            status[0] = 2;
            return status;
        }
        return status;
    }

    /**
     * tests for the variant's win condition
     *
     * @return the outcome for player 1
     */
    @Override
    public Outcome hasWon() {
        return switch (score()[0]) {
            case 1  -> Outcome.WIN;
            case 2  -> Outcome.LOSE;
            case 3  -> Outcome.DRAW;
            default -> Outcome.ONGOING;
        };
    }

    /**
     * Plays the given move to the board
     *
     * @param m the move to play
     */
    @Override
    public void play(ArrayList<Move> m) {
        Move move = m.get(0);
        if (board.diagonalTilt(move)) {
            board.applyDiagonalTilt(move);
        }
        else if (board.tiltDice(move)) {
            board.applyTilt(move);
        }
        else if (board.diagonalJump(move) || board.jumpDice(move)) {
            board.applyJump(move);
        } else if (board.tiltDice(move))
            board.applyTilt(move);
        else if (board.jumpDice(move))
            board.applyJump(move);

        if (!move.getEnd().equals(new Position(0, 0)) && !move.getEnd().equals(new Position(6, 0)) &&
                !move.getEnd().equals(new Position(0, 6)) &&!move.getEnd().equals(new Position(6, 6))) {
            eckeBattle(move.getEnd());
        }
        switchTurn();
    }


    /**
     * Applies a variation of Contra battle (only 1v1s)
     * @param end The end location of a move
     */
    public void eckeBattle(Position end) {
        ArrayList<Position> losingDice = new ArrayList<>();
        ArrayList<Position> opponentDice = board.getOpponentDicePosEcke(end);
        for (Position p : opponentDice) {
            if (board.getAtPosition(p).getTop() < board.getAtPosition(end).getTop()) {
                losingDice.add(p);
            }
            if (board.getAtPosition(p).getTop() > board.getAtPosition(end).getTop()) {
                board.removeDie(end);
                return;
            }
        }
        for (Position removal : losingDice) board.removeDie(removal);
    }

    /**
     * Whether the piece placements are valid for *both* games
     *
     * @return Whether this current game state is valid
     */
    @Override
    public boolean isValid() {
        boolean whiteLeft = false;
        boolean whiteRight = false;
        boolean blackLeft = false;
        boolean blackRight = false;
        int whiteDie = 0;
        int blackDie = 0;
        for (int row = 0; row <= 6; row += 6) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    if (board.getAtIndex(col,row).getTurn() == Player.PLAYER1) {
                        whiteDie++;
                        if (row == 6 && col == 0) blackLeft = true;
                        if (row == 6 && col == 6) blackRight = true;
                    }
                    else {
                        blackDie++;
                        if (row == 0 && col == 0) whiteLeft = true;
                        if (row == 0 && col == 6) whiteRight = true;
                    }

                }
            }
        }
        return (!(blackDie < 2 && whiteDie < 2) && !(whiteLeft && whiteRight && blackLeft && blackRight));
    }

    /**
     * the lowercase first letter of the variant's name
     * eg. p for pur or c for contra and e for ecke
     *
     * @return variant's first letter
     */
    @Override
    public char getVariantChar() {
        return 'e';
    }

    /**
     * Generates a copy of the Game object seperate to original
     *
     * @return Copy of gamestate
     */
    @Override
    public Game clone() {
        return new EckeGame(toString());
    }
}
