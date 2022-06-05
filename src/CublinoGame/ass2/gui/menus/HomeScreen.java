/*
 * AUTHORSHIP: Chris Kim, Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.menus;

import CublinoGame.ass2.AI.AiHelper;
import CublinoGame.ass2.AI.AiType;
import CublinoGame.ass2.AI.GameTypes;
import CublinoGame.ass2.AI.bots.*;
import CublinoGame.ass2.base.BoardState;
import CublinoGame.ass2.base.Player;
import CublinoGame.ass2.gui.Board;
import CublinoGame.ass2.gui.players.AIPlayer;
import CublinoGame.ass2.gui.players.LocalPlayer;
import CublinoGame.ass2.gui.players.PlayerType;
import CublinoGame.ass2.gui.tools.screens.Screen;
import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.contra.ContraBase;
import CublinoGame.ass2.gui.variants.ecke.EckeBase;
import CublinoGame.ass2.gui.variants.pur.PurBase;
import CublinoGame.ass2.gui.variants.replay.ReplayBase;
import CublinoGame.ass2.gui.viewables.BoardViewer3D;
import CublinoGame.ass2.gui.viewables.Plane;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.FileChooser;
import javafx.util.Duration;

import java.util.Random;

import static CublinoGame.ass2.AI.GameTypes.*;
import static CublinoGame.ass2.gui.tools.GuiBase.*;

public class HomeScreen implements Screen {

    /**
     * the variant to be played
     */
    GameTypes selectedVariant = null;

    /**
     * type of the player (AI, Local)
     */
    PlayerType.Ref[] playerTypes = new PlayerType.Ref[2];

    /**
     * name of the player. If the player is an AI this value will be ignored
     */
    String[] names = new String[2];

    /**
     * Type of the AI, if the player is a human this value will be ignored
     */
    AiType[] AIs = new AiType[2];

    Board host;
    public HomeScreen(Board b) {
        host = b;
        if (!is3DSupported()) {
            Alert msg = new Alert(Alert.AlertType.WARNING, "" +
                    "3D capability is not supported on this system.\n" +
                    "You can still play Cublino however this will be done on the 2D viewer which may not be as " +
                    "visually appealing as the 3D one.");
            msg.showAndWait();
        }
    }

    @Override
    public Scene getScene() {
        // 3D
        Group group3d = new Group();

        Random r = new Random();
        var board = new BoardViewer3D(host.getTexturePool(), new BoardState(PurStates.FULL_PUR_GAME[r.nextInt(PurStates.FULL_PUR_GAME.length - 1)][0]), false);
        group3d.getChildren().add(board);
        board.setOnObjClick(pos -> { });


        var rot = new Rotate();
        rot.setAxis(Rotate.Y_AXIS);
        rot.setPivotX(400);
        rot.setPivotZ(300);

        var rot2 = new Rotate();
        rot2.setAxis(Rotate.X_AXIS);
        rot2.setAngle(-20);

        Camera camera = new PerspectiveCamera(false);
        camera.setTranslateX(-100);
        camera.setTranslateY(-400);
        camera.setTranslateZ(400);
        camera.setRotationAxis(Rotate.X_AXIS);
        camera.setRotate(-5);
        camera.getTransforms().add (rot);
        camera.getTransforms().add (rot2);

        // table
        Plane p = new Plane(host.getTexturePool().get("koyubi"));
        p.setRotationAxis(Rotate.X_AXIS);
        p.setRotate(-90);
        p.setScaleX(-5000);
        p.setScaleY(-5000);
        p.setScaleZ(5000);
        p.setTranslateY(100);
        group3d.getChildren().add (0,p);

        Timeline tl = new Timeline();
        tl.setCycleCount(Animation.INDEFINITE);
        tl.setRate(0.05);
        tl.getKeyFrames().add (
                new KeyFrame(Duration.millis(1000), new KeyValue(rot.angleProperty(), 360))
        );
        tl.play();

        SubScene world = new SubScene(group3d, APP_WIDTH, APP_HEIGHT, true, SceneAntialiasing.BALANCED);
        world.setCamera(camera);

        // 2D
        Group group = new Group();
        group.getChildren().add (world);

        Label info = new Label("COMP1140-Thu11r\nAkshat Jain, Chris Kim, Justin Tieu - 2021");
        info.setLayoutX(10);
        info.setLayoutY(APP_HEIGHT - 50);
        group.getChildren().add(info);

        // menu pane
        Group menuPane = new Group();
        Rectangle pane = new Rectangle(APP_WIDTH/2-300,APP_HEIGHT/2-250,600,500);
        Color menuCol = Color.web("#e7e7e7",0.8);
        pane.setFill(menuCol);
        menuPane.getChildren().add(pane);
        pane.setArcHeight(30);
        pane.setArcWidth(30);

        String menu = "-fx-font-size: 2em; -fx-background-color: #ababad; -fx-text-fill: white;";

        // menu pane buttons
        Button back = new Button ("Back");
        back.setLayoutX(APP_WIDTH/2-290);
        back.setLayoutY(APP_HEIGHT/2-240);
        menuPane.getChildren().add(back);
        back.setOnAction(actionEvent -> group.getChildren().remove(menuPane));
        back.getStyleClass().add("back");


            // combo boxes
        Label vari = new Label("Variant: ");
        vari.setLayoutX(APP_WIDTH/2-250);
        vari.setLayoutY(APP_HEIGHT/2-180);
        vari.setStyle("-fx-font-size: 2em;");
        vari.setAlignment(Pos.CENTER);
        ComboBox variant = new ComboBox();
        variant.getItems().add("Pur");
        variant.getItems().add("Contra");
        variant.getItems().add("Ecke");
        variant.setLayoutX(APP_WIDTH/2-160);
        variant.setLayoutY(APP_HEIGHT/2-180);
        variant.setMinSize(130,40);
        variant.setMaxSize(130,40);
        variant.setOnAction(actionEvent ->  {
            if ((variant.getValue()).equals("Pur")) {
                selectedVariant = PUR;
            } else if ((variant.getValue()).equals("Contra")) {
                selectedVariant = CONTRA;
            } else if ((variant.getValue()).equals("Ecke")) {
                selectedVariant = ECKE;
            } else {
                throw new IllegalArgumentException();
            }
        });
        menuPane.getChildren().add(variant);
        menuPane.getChildren().add(vari);

        // choose player1
        Label p1 = new Label("Player 1: ");
        p1.setLayoutX(APP_WIDTH/2-255);
        p1.setLayoutY(APP_HEIGHT/2-60);
        p1.setStyle("-fx-font-size: 2em;");
        p1.setAlignment(Pos.CENTER);
        ComboBox<String> player1 = new ComboBox();
        player1.getItems().add("Person");
        player1.getItems().add("Bot");
        player1.setLayoutX(APP_WIDTH/2-160);
        player1.setLayoutY(APP_HEIGHT/2-60);
        player1.setMinSize(130,40);
        player1.setMaxSize(130,40);
        player1.setOnAction(actionEvent -> playerTypes[0] = player1.getValue().equals("Person") ? PlayerType.Ref.LOCAL : PlayerType.Ref.AI);
        menuPane.getChildren().add(player1);
        menuPane.getChildren().add(p1);

        // choose player2
        Label p2 = new Label("Player 2: ");
        p2.setLayoutX(APP_WIDTH/2-5);
        p2.setLayoutY(APP_HEIGHT/2-60);
        p2.setStyle("-fx-font-size: 2em;");
        p2.setAlignment(Pos.CENTER);
        ComboBox<String> player2 = new ComboBox();
        player2.getItems().add("Person");
        player2.getItems().add("Bot");
        player2.setLayoutX(APP_WIDTH/2+90);
        player2.setLayoutY(APP_HEIGHT/2-60);
        player2.setMinSize(130,40);
        player2.setMaxSize(130,40);
        player2.setOnAction(actionEvent -> playerTypes[1] = player2.getValue().equals("Person") ? PlayerType.Ref.LOCAL : PlayerType.Ref.AI);
        menuPane.getChildren().add(player2);
        menuPane.getChildren().add(p2);

        // name input
        Label name = new Label("Name: ");
        name.setLayoutX(APP_WIDTH/2-235);
        name.setLayoutY(APP_HEIGHT/2+45);
        name.setStyle("-fx-font-size: 2em;");
        name.setAlignment(Pos.CENTER);
        TextField nameF = new TextField();
        nameF.setLayoutX(APP_WIDTH/2-160);
        nameF.setLayoutY(APP_HEIGHT/2+45);
        nameF.setMinSize(130,40);
        nameF.setMaxSize(130,40);
        nameF.setStyle(menu);
        nameF.textProperty().addListener(observable -> names[0] = nameF.getText());

        // name2 input
        Label name2 = new Label("Name: ");
        name2.setLayoutX(APP_WIDTH/2+20);
        name2.setLayoutY(APP_HEIGHT/2+45);
        name2.setStyle("-fx-font-size: 2em;");
        name2.setAlignment(Pos.CENTER);
        TextField nameF2 = new TextField();
        nameF2.setLayoutX(APP_WIDTH/2+90);
        nameF2.setLayoutY(APP_HEIGHT/2+45);
        nameF2.setMinSize(130,40);
        nameF2.setMaxSize(130,40);
        nameF2.setStyle(menu);
        nameF2.textProperty().addListener(observable -> names[1] = nameF2.getText());

        // ai combobox input
        Label ainame = new Label("AI: ");
        ainame.setLayoutX(APP_WIDTH/2-195);
        ainame.setLayoutY(APP_HEIGHT/2+45);
        ainame.setStyle("-fx-font-size: 2em;");
        ainame.setAlignment(Pos.CENTER);
        ComboBox<AiType> ai1 = new ComboBox();
        ai1.setLayoutX(APP_WIDTH/2-160);
        ai1.setLayoutY(APP_HEIGHT/2+45);
        ai1.setMinSize(170,40);
        ai1.setMaxSize(170,40);
        for (var ai : AiType.values()) {
            ai1.getItems().add (ai);
        }
        ai1.setOnAction(actionEvent -> AIs[0] = ai1.getValue());

        // a2 combobox input
        Label ainame2 = new Label("AI: ");
        ainame2.setLayoutX(APP_WIDTH/2+55);
        ainame2.setLayoutY(APP_HEIGHT/2+45);
        ainame2.setStyle("-fx-font-size: 2em;");
        ainame2.setAlignment(Pos.CENTER);
        ComboBox<AiType> ai2 = new ComboBox();
        ai2.setLayoutX(APP_WIDTH/2+90);
        ai2.setLayoutY(APP_HEIGHT/2+45);
        ai2.setMinSize(170,40);
        ai2.setMaxSize(170,40);
        for (var ai : AiType.values()) {
            ai2.getItems().add (ai);
        }
        ai2.setOnAction(actionEvent -> AIs[1] = ai2.getValue());

        // choose ai
        Label ai = new Label("AI: ");
        ai.setLayoutX(APP_WIDTH/2+40);
        ai.setLayoutY(APP_HEIGHT/2-180);
        ai.setStyle("-fx-font-size: 2em;");
        ai.setAlignment(Pos.CENTER);
        ComboBox arint = new ComboBox();
        arint.getItems().add("Random AI");
        arint.getItems().add("Greedy AI");
        arint.getItems().add("Minimax AI");
        arint.getItems().add("MCTS AI");
        arint.setLayoutX(APP_WIDTH/2+80);
        arint.setLayoutY(APP_HEIGHT/2-180);
        arint.setMinSize(170,40);
        arint.setMaxSize(170,40);
        arint.setStyle(menu);

        player1.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (newValue.equals("Person")) {
                    menuPane.getChildren().add(name);
                    menuPane.getChildren().add(nameF);
                    menuPane.getChildren().remove(ainame);
                    menuPane.getChildren().remove(ai1);
                } else {
                    menuPane.getChildren().remove(name);
                    menuPane.getChildren().remove(nameF);
                    menuPane.getChildren().add(ainame);
                    menuPane.getChildren().add(ai1);
                }
            }
        });

        player2.valueProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                if (newValue.equals("Person")) {
                    menuPane.getChildren().add(name2);
                    menuPane.getChildren().add(nameF2);
                    menuPane.getChildren().remove(ainame2);
                    menuPane.getChildren().remove(ai2);
                } else {
                    menuPane.getChildren().remove(name2);
                    menuPane.getChildren().remove(nameF2);
                    menuPane.getChildren().add(ainame2);
                    menuPane.getChildren().add(ai2);
                }
            }
        });

        // Title using CSS
        Text title = new Text ("Cublino");
        title.setLayoutX(APP_WIDTH/2-200);
        title.setLayoutY(APP_HEIGHT-500);
        title.minHeight(300);
        title.minWidth(150);
        title.maxHeight(300);
        title.maxWidth(150);
        group.getChildren().add(title);
        title.getStyleClass().addAll("title");





        // start button
        Button start = new Button("Start");
        start.setStyle("-fx-font-size: 2em;");
        start.setLayoutX(APP_WIDTH/2+205);
        start.setLayoutY(APP_HEIGHT/2+185);
        start.setMinSize(75,45);
        start.setMaxSize(75,45);
        menuPane.getChildren().add(start);
        start.setOnAction(actionEvent -> start());


        // SinglePlayer Button
        Button singlePlayer = new Button("Singleplayer");
        singlePlayer.setLayoutX(APP_WIDTH/2-75);
        singlePlayer.setLayoutY(APP_HEIGHT/2);
        singlePlayer.setMinSize(150,50);
        singlePlayer.setMaxSize(150,50);
        singlePlayer.setOnAction(actionEvent -> group.getChildren().add(menuPane));
        group.getChildren().add(singlePlayer);

        // Replay Button
        Button replay = new Button("Replay");
        replay.setLayoutX(APP_WIDTH/2-75);
        replay.setLayoutY(APP_HEIGHT/2+65);
        replay.setMinSize(150,50);
        replay.setMaxSize(150,50);
        replay.setOnAction(actionEvent -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Replay File");
            var file = fileChooser.showOpenDialog(host.getStage());

            if (file == null || !file.exists())
                return;

            ReplayBase rb = new ReplayBase(file.getAbsolutePath(), host);
            host.setScreen(rb.getScreen());
        });
        group.getChildren().add(replay);

        // Settings Button
        Button settings = new Button("Settings");
        settings.setLayoutX(APP_WIDTH/2-75);
        settings.setLayoutY(APP_HEIGHT/2+135);
        settings.setMinSize(150,50);
        settings.setMaxSize(150,50);
        settings.setOnAction(actionEvent -> host.setScreen(new SettingsScreen(host)));
        group.getChildren().add(settings);

        // Quit Button
        Button quit = new Button("Quit");
        quit.setLayoutX(APP_WIDTH/2-75);
        quit.setLayoutY(APP_HEIGHT/2+200);
        quit.setMinSize(150,50);
        quit.setMaxSize(150,50);
        group.getChildren().add(quit);
        quit.setOnAction(actionEvent -> Platform.exit());

        group.getStylesheets().add(getClass().getResource("title.css").toExternalForm());

        var s = new Scene(group);
        s.fillProperty().set(Paint.valueOf("#009688"));


        return s;
    }

        /**
         * called when start button is clicked
         */
        void start() {
                if (selectedVariant == null)
                        return;

                PlayerType[] pt = new PlayerType[2];

                for (int i = 0; i < 2; i++) {
                    var p = i == 0 ? Player.PLAYER1 : Player.PLAYER2;

                    AIMain ai = new EmptyAI();
                    if (AIs[i] != null)
                        ai = AiHelper.getAI(AIs[i], selectedVariant, p);

                    // construct players
                    if (playerTypes[i] == null)
                        return;
                    switch (playerTypes[i]) {
                        case LOCAL -> {
                            if (names[i] == null || names[i].isEmpty() || names[i].isBlank())
                                return;
                            pt[i] = new LocalPlayer(names[i]);
                        }
                        case AI    -> {
                            if (ai == null || ai instanceof EmptyAI)
                                return;
                            pt[i] = new AIPlayer(ai);
                        }
                        default    -> throw new IllegalArgumentException();
                    };
                }

                var player1 = pt[0];
                var player2 = pt[1];

                // construct bases
                VariantBase b = switch (selectedVariant) {
                        case PUR -> new PurBase(host, player1, player2);
                        case CONTRA ->  new ContraBase(host, player1, player2);
                        case ECKE -> new EckeBase(host, player1, player2);
                };

                // start game
                host.setScreen(b.getScreen());
        }
}

