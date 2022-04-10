package main.java.controller;

import main.java.view.InputView;
import main.java.view.OutputView;

public class Controller {
    public void play(){
        String names = getPlayersNames();
        String results = getLadderResults();
    }

    private String getLadderResults() {
        OutputView.printLadderResultsInputMessage();
        return InputView.inputLadderResults();
    }

    private String getPlayersNames(){
        OutputView.printPlayersNamesInputMessage();
        return InputView.inputPlayersNames();
    }
}
