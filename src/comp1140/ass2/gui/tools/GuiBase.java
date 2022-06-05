/*
 * AUTHORSHIP: Justin Tieu
 * Other Works/Members Cited: N/A
 */

package comp1140.ass2.gui.tools;

import comp1140.ass2.gui.tools.resources.AudioPool;
import comp1140.ass2.gui.tools.resources.TexturePool;
import comp1140.ass2.gui.tools.screens.Screen;
import javafx.application.Application;
import javafx.application.ConditionalFeature;
import javafx.application.Platform;
import javafx.stage.Stage;

/**
 * Starting class for any Cublino application, preloads resources
 */
public abstract class GuiBase extends Application {
    /* board layout */
    public static final int APP_WIDTH = 933;
    public static final int APP_HEIGHT = 700;

    public static final int TILESIZE = is3DSupported() ? 128 : 64;

    private Stage stage;

    private TexturePool texturePool;
    public TexturePool getTexturePool() {
        return texturePool;
    }

    private AudioPool audioPool;
    public AudioPool getAudioPool() { return audioPool; }

    private Screen init;

    // whether 3d is supported by the executing hardware
    public static boolean is3DSupported() {
        return Platform.isSupported(ConditionalFeature.SCENE3D);
    }

    /**
     * load all external resources common to both
     */
    private void load () {
        // load the dice faces
        texturePool = new TexturePool();
        for (int p = 1; p <= 2; p++) {
            for (int i = 1; i <= 6; i++) {
                var res = "file:assets/dice/face" + p + i + ".png";
                texturePool.load ("dice" + p + i, res);
            }
        }

        // load board tile
        texturePool.load("tile1", "file:assets/boardtile1.png");
        texturePool.load("tile2", "file:assets/boardtile2.png");

        texturePool.load("koyubi", "file:assets/koyubi.png");

        audioPool = new AudioPool();
        audioPool.load ("tilt", "file:assets/audio/tilt.mp3");
    }

    public GuiBase() {
        load();
    }

    public void setScreen(Screen s) {
        if (stage == null)
            init = s;
        else
            stage.setScene(s.getScene());
    }

    public Stage getStage() {
        return stage;
    }

    @Override
    public void start(Stage stage) throws Exception {
        this.stage = stage;
        if (init != null) {
            setScreen(init);
        }

        stage.setTitle("Cublino (moo)");
        stage.setMinWidth(APP_WIDTH);
        stage.setMinHeight(APP_HEIGHT);
        stage.show();
    }
}
