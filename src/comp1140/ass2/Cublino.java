package comp1140.ass2;

import comp1140.ass2.base.Dice;
import comp1140.ass2.game.ContraGame;
import comp1140.ass2.game.PurGame;
import comp1140.ass2.base.Move;

import java.util.ArrayList;
import java.util.Random;

public class Cublino {

    /**
     * Task 3:
     * Determine whether the input state is well formed or not.
     * Note: you don't have to consider whether the state is valid for this task.
     * A state is well formed if it has the following format:
     * [variant][dice]*
     * where [variant] and [dice] are replaced by the corresponding substrings below. Note that [dice]* means zero or
     * more repetitions of the [dice] substring.
     *
     * 1. [variant] The variant substring is a single character which is either an upper or lower case 'p' or 'c' - The
     * letter encodes which variant the of the rules the game is using and the case represents the turn of the current
     * player.
     *
     * 2. [dice] The dice substring contains three characters. The first character can be either an upper or lower case
     * letter in the range 'a' to 'x'. The letter encodes the orientation of the dice and the case encodes which player
     * the dice belongs two. The next two characters encode the position of the dice in the format [column][row] where
     * the column is one character in the range 'a' to 'g' and the row is one character in the range '1' to '7'.
     *
     * See the "Encoding Game State" section in the README for more details.
     *
     * @param state a string representing a game state
     * @return true if the input state is well formed, otherwise false
     */

    public static Boolean isStateWellFormed(String state) {
        if (state == null || !(state.length() % 3 == 1)) return false;
        if (!((state.toLowerCase()).charAt(0) == 'p' || (state.toLowerCase()).charAt(0) == 'c')) return false;
        for (int i = 1; i+3 <= state.length(); i+=3) {
            try {
                Dice d = new Dice(state.substring(i,i+3));
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }

    /**
     * Task 4:
     * Determine whether the input state is valid.
     * A game state is valid if it satisfies the conditions below. Note that there are some shared conditions and
     * some conditions which are specific to each variant of the game. For this task you are expected to check states
     * from both variants.
     *
     * [Both Variants]
     * 1. The game state is well formed.
     * 2. No two dice occupy the same position on the board.
     *
     * [Pur]
     * 1. Each player has exactly seven dice.
     * 2. Both players do not have all seven of their dice on the opponent's end of the board (as the game would have
     * already finished before this)
     *
     * [Contra]
     * 1. Each player has no more than seven dice.
     * 2. No more than one player has a dice on the opponent's end of the board.
     *
     * @param state a string representing a game state
     * @return true if the input state is valid, otherwise false
     */
    public static Boolean isStateValid(String state) {
        if (state == null || state.length() < 1) return false;
        if (Character.toLowerCase(state.charAt(0)) == 'p') {
            try {
                PurGame pgame = new PurGame(state);
                return pgame.isValid();
            } catch (Exception e) {
                return false;
            }
        }
        if (Character.toLowerCase(state.charAt(0)) == 'c') {
            try {
                ContraGame cgame = new ContraGame(state);
                return cgame.isValid();
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Task 6:
     * Determine whether a state represents a finished Pur game, and if so who the winner is.
     *
     * A game of Cublino Pur is finished once one player has reached the opponent's end of the board with all seven of
     * their dice. Each player then adds the numbers facing upwards on their dice which have reached the opponent's end
     * of the board. The player with the highest total wins.
     *
     * You may assume that all states input into this method will be of the Pur variant and that the state will be
     * valid.
     *
     * @param state a Pur game state
     * @return 1 if player one has won, 2 if player two has won, 3 if the result is a draw, otherwise 0.
     */
    public static int isGameOverPur(String state) {
        PurGame pgame = new PurGame(state);
        return pgame.score()[0];
    }

    /**
     * Task 7:
     * Determine whether a single step of a move is valid for a given Pur game.
     * A step is encoded as follows: [position][position]. The [position] substring is a two character string encoding a
     * position on the board. The first position represents the starting position of the dice making the step and the
     * second position represents the ending position of the dice making the step. You may assume that the step strings
     * input into this method are well formed according to the above specification.
     *
     * A step is valid if it satisfies the following conditions:
     * 1. It represents either a tilt or a jump of a dice.
     * 2. The ending position of the step is not occupied.
     * 3. The step moves towards the opponent's end of the board or horizontally (along its current row).
     * 3. If it is a jump step, there is a dice in the position which is jumped over.
     *
     * You may assume that all states input into this method will be of the Pur variant and that the state will be
     * valid.
     *
     * @param state a Pur game state
     * @param step a string representing a single step of a move
     * @return true if the step is valid for the given state, otherwise false
     */

    public static Boolean isValidStepPur(String state, String step) {
        if (state == null || step == null) return false;
        PurGame pg = new PurGame(state);
        Move m = new Move(step, pg.getTurn());
       return (pg.getBoard().jumpDice(m) || pg.getBoard().tiltDice(m));
    }

    /**
     * Task 8:
     * Determine whether a move (sequence of steps) is valid for a given game.
     * A move is encoded as follows [position]*. The [position] substring encodes a position on the board. This encoding
     * lists a sequence of positions that a dice will have as it makes a move. Note that [position]* means zero or more
     * repetitions of the [position] substring. You may assume that the move strings input into this method are well
     * formed according to the above specification.
     *
     * A move is valid if it satisfies the following conditions:
     * 1. The starting position of the move contains a dice belonging to the player who's turn it is.
     * 2. All steps in the move are valid.
     * 3. The move contains at least one step.
     * 4. Only the first step may be a tipping step.
     * 5. The starting and ending positions of the moved dice are different.
     *
     * You may assume that all states input into this method will be of the Pur variant and that the state will be
     * valid.
     *
     * @param state a Pur game state
     * @param move a string representing a move
     * @return true if the move is valid for the given state, otherwise false
     */
    public static Boolean isValidMovePur(String state, String move) {
        if (move == null || move.length() < 4) return false;
        PurGame pGame = new PurGame(state);
        ArrayList<Move> moves = new ArrayList<>();
        for (int i = 0; i < move.length() - 3; i += 2) {
            Move m = new Move(move.substring(i,i+4), pGame.getTurn());
            moves.add(m);
        }
        return pGame.getLegalMoves().toString().contains(moves.toString());
    }
    /**
     * Task 9:
     * Given a Pur game state and a move to play, determine the state that results from that move being played.
     * If the move ends the game, the turn should be the player who would have played next had the game not ended. If
     * the move is invalid the game state should remain unchanged.
     *
     * You may assume that all states input into this method will be of the Pur variant and that the state will be
     * valid.
     *
     * @param state a Pur game state
     * @param move a move being played
     * @return the resulting state after the move has been applied
     */
    public static String applyMovePur(String state, String move) {
        PurGame pg = new PurGame(state);
        ArrayList<Move> moves = new ArrayList<>();
        for (int i =0; i<move.length() - 3; i+=2) {
            Move m = new Move(move.substring(i, i + 4), pg.getTurn());
            moves.add(m);
        }
        pg.play(moves);
        return pg.toString();
    }

    /**
     * Task 11:
     * Given a valid Pur game state, return a valid move.
     * This task imposes an additional constraint that moves returned must not revisit positions previously occupied as
     * part of the move (ie. a move may not contain a jumping move followed by another jumping move back to the previous
     * position).
     *
     * You may assume that all states input into this method will be of the Pur variant and that the state will be
     * valid.
     *
     * @param state a Pur game state
     * @return a valid move for the current game state.
     */
    public static String generateMovePur(String state) {
        PurGame pGame = new PurGame(state);
        Random rand = new Random();
        ArrayList<ArrayList<Move>> options = pGame.getLegalMoves();
        int i = rand.nextInt(options.size());
        ArrayList<Move> choice = options.get(i);
        StringBuilder out = new StringBuilder(choice.get(0).getStart().toString());
        for (Move m : choice) {
            out.append(m.getEnd().toString());
        }
        return out.toString();
    }

    /**
     * Task 14a:
     * Determine whether a state represents a finished Contra game, and if so who the winner is.
     *
     * A player wins a game of Cublino Contra by reaching the opponent's end of the board with one of their dice.
     *
     * You may assume that all states input into this method will be of the Contra variant and that the state will be
     * valid.
     *
     * @param state a Contra game state
     * @return 1 if player one has won, 2 if player two has won, otherwise 0.
     */
    public static int isGameOverContra(String state) {
        ContraGame cGame = new ContraGame(state);
        return cGame.score()[0];
    }

    /**
     * Task 14b:
     * Given a Contra game state and a move to play, determine the state that results from that move being played.
     * If the move ends the game, the turn should be the player who would have played next had the game not ended. If
     * the move is invalid the game state should remain unchanged. See the README for what constitutes a valid Contra
     * move and the rules for updating the game state.
     *
     * You may assume that all states input into this method will be of the Contra variant and that the state will be
     * valid.
     *
     * @param state a Contra game state
     * @param move a move being played
     * @return the resulting state after the move has been applied
     */
    public static String applyMoveContra(String state, String move) {
        ContraGame cgame = new ContraGame(state);
        Move m = new Move(move, cgame.getTurn());
        ArrayList<Move> mlist = new ArrayList<>();
        mlist.add(m);
        cgame.play(mlist);
        return cgame.toString();
    }

    /**
     * Task 14c:
     * Given a valid Contra game state, return a valid move.
     *
     * You may assume that all states input into this method will be of the Contra variant and that the state will be
     * valid.
     *
     * @param state the Pur game state
     * @return a move for the current game state.
     */
    public static String generateMoveContra(String state) {
        ContraGame cGame = new ContraGame(state);
        ArrayList<ArrayList<Move>> moves = cGame.getLegalMoves();
        Random random = new Random();
        int i = random.nextInt(moves.size());
        return moves.get(i).get(0).toString();
    }
}
