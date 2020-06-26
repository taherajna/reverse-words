import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
   i/p: I am a Robot!
   o/p: I ma a Tobor!

   i/p: My twitter Handler is @Leucine30Years
   o/p: Ym rettiwt Reldnah si @Sraeyen30Icuel
*/
public class ReverseWordsTest {
  ReverseWords reverseWords;

  @Before
  public void setUp() {
    reverseWords = new ReverseWords();
  }

  @Test
  public void testNoInput() {
    Assert.assertEquals("", reverseWords.reverse(""));
  }

  @Test
  public void testReverseSingleCharacter() {
    Assert.assertEquals("I", reverseWords.reverse("I"));
  }

  @Test
  public void testReverseSingleWordAllLowerCase() {
    Assert.assertEquals("ma", reverseWords.reverse("am"));
  }

  @Test
  public void testReverseSingleWordMixedCase() {
    Assert.assertEquals("Ym", reverseWords.reverse("My"));
    Assert.assertEquals("Reldnah", reverseWords.reverse("Handler"));
    Assert.assertEquals("REldnah", reverseWords.reverse("HAndler"));
  }

  @Test
  public void testRevereForMultipleWords() {
    Assert.assertEquals("I ma", reverseWords.reverse("I am"));
    Assert.assertEquals("I ma a Tobor", reverseWords.reverse("I am a Robot"));
  }

  @Test
  public void testReverseForSpecialCharacter() {
    Assert.assertEquals("Tobor!", reverseWords.reverse("Robot!"));
  }

  @Test
  public void testReverseForFirstEntireInput() {
    Assert.assertEquals("I ma a Tobor!", reverseWords.reverse("I am a Robot!"));
  }

  @Test
  public void testReverseWithNumbersInBetweenTheWords() {
    Assert.assertEquals("Ye30L", reverseWords.reverse("Le30Y"));
    Assert.assertEquals("@Sraeyen30Icuel", reverseWords.reverse("@Leucine30Years"));
  }

  @Test
  public void testReverseForSecondEntireInput() {
    Assert.assertEquals(
        "Ym rettiwt Reldnah si @Sraeyen30Icuel",
        reverseWords.reverse("My twitter Handler is @Leucine30Years"));
  }
}
