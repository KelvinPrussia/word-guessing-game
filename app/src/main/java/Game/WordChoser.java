package Game;

import java.util.Random;

public class WordChoser {
  final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON"};

  public String getRandomWordFromDictionary(){
    int randomIndex = new Random().nextInt(DICTIONARY.length);
    return DICTIONARY[randomIndex];
  }
  
  public static void main(String[] args){
    
  }
}
