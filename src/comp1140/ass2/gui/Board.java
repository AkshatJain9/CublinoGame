
package comp1140.ass2.gui;

import comp1140.ass2.gui.menus.HomeScreen;
import comp1140.ass2.gui.tools.GuiBase;
import javafx.stage.Stage;

public class Board extends GuiBase {
    public SettingsStore settingsStore;

    public Board() {
        super();
        settingsStore = new SettingsStore();

        // open initial screen
        setScreen(new HomeScreen(this));
    }

    @Override
    public void start(Stage stage) throws Exception {
        super.start(stage);
    }
}