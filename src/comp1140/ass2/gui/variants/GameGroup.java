/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.variants;

import comp1140.ass2.base.Dice;
import comp1140.ass2.gui.Viewer;
import comp1140.ass2.gui.tools.GuiBase;
import comp1140.ass2.gui.viewables.BoardViewer;
import comp1140.ass2.gui.viewables.BoardViewer2D;
import comp1140.ass2.gui.viewables.BoardViewer3D;
import comp1140.ass2.helpers.Position;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.Box;
import javafx.scene.shape.Rectangle;

/**
 * Viewer class for game/drawable game instance
 * interfaces directly with Board
 */
public class GameGroup extends Group {
    protected final VariantBase base;

    //private final BoardViewer3D boardGroup;
    private final BoardViewer boardGroup;
    public BoardViewer getBoardGroup() {
        return boardGroup;
    }

    protected final PreviewSquare selectedDiceSquare;
    protected final Group validSquares;

    public GameGroup(VariantBase base) {
        this.base = base;
        boardGroup = GuiBase.is3DSupported()
                ? new BoardViewer3D(base.getHost().getTexturePool(), base.getGame().getBoard(), base.getHost().settingsStore.showNumbers)
                : new BoardViewer2D(base.getHost().getTexturePool(), base.getGame().getBoard());

        // move the 2D board to the center sort of
        if (!GuiBase.is3DSupported()) {
            boardGroup.setTranslateX(100);
            boardGroup.setTranslateY(100);
        }

        boardGroup.setOnObjClick(pos -> base.getController().handlePlayerInput(pos, VariantController.ObjectType.DICE));

        getChildren().add (boardGroup);

        getChildren().add (selectedDiceSquare = new PreviewSquare(Color.LAWNGREEN));
        selectedDiceSquare.setVisible(false);

        getChildren().add(validSquares = new Group());
    }

    /**
     * update the drawable instance
     */
    public void update(Dice selectedDice) {
        boardGroup.setBoard(base.getGame().getBoard());
        boardGroup.update();

        // draw the valid moves
        validSquares.getChildren().clear();

        if (selectedDice == null) {
            selectedDiceSquare.setVisible(false);
        } else {
            // draw the selection area
            selectedDiceSquare.setVisible(true);
            var pos = selectedDice.getPosition();
            selectedDiceSquare.setTranslateX(pos.getX() * Viewer.TILESIZE);
            selectedDiceSquare.setTranslateZ(pos.getY() * Viewer.TILESIZE);

            // draw the legal move spots
            for (var spots : base.getController().getLegalMoves(base.getController().getMoveCount())) {
                for (var spot : spots) {
                    if (spot.getStart().equals(selectedDice.getPosition())) {
                        var p = new Position(spot.getEnd().getX() * Viewer.TILESIZE, spot.getEnd().getY() * Viewer.TILESIZE);
                        Node square2;
                        if (GuiBase.is3DSupported()) {
                            // 3D preview
                            square2 = new PreviewSquare(p, spot.getEnd(), Color.DEEPSKYBLUE);
                        } else {
                            // 2D preview
                            square2 = new Rectangle(spot.getEnd().getX() * GuiBase.TILESIZE + boardGroup.getTranslateX(),
                                    (6 - spot.getEnd().getY()) * GuiBase.TILESIZE + boardGroup.getTranslateY(),
                                    GuiBase.TILESIZE, GuiBase.TILESIZE);
                            square2.setOnMouseClicked(mouseEvent ->
                                    base.getController().handlePlayerInput
                                            (new Position(spot.getEnd().getX(), spot.getEnd().getY()),
                                            VariantController.ObjectType.TILE));
                            var rsq2 = (Rectangle)square2;
                            rsq2.setFill(Color.DEEPSKYBLUE);
                        }
                        validSquares.getChildren().add(square2);
                    }
                }
            }
        }
    }

    /**
     * highlight indicating special positions on the board
     */
    private class PreviewSquare extends Box {
        static final int SPACING = 20;
        static final int THICKNESS = 5;

        public PreviewSquare (Color colour) {
            super (Viewer.TILESIZE - SPACING, THICKNESS, Viewer.TILESIZE - SPACING);
            setTranslateY((float)GuiBase.TILESIZE / 3);

            // set material
            var mat = new PhongMaterial();
            mat.setDiffuseColor(colour);
            setMaterial(mat);
        }

        public PreviewSquare(Position p, Color colour) {
            this (colour);
            setTranslateX(p.getX());
            setTranslateY((float)GuiBase.TILESIZE / 3);
            setTranslateZ(p.getY());
        }

        public PreviewSquare(Position p, Position board, Color colour) {
            this (p, colour);
            setOnMouseClicked(mouseEvent -> base.getController().handlePlayerInput(board, VariantController.ObjectType.TILE));
        }
    }
}
