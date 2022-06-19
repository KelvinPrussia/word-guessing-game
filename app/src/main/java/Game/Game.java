package Game;

import java.util.ArrayList;
import java.util.Scanner;

import org.checkerframework.checker.units.qual.A;

import java.util.Random;

public class Game {
  Game[] players;
  Integer attemptsRemaining = 10;
  String word;
  ArrayList<Character> guessedLetters = new ArrayList<Character>();
  WordChoser choser = new WordChoser();
  Masker masker = new Masker();
  public Game(WordChoser choser) {
    word = choser.getRandomWordFromDictionary();
  }

  public Integer getAttemptsRemaining() {
    return attemptsRemaining;
  }

  public String getWordToGuess(){
    return masker.getMaskedWord(word, guessedLetters);
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
      System.out.println("Oh no! You Lost!");
      return true;
    }
  }

  public Boolean isGameWon(){
    if (getWordToGuess().equals(word)){
      System.out.println("Congratulations! You win!");
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args){
    WordChoser choser = new WordChoser();
    WordChoser choser2 = new WordChoser();
    Game game = new Game(choser);
    Game game2 = new Game(choser2);
    Game[] players = {game, game2};
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