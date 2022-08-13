package controller;

public class GameController {

    private static final GameController INSTANCE = new GameController();
    private GameController(){

    }

    public static GameController getInstance(){
        return INSTANCE;
    }
}
