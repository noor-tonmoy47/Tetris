package Main.Editing;

import java.awt.*;

public enum BaseFonts {

    SMALL_FONT(new Font("Mv Boli", Font.PLAIN, 12)),

    LARGE_FONT(new Font("Mv Boli", Font.BOLD, 14));

    private Font font;
    BaseFonts(Font font){
        this.font = font;
    }

    public Font getFont() {
        return font;
    }
}
