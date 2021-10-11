package weapon;

import numbergenerator.RandomGenerator;

/**
 * Class that helps in getting damage caused by swords.
 * */
public class Swords implements Weapon {

  private final SwordTypes type;

  /**
   * Constructs new swords based on the sword type provided.
   * @param type the type of the sword
   * */
  public Swords(SwordTypes type) {
    this.type = type;
  }


  @Override
  public int getWeaponDamage(RandomGenerator g) {
    if (type.toString().equals("Katanas")) {
      return g.getNumber(4,6);
    }
    else if (type.toString().equals("Broad Swords")) {
      return g.getNumber(6,10);
    }
    else if (type.toString().equals("Two Handed Swords")) {
      return g.getNumber(8,12);
    }
    else {
      throw new IllegalArgumentException("Unexpected Value");
    }
  }


}
