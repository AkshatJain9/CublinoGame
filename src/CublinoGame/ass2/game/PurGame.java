/*
 * AUTHORSHIP: Akshat Jain & Chris Kim & Justin Tieu
 * Other Works/Members Cited: N/A
 */
package CublinoGame.ass2.game;

import CublinoGame.ass2.base.*;
import CublinoGame.ass2.helpers.Position;

import java.util.ArrayList;
import java.util.Collections;

public class PurGame extends Game {
    public PurGame() {super();}
    public PurGame(BoardState b, Player t) {
        super(b, t);
    }
    public PurGame (String str) {
        super(str);
    }

    /**
     * tests for the variant's win condition
     *
     * @return true iff the dice placements are such that a win/draw condition is met
     */
    @Override
    public int[] score() {
        int P1Dice = 0;
        int P2Dice = 0;
        int P1Score = 0;
        int P2Score = 0;
        int[] scores = new int[2];
        for (int row = 0; row <= 6; row += 6) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    switch (board.getAtIndex(col,row).getTurn()) {
                        case PLAYER1 -> {
                            if (row == 6) {
                                P1Dice++;
                                P1Score += board.getAtIndex(col,row).getTop();
                            }
                        }
                        case PLAYER2 -> {
                            if (row == 0) {
                                P2Dice++;
                                P2Score -= board.getAtIndex(col,row).getTop();
                            }
                        }
                    }
                }
            }
        }
        if (P1Dice == 7 || P2Dice == 7) {
            if (P1Score + P2Score > 0) { scores[0] = 1;}
            else if (P1Score + P2Score < 0) { scores[0] = 2; }
            else scores[0] = 3;
        }
        scores[1] = P1Score + P2Score;
        return scores;
    }

    /**
     * tests for the variant's win condition
     *
     * @return the outcome for player 1
     */
    @Override
    public Outcome hasWon() {
        return switch (score()[0]) {
            case 0  -> Outcome.ONGOING;
            case 1  -> Outcome.WIN;
            case 2  -> Outcome.LOSE;
            case 3  -> Outcome.DRAW;
            default -> throw new RuntimeException();
        };
    }

    /**
     * Whether the piece placements are valid for *both* games
     *
     * @return Whether this current game state is valid
     */
    @Override
    public boolean isValid() {
        int P1Dice = 0;
        int P2Dice = 0;
        boolean P1finish = false;
        boolean P2finish = false;
        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null) {
                    switch (board.getAtIndex(col,row).getTurn()) {
                        case PLAYER1 -> P1Dice++;
                        case PLAYER2 -> P2Dice++;
                    }
                }
            }
            if (row == 0 && P2Dice == 7) P2finish = true;
            if (row == 5 && P1Dice == 0) P1finish = true;
        }
        return P1Dice == 7 && P2Dice == 7 && (!P1finish || !P2finish);
    }

    /**
     * Returns an ArrayList of possible @see comp1140.ass2.base.Move
     * @return possible moves given the current game position
     */
    @Override
    public ArrayList<ArrayList<Move>> getLegalMoves() {
        ArrayList<ArrayList<Move>> purMoves = new ArrayList<>();
        for (int row = 0; row <= 6; row++) {
            for (int col = 0; col <= 6; col++) {
                if (board.getAtIndex(col,row) != null && board.getAtIndex(col,row).getTurn().equals(this.turn)) {
                    // If the current player's turn's dice is present
                    Position current = new Position(col,row);
                    ArrayList<Position> locs  = current.getTiltPositions();
                    locs.addAll(current.getJumpPositions());
                    // Iterating over potential first moves
                    for (Position end : locs) {
                        Move m = new Move(current, end, this.turn);
                        if (board.jumpDice(m) || board.tiltDice(m)) {
                            ArrayList<Move> temp = new ArrayList<>(Collections.singletonList(m));
                            purMoves.add(temp);
                        }
                    }
                }
            }
        }
        // Now looking for only subsequent jump moves (see below)
        ArrayList<ArrayList<Move>> jumps = allJumps(purMoves);
        purMoves.addAll(jumps);
        return purMoves;
    }

    /**
     * Helper function to find all jump sequence of moves, implements breadth first search
     * @param purMoves All the positions after the first move (so only jumps are searched)
     * @return ArrayList of all jump sequences (as Moves) which are possible to be made
     */
    public ArrayList<ArrayList<Move>> allJumps(ArrayList<ArrayList<Move>> purMoves) {
        ArrayList<ArrayList<Move>> allJumps = new ArrayList<>();
        ArrayList<ArrayList<Move>> toCheck = new ArrayList<>(purMoves);
        // Iterative Breadth-First Search, toCheck mirrors 'stack' of paths to be checked
        while (toCheck.size() > 0) {
            int jsize = allJumps.size();
            // Record all locations that have already been visited so they aren't visited again
            for (ArrayList<Move> branch : toCheck) {
                Position currentEnd = branch.get(branch.size() - 1).getEnd();
                ArrayList<Position> visitedPos = new ArrayList<>();
                for (Move m : branch) {
                    visitedPos.add(m.getStart());
                }
                visitedPos.add(currentEnd);
                // Remove Dice so it can't jump over itself, store for re-insertion later
                Dice d = this.board.getAtPosition(branch.get(branch.size() - 1).getStart());
                this.board.removeDie(branch.get(branch.size() - 1).getStart());
                // Check if possible jump moves are valid and add to output-list if true
                for (Position newEnd : currentEnd.getJumpPositions()) {
                    Move m = new Move(currentEnd, newEnd, this.turn);
                    if (!(visitedPos.contains(newEnd)) && this.board.jumpDice(m)) {
                        ArrayList<Move> branchduple = new ArrayList<>(branch);
                        branchduple.add(m);
                        allJumps.add(branchduple);
                        visitedPos.add(newEnd);
                    }
                }
                this.board.insertDie(branch.get(branch.size() - 1).getStart(), d);
            }
            // Remove all lines that have been checked, add new lines found from iteration
            toCheck.clear();
            toCheck.addAll(allJumps.subList(jsize, allJumps.size()));
        }
        return allJumps;
    }

    @Override
    public char getVariantChar() {
        return 'p';
    }

    /**
     * Generates a copy of the Game object seperate to original
     *
     * @return Copy of gamestate
     */
    @Override
    public Game clone() {
        return new PurGame(toString());
    }

    /**
     * Given an array list of moves m, changes the board state, dice state and turn parameter within this class
     * If it is not a legal move (positionally) then throws an exception
     * It is assumed that m is already a tilt/jump, you just need to check if the positions are clear
     * and in the case of the jump, a dice exists in the intersection space
     */
    public void play(ArrayList<Move> moves) {
        for (Move m : moves) {
            if (board.jumpDice(m)) {
                board.applyJump(m);
                continue;
            }
            if (board.tiltDice(m)) {
                board.applyTilt(m);
                continue;
            }
            throw new RuntimeException();
        }
        switchTurn();
    }
}

