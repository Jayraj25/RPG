package numbergenerator;

import java.util.Random;

/**
 * Class that helps in generating random number which will be used in testing as well.
 * */
public class GenerateRandomNumber {

  Random rand;

  /**
   * Constructs random number based on seed value.
   * @param seed the seed value
   * */
  public GenerateRandomNumber(int seed) {
    rand = new Random(seed);
  }

  /**
   * Constructs random number.
   * */
  public GenerateRandomNumber() {
    rand = new Random();
  }

  /**
   * Generate random numbers based on variable number of arguments.
   * @param args the variable number of arguments
   * */
  public GenerateRandomNumber(int... args) {
    if (args == null) {
      throw new IllegalArgumentException("Cannot be null");
    }
    rand = new Random(args[0]);
  }

  /**
   * Get the number generated.
   * @param min the minimum value for a range
   * @param max the maximum value for a range
   * @return the integer generated
   * @throws IllegalArgumentException exception if invalid min and max values
   */
  public int getRandomNumber(int min, int max) throws IllegalArgumentException {
    if (min < 0 || max < min) {
      throw new IllegalArgumentException("Unexpected argument");
    }
    return rand.nextInt(max - min + 1) + min;
  }
}
