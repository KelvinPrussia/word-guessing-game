package Game;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;

import org.junit.Test;

public class MaskerTest {

  @Test public void testGetsWordToGuessWithRandomWord(){
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertEquals(game.getWordToGuess(), "D________");
  }

  @Test public void testGetMaskedWord(){
    Masker masker = new Masker();
    ArrayList<Character> guessedLetters = new ArrayList<Character>();
    guessedLetters.add('E');
    guessedLetters.add('V');

    assertEquals(masker.getMaskedWord("DEVELOPER", guessedLetters), "DEVE___E_");
  }
}
