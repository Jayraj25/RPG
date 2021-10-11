package numbergenerator;

/**
 * Interface for creating random numbers which are used in testing and main as well.
 * */
public interface RandomGenerator {

  /**
   * Get the random number generated.
   * @param min the minimum limit
   * @param max the max limit
   * @return the number generated
   */
  int getNumber(int min, int max);
}
