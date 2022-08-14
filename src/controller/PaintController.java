package controller;

import main.GamePanel;
import object.Tile;

import java.awt.*;

public class PaintController {

    private static final PaintController INSTANCE = new PaintController();

    private PaintController(){

    }

    public void moveAndPaintShape(int x, int pixelsByX, int y, int pixelsByY, Tile[][] shape, Graphics g){
        for(Tile[] shapeY : shape){
            for(Tile tile : shapeY){
                if(tile != null) moveAndPaintTile(x, pixelsByX, y, pixelsByY, tile, g);
            }
        }
    }

    private void moveAndPaintTile(int x, int pixelsByX, int y, int pixelsByY, Tile tile, Graphics g) {
        int tileSize = GamePanel.TILE_SIZE;
        g.setColor(tile.getTileColor());
        g.fill3DRect((tile.getX() + x) * tileSize + pixelsByX, (tile.getY() + y) * tileSize + pixelsByY, tileSize, tileSize, true);
    }

    public static PaintController getInstance(){
        return INSTANCE;
    }
}
