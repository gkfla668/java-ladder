package main.java.controller;

import main.java.model.*;
import main.java.view.InputView;
import main.java.view.OutputView;

public class LadderGame {
    public void play() {
        Players players = createPlayers();
        Prizes prizes = createResults(players);
        int width = players.getPlayersCount();
        int height = inputHeight();
        Ladder ladder = createLadder(width, height);
        GameResult gameResult = createGameResult(players, ladder, prizes);
        askAndPrintGameResult(gameResult);
    }

    private void askAndPrintGameResult(GameResult gameResult) {
        do {
            String name = InputView.inputPeopleResultRequest();
            if (name.equals("all"))
                break;

            printPlayerResult(gameResult, name);
        } while (true);

        OutputView.printAllPeopleResult(gameResult);
    }

    private void printPlayerResult(GameResult gameResult, String name) {
        if (gameResult.getGameResult().get(name) == null) {
            OutputView.printGameResultErrorMessage();
            return;
        }

        OutputView.printPeopleResult(gameResult, name);
    }

    private Players createPlayers() {
        String[] names;
        boolean nameLength;
        boolean playerCount;

        do {
            names = inputPlayersNames();
            nameLength = Validator.isValidPlayerNameLength(names);
            playerCount = Validator.isValidPlayersCount(names);

            checkPlayerLengthError(nameLength, playerCount);
        } while (!nameLength || !playerCount);

        return new Players(names);
    }

    private void checkPlayerLengthError(boolean nameLength, boolean playersLength) {
        if (!nameLength) {
            OutputView.printPlayerNameLengthErrorMessage();
            return;
        }

        if (!playersLength) OutputView.printPlayersCountErrorMessage();
    }

    private Prizes createResults(Players players) {
        String[] names;
        boolean resultsLength;

        do {
            names = inputResults();
            resultsLength = Validator.isValidResultsCount(names.length, players.getPlayersCount());
            if (!resultsLength)
                OutputView.printResultsCountErrorMessage(players);
        } while (!resultsLength);

        return new Prizes(names);
    }

    private Ladder createLadder(int width, int height) {
        return new Ladder(width, height);
    }

    private GameResult createGameResult(Players players, Ladder ladder, Prizes prizes) {
        OutputView.printLadder(players, ladder, prizes);
        return new GameResult(players, ladder, prizes);
    }

    private String[] inputPlayersNames() {
        String names = InputView.inputPlayersNames();
        return Convert.splitNames(names);
    }

    private String[] inputResults() {
        String prizes = InputView.inputLadderResults();
        return Convert.splitNames(prizes);
    }

    private int inputHeight() {
        return InputView.inputHeight();
    }
}
