package edu.project1;

import java.util.Arrays;

public class UserWord {
    private final String secretWord;
    private final char[] userWord;

    public UserWord(String secretWord) {
        this.secretWord = secretWord;
        //String symbolMaskedLetter = "*";
        userWord = new char[secretWord.length()];
        Arrays.fill(userWord, '*');
    }

    public char[] getUserWord() {
        return userWord;
    }

    public String getSecretWord() {
        return secretWord;
    }

    public boolean openLetter(Integer index, String letter) {
        boolean status = false;
        Integer indexOpenLetter = index;
        while (-1 != indexOpenLetter) {
            status = true;
            userWord[indexOpenLetter] = letter.charAt(0);
            indexOpenLetter = secretWord.indexOf(letter, indexOpenLetter + 1);
        }
        return status;
    }
}
