package numbergenerator;

/**
 * Class which helps in generating random number which
 * can't be predicted and can be used for main program.
 * */
public class UnknownRandomGenerator implements RandomGenerator {

  @Override
  public int getNumber(int min, int max) {
    return generatorHelper(min, max);
  }

  private int generatorHelper(int min, int max) {
    return (int) (Math.random() * (max - min + 1) + min);
  }
}
