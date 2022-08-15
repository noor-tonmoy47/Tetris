package controller;

import main.GamePanel;
import object.Tile;

import java.awt.*;

public class PaintController {

    private static final PaintController INSTANCE = new PaintController();

    private final int[][] tetrisView = {
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1,},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0,},
            {0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1,},
            {0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1,},
            {0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1,},
    };

    private final int[][] pauseView = {
            {0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0},
            {1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 1},
            {1, 0, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0},
    };

    private final int[][] gameOverView = {
            {0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0},
            {1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0},
            {1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
            {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0},


    };
    private boolean isShowRecordNameInput;

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



    public void paintGameMas(Tile[][] gameMas, Graphics g) {
        for (Tile[] gameMasY : gameMas) {
            for (Tile tile : gameMasY) {
                if (tile != null) paintTile(tile, g);
            }
        }
    }

    public void paintShape(Tile[][] shape, Graphics g) {
        for (Tile[] aShape : shape) {
            for (Tile anAShape : aShape) {
                if (anAShape != null) paintTile(anAShape, g);
            }
        }
    }

    private void paintTile(Tile tile, Graphics g) {
        int tileSize = GamePanel.TILE_SIZE;
        g.setColor(tile.getTileColor());
        g.fill3DRect(tile.getX() * tileSize, tile.getY() * tileSize, tileSize, tileSize, true);
    }

    public void paintTile(int x, int y, int shiftByY, int shiftByX, int tileSize, Color color, Graphics g) {
        g.setColor(color);
        g.fill3DRect(x * tileSize + shiftByX, y * tileSize + shiftByY, tileSize, tileSize, true);
    }

    public void paintPauseView(Graphics g) {
    }

    public void paintGameOverView(Graphics g) {
    }
    public void paintTetrisView(Graphics g) {}

    public void setShowRecordNameInput(boolean b) {
        isShowRecordNameInput = b;
    }
}
