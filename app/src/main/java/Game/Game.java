package Game;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {
  Integer attemptsRemaining = 10;
  String word;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();
  WordChoser choser = new WordChoser();
  public Game(WordChoser choser) {
    word = choser.getRandomWordFromDictionary();
  }

  public String getWordToGuess() {
    StringBuilder hideWord = new StringBuilder(word);
    Integer wordLength = word.length();
    hideWord.delete(1, wordLength);
    for (int i = 1; i < wordLength; i++){
      if (guessedLetters.contains(word.charAt(i))){
        hideWord.append(word.charAt(i));
      } else {
        hideWord.append("_");
      }
    }
    String hiddenWord = hideWord.toString();
      return hiddenWord;
  }

  public Integer getAttemptsRemaining() {
    return attemptsRemaining;
  }

  public Boolean guessLetter(Character letter){
    if (this.word.indexOf(letter) != -1){
      guessedLetters.add(letter);
      System.out.println("Correct!");
      return true;
    } else {
      attemptsRemaining--;
      System.out.println("Incorrect...");
      return false;
    }
  }

  public Boolean isGameLost(){
    if (attemptsRemaining > 0){
      return false;
    } else {
      return true;
    }
  }

  public Boolean isGameWon(){
    if (getWordToGuess().equals(word)){
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args){
    WordChoser choser = new WordChoser();
    Game game = new Game(choser);
    Scanner input = new Scanner(System.in);
    System.out.printf("Welcome! Today the word to guess is:\n");
    do {
      System.out.printf("%s\nEnter one letter to guess (%d attempts remaining):\n", game.getWordToGuess(), game.attemptsRemaining);
      Character inputLetter = input.nextLine().charAt(0);
      Character guessedLetter = Character.toUpperCase(inputLetter);
      game.guessLetter(guessedLetter);
      game.isGameWon();
      game.isGameLost();
    }
    while((game.isGameWon() == false && game.isGameLost() == false));
    System.out.println(game.getWordToGuess());
    System.exit(0);
  }
}