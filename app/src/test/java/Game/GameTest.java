package Game;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.Test;

public class GameTest {
  @Test public void testGetsWordToGuess() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertEquals(game.getWordToGuess(), "D________");
  }

  @Test public void testGetsInitialRemainingAttempts(){
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertEquals(Integer.valueOf(10), game.getAttemptsRemaining());
  }

  @Test public void testGetsRandomWord(){
    WordChoser choser = new WordChoser();
    assertNotNull(choser.getRandomWordFromDictionary());
  }

  @Test public void testGetsWordToGuessWithRandomWord(){
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertEquals(game.getWordToGuess(), "D________");
  }

  @Test public void testguessLetterCorrect(){
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertTrue(game.guessLetter('E'));
    assertTrue(game.guessedLetters.contains('E'));
  }

  @Test public void testguessLetterIncorrect(){
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    assertFalse(game.guessLetter('K'));
    assertFalse(game.guessedLetters.contains('K'));
    assertEquals(game.getAttemptsRemaining(), Integer.valueOf(9));
  }

  @Test public void testGuessCorrectLettersAndShowsGuessedLetters() {
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    game.guessLetter('E');
    assertEquals(game.getWordToGuess(), "DE_E___E_");
  }

  @Test public void testIsGameLostMethod(){
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    game.guessLetter('Z');
    assertEquals(false, game.isGameLost());
    game.guessLetter('Z');
    game.guessLetter('Z');
    game.guessLetter('Z');
    game.guessLetter('Z');
    game.guessLetter('Z');
    game.guessLetter('Z');
    game.guessLetter('Z');
    game.guessLetter('Z');
    game.guessLetter('Z');
    assertEquals(true, game.isGameLost());
  }

  @Test public void testIsGameWonMethod(){
    WordChoser mockedChoser = mock(WordChoser.class);
    when(mockedChoser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

    Game game = new Game(mockedChoser);
    game.guessLetter('D');
    assertEquals(false, game.isGameWon());
    game.guessLetter('E');
    game.guessLetter('V');
    game.guessLetter('L');
    game.guessLetter('O');
    game.guessLetter('P');
    game.guessLetter('R');
    assertEquals(true, game.isGameWon());
  }
}