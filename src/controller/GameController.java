package controller;


import main.GamePanel;
import main.LeftPanel;
import object.Figure;

import main.LeftPanel;
import object.Figure;

import object.Player;
import object.Tile;

import java.io.*;

public class GameController {

    private static final GameController INSTANCE = new GameController();

    private final int[] SCORES = {100, 300, 700, 1500};

    private final int gameSpeed = 500;

    private final int acceleration = 20;

    private Tile[][] currentShape;

    private Tile[][] nextShape0;

    private Tile[][] nextShape1;

    private Tile[][] nextShape2;

    private Tile[][] gameMas;

    private Player[] highScores;

    private String highScoresPath = "TETRIS_HighScore";

    private boolean isRecord;

    private boolean isPaused;

    private boolean isGameOver;

    private boolean isGameRunning;

    private int score;

    private int lines;

    private int level;


    private GameController() {
        initHighScores();
        resetGame();
    }

    public static boolean isTileEmpty(Tile tile) {
        return tile == null;
    }



    public void start(){

        if (!isGameOver && isGameRunning) {
            if (!isPaused) {
                if (canShapeStepDown(currentShape)) {
                    stepDownShape(currentShape);
                } else {
                    writeShapeToGameMas(currentShape);
                    scanAndClearRows(currentShape, gameMas);
                    setCurrentShape(nextShape0);
                    updateNextShapes();
                    if (gameOver()) {
                        isGameOver = true;
                        for (int i = 0; i < highScores.length; i++) {
                            if (highScores[i].getScore() < score) {
                                if (i < highScores.length - 1) {
                                    System.arraycopy(highScores, i, highScores, i + 1, highScores.length - i - 1);
                                }
                                highScores[i] = new Player("", score);
                                isRecord = true;
                                saveHighScoresToFile();
                                break;
                            }
                        }
                    }
                }
            }
        } else writeShapeToGameMas(currentShape);
    }


    public void resetGame() {
        gameMas = new Tile[GamePanel.getRowCount()][GamePanel.getColumnsCount()];
        currentShape = Figure.getRandomFigure();
        nextShape0 = Figure.getRandomFigure();
        nextShape1 = Figure.getRandomFigure();
        nextShape2 = Figure.getRandomFigure();
        isRecord = false;
        isPaused = false;
        isGameRunning = false;
        isGameOver = false;
        score = 0;
        lines = 0;
        level = 0;
    }


    private void updateNextShapes() {
        nextShape0 = nextShape1;
        nextShape1 = nextShape2;
        nextShape2 = Figure.getRandomFigure();
        LeftPanel.getInstance().repaint();
    }

    private void scanAndClearRows(Tile[][] currentShape, Tile[][] gameMas) {
    }

    public void stepDownShape(Tile[][] currentShape) {
    }

    private boolean gameOver() {
        return false;
    }


    public void saveHighScoresToFile() {
        try (FileOutputStream fileOutputStream = new FileOutputStream(highScoresPath);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(highScores);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void writeShapeToGameMas(Tile[][] currentShape) {
    }

    public boolean canShapeStepDown(Tile[][] currentShape) {
        return false;
    }


    private void initHighScores() {
        try (FileInputStream fileInputStream = new FileInputStream(highScoresPath);
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            highScores = (Player[]) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            try {
                File file = new File(highScoresPath);
                file.createNewFile();
                highScores = new Player[8];
                for (int i = 0; i < highScores.length; i++) {
                    highScores[i] = new Player("---", 0);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        } catch (EOFException e) {
            highScores = new Player[8];
            for (int i = 0; i < highScores.length; i++) {
                highScores[i] = new Player("---", 0);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static GameController getInstance() {
        return INSTANCE;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLines() {
        return lines;
    }

    public void setLines(int lines) {
        this.lines = lines;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void setPaused(boolean paused) {
        isPaused = paused;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }

    public boolean isGameRunning() {
        return isGameRunning;
    }

    public void setGameRunning(boolean gameRunning) {
        isGameRunning = gameRunning;
    }

    public Player[] getHighScores() {
        return highScores;
    }

    public void setHighScores(Player[] highScores) {
        this.highScores = highScores;
    }

    public boolean isRecord() {
        return isRecord;
    }

    public void setRecord(boolean record) {
        isRecord = record;
    }

    public int getAcceleration() {
        return acceleration;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public Tile[][] getGameMas() {
        return gameMas;
    }

    public void setGameMas(Tile[][] gameMas) {
        this.gameMas = gameMas;
    }

    public Tile[][] getCurrentShape() {
        return currentShape;
    }

    public void setCurrentShape(Tile[][] currentShape) {
        this.currentShape = currentShape;
    }

    public Tile[][] getNextShape0() {
        return nextShape0;
    }

    public void setNextShape0(Tile[][] nextShape0) {
        this.nextShape0 = nextShape0;
    }

    public Tile[][] getNextShape1() {
        return nextShape1;
    }

    public void setNextShape1(Tile[][] nextShape1) {
        this.nextShape1 = nextShape1;
    }

    public Tile[][] getNextShape2() {
        return nextShape2;
    }

    public void setNextShape2(Tile[][] nextShape2) {
        this.nextShape2 = nextShape2;
    }


    public boolean canMoveShape(Direction left, Tile[][] currentShape) {
        return false;
    }

    public void move(Direction left, Tile[][] currentShape) {
    }

    public void rotate(Tile[][] currentShape) {
    }


   
}
