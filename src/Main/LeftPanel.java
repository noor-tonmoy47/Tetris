package Main;

import javax.swing.*;
import java.awt.*;

public class LeftPanel extends JPanel {
    public static final LeftPanel INSTANCE = new LeftPanel();
    public static final int BORDER_SIZE = GamePanel.TILE_SIZE + GamePanel.BORDER_SIZE;
    public static final int PANEL_WIDTH = GamePanel.TILE_SIZE * 5 + BORDER_SIZE * 2;
    public static final int PANEL_HEIGHT = GamePanel.PANEL_HEIGHT;

    private LeftPanel() {
        setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        setBackground(Color.RED);

    }

    public static LeftPanel getINSTANCE() {
        return INSTANCE;
    }
}
