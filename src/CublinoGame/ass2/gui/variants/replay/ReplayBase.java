/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package CublinoGame.ass2.gui.variants.replay;

import CublinoGame.ass2.game.*;
import CublinoGame.ass2.gui.Board;
import CublinoGame.ass2.gui.menus.HomeScreen;
import CublinoGame.ass2.gui.players.LocalPlayer;
import CublinoGame.ass2.gui.variants.Model;
import CublinoGame.ass2.gui.variants.VariantBase;
import CublinoGame.ass2.gui.variants.VariantController;
import CublinoGame.ass2.gui.variants.VariantScreen;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReplayBase extends VariantBase {
    Model m;
    ReplayController controller;
    ReplayScreen screen;

    Game game;
    LocalPlayer p1;
    LocalPlayer p2;

    Board host;

    public ReplayBase(String path, Board host) {
        super(host);
        this.host = host;

        controller = new ReplayController(this);
        var rep = new ArrayList <String>();

        // read replay
        try {
            FileInputStream stream = new FileInputStream(path);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            int c = 0;
            String line;
            do {
                line = reader.readLine();
                switch (c) {
                    case 0:
                        // variant
                        switch (line) {
                            case "p" -> game = new PurGame();
                            case "c" -> game = new ContraGame();
                            case "e" -> game = new EckeGame();
                            default -> giveUp("invalid variant character");
                        }
                        break;
                    case 1:
                        // p1 name
                        p1 = new LocalPlayer(line);
                        break;
                    case 2:
                        // p2 name
                        p2 = new LocalPlayer(line);
                        break;
                    default:
                        // replay data
                        rep.add (line);
                }
                c++;
            } while (line != null);
            stream.close();
        } catch (IOException e) {
            e.getStackTrace();
            giveUp(e.toString());
        }

        m = new Model(game, p1, p2);
        m.replay.addAll (rep);
        screen = new ReplayScreen(this);
    }

    /**
     * safe return to the home screen
     * @param msg
     */
    void giveUp (String msg) {
        System.out.println("something went wrong reading the file");
        System.out.println(msg);
        host.setScreen(new HomeScreen(host));
    }

    /**
     * The name of the variant eg. Pur, Ecke
     *
     * @return variant name
     */
    @Override
    public String getVariantName() {
        return "Replay";
    }

    /**
     * get Model instance
     *
     * @return variant model
     */
    @Override
    public Model getModel() {
        return m;
    }

    /**
     * Get the controller instance
     *
     * @return controller
     */
    @Override
    public VariantController getController() {
        return controller;
    }

    /**
     * Get the view class
     *
     * @return screen
     */
    @Override
    public VariantScreen getScreen() {
        return screen;
    }
}
