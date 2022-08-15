package controller;

import main.BaseColors;
import main.GamePanel;
import object.Tile;
import object.TileColor;

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
    public void paintTetrisView(Graphics g) {
        String startGame = "Press ENTER to start.";
        int tileSize = 11;
        int rows = tetrisView.length;
        int columns = tetrisView[0].length;
        int shiftByY = GamePanel.TILE_SIZE * 4 + 10;
        int shiftByX = 10;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                if (tetrisView[y][x] == 1) {
                    Color color = Color.WHITE;
                    if (x < 3) {
                        color = TileColor.Z.getColor();
                    } else if (x > 3 && x < 7) {
                        color = TileColor.L.getColor();
                    } else if (x > 7 && x < 11) {
                        color = TileColor.O.getColor();
                    } else if (x > 11 && x < 15) {
                        color = TileColor.S.getColor();
                    } else if (x > 15 && x < 17) {
                        color = TileColor.I.getColor();
                    } else if (x > 17 && x < 21) {
                        color = TileColor.T.getColor();
                    }
                    paintTile(x, y, shiftByY, shiftByX, tileSize, color, g);
                }
            }
        }
        int[] yPoints = {shiftByY, shiftByY, shiftByY + tileSize};
        int[] xPoints = {shiftByX + tileSize * 14, shiftByX + tileSize * 15, shiftByX + tileSize * 15};
        paintPolygon(3, yPoints, xPoints, BaseColors.DARK_COLOR.getColor().darker(), g);
        yPoints = new int[]{shiftByY + tileSize * 2, shiftByY + tileSize * 3, shiftByY + tileSize * 2 + tileSize / 2};
        xPoints = new int[]{shiftByX + tileSize * 15, shiftByX + tileSize * 15, shiftByX + tileSize * 14 + tileSize / 2};
        paintPolygon(3, yPoints, xPoints, BaseColors.DARK_COLOR.getColor().darker(), g);

        g.setColor(BaseColors.FONT_COLOR.getColor());
        g.drawString(startGame, shiftByX + tileSize * 5, shiftByY + tileSize * (rows + 10));
    }

    private void paintCutAngleForGameOverView(int tileSize, int shiftByY, int shiftByX, Color color, Graphics g) {
        int x0 = 0;
        int y0 = 0;
        for (int i = 0; i < 7; i++) {
            if (i == 1) {
                x0 = 5;
            } else if (i == 2) {
                x0 = 9;
            } else if (i == 3) {
                x0 = 15;
            } else if (i == 4) {
                x0 = 1;
                y0 = 6;
            } else if (i == 5) {
                x0 = 5;
            } else if (i == 6) {
                x0 = 9;
            }
            int[] yPoints = {shiftByY + tileSize + tileSize * y0, shiftByY + tileSize * y0, shiftByY + tileSize + tileSize * y0};
            int[] xPoints = {shiftByX + tileSize * x0, shiftByX + tileSize + tileSize * x0, shiftByX + tileSize + tileSize * x0};
            paintPolygon(3, yPoints, xPoints, color, g);
            g.setColor(color.darker());
            g.drawLine(xPoints[0] + 1, yPoints[0], xPoints[2] - 1, yPoints[2]);
            g.drawLine(xPoints[1] - 1, yPoints[1] + 1, xPoints[2] - 1, yPoints[2]);
            yPoints = new int[]{shiftByY + tileSize * 6, shiftByY + tileSize * 7, shiftByY + tileSize * 7};
            xPoints = new int[]{shiftByX + tileSize * 16, shiftByX + tileSize * 16, shiftByX + tileSize * 17};
            paintPolygon(3, yPoints, xPoints, color, g);
            g.setColor(color.darker());
            g.drawLine(xPoints[1], yPoints[1], xPoints[2] - 1, yPoints[2]);
            yPoints = new int[]{shiftByY + tileSize * 10 - 1, shiftByY + tileSize * 10, shiftByY + tileSize * 11};
            xPoints = new int[]{shiftByX + tileSize * 5, shiftByX + tileSize * 6, shiftByX + tileSize * 6 + 1};
            paintPolygon(3, yPoints, xPoints, color, g);
            g.setColor(color.darker());
            g.drawLine(xPoints[1], yPoints[1], xPoints[2] - 1, yPoints[2] - 1);
            yPoints = new int[]{shiftByY + tileSize * 10, shiftByY + tileSize * 10 - 1, shiftByY + tileSize * 11};
            xPoints = new int[]{shiftByX + tileSize * 7, shiftByX + tileSize * 8, shiftByX + tileSize * 7 - 1};
            paintPolygon(3, yPoints, xPoints, color, g);
            yPoints = new int[]{shiftByY + tileSize * 8, shiftByY + tileSize * 8, shiftByY + tileSize * 8 + tileSize / 2,
                    shiftByY + tileSize * 9, shiftByY + tileSize * 9};
            xPoints = new int[]{shiftByX + tileSize * 16, shiftByX + tileSize * 17, shiftByX + tileSize * 16 + tileSize / 2,
                    shiftByX + tileSize * 17, shiftByX + tileSize * 16};
            paintPolygon(5, yPoints, xPoints, color, g);
            g.setColor(color.darker());
            g.drawLine(xPoints[3] - 1, yPoints[3], xPoints[4], yPoints[4]);
        }
    }

    public void paintPolygon(int points, int[] pointsY, int[] pointsX, Color color, Graphics g) {
        g.setColor(color);
        Polygon polygon = new Polygon(pointsX, pointsY, points);
        g.fillPolygon(polygon);
    }

    public void setShowRecordNameInput(boolean b) {
        isShowRecordNameInput = b;
    }
}
