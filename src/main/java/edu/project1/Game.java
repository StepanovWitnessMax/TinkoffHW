package edu.project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Game {
    private int currentErrors = 0;
    public final int maxErrors = 5;
    private final List<String> wrongLetters = new ArrayList<>();
    private final UserWord userWord;
    private final static Scanner INPUT = new Scanner(System.in);
    private final static Logger LOGGER = LogManager.getLogger();

    public Game(String secretWord) {
        userWord = new UserWord(secretWord);
    }

    public List<String> getWrongLetters() {
        return wrongLetters;
    }

    public int getCurrentErrors() {
        return currentErrors;
    }

    private boolean checkWin(String secretWord, char[] userWord) {
        return secretWord.equals(String.valueOf(userWord));
    }

    private boolean isCorrectLetter(String letter) {
        return (letter.charAt(0) >= 'а' && letter.charAt(0) <= 'я') && !wrongLetters.contains(letter);
    }

    private void letterProcessing(Integer index, String letter) {
        if (!userWord.openLetter(index, letter)) {
            wrongLetters.add(letter);
            currentErrors++;
        }
    }

    public void startGame() {

        PrintStatus.output(this, userWord);

        do {
            String checkInput = INPUT.next();
            if ((checkInput).equals("exit")) {
                break;
            } else {
            String letter = (String.valueOf(checkInput.charAt(0))).toLowerCase();
            Integer index = userWord.getSecretWord().indexOf(letter);
            if (isCorrectLetter(letter)) {
                letterProcessing(index, letter);
            } else {
                LOGGER.info("Введите корректную букву!!!");
            }
            PrintStatus.output(this, userWord);
            }
        } while (currentErrors < maxErrors && !checkWin(userWord.getSecretWord(), userWord.getUserWord()));

        if (checkWin(userWord.getSecretWord(), userWord.getUserWord())) {
            LOGGER.info("Вы выиграли, поздравляем!");
        } else {
            LOGGER.info("Вы проиграли, загаданное слово : " + userWord.getSecretWord());
        }
    }
}
