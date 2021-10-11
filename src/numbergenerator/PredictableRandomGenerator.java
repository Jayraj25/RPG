package numbergenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to generate predictable random number which will be helpful in testing.
 * */
public class PredictableRandomGenerator implements RandomGenerator {

  List<Integer> args = new ArrayList<>();

  /**
   * Constructs predictable random generator.
   * @param args the variable number of numbers to be used for testing purpose
   * */
  public PredictableRandomGenerator(int... args) {
    for (int a: args) {
      this.args.add(a);
    }
  }

  @Override
  public int getNumber(int min, int max) {
    return generatorHelper(args);
  }

  private int generatorHelper(List<Integer> args) {

    List<Integer> arr = new ArrayList<>();
    for (int a : args) {
      arr.add(a);
    }
    int randomNum = arr.get(1);
    arr.remove(1);
    return randomNum;
  }
}
