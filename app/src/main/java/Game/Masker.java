package Game;

import java.util.ArrayList;

public class Masker {

  public String getMaskedWord(String word, ArrayList<Character> guessedLetters) {
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
}
