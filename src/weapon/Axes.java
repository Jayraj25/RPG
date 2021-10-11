package weapon;

import numbergenerator.RandomGenerator;

/**
 * Class that helps in getting damage caused by axes.
 * */
public class Axes implements Weapon {

  @Override
  public int getWeaponDamage(RandomGenerator g) {
    return g.getNumber(6,10);
  }
}
