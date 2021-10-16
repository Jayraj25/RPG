import org.junit.Test;

import numbergenerator.GenerateRandomNumber;

import static org.junit.Assert.assertEquals;

/**
 * Tests for random generator class where all the validations are done.
 */
public class GenerateRandomNumberTest {

  GenerateRandomNumber g = new GenerateRandomNumber(3);
  GenerateRandomNumber g1 = new GenerateRandomNumber(1,2);

  @Test
  public void testGetRandomNumber() {
    assertEquals(7,g.getRandomNumber(5,10));
    assertEquals(19,g.getRandomNumber(14,20));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidRangeMin() {
    assertEquals(10,g.getRandomNumber(-1,10));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidMaxRange() {
    assertEquals(12,g.getRandomNumber(10,8));
  }

  @Test
  public void testGetNumberVarargs() {
    assertEquals(6,g1.getRandomNumber(3,8));
  }

  @Test (expected = IllegalArgumentException.class)
  public void testNullInVarargs() {
    GenerateRandomNumber g2 = new GenerateRandomNumber(null);
  }
}