package weapon;

import numbergenerator.RandomGenerator;

/**
 * Class that helps in getting damage caused by flails.
 */
public class Flails implements Weapon {

  @Override
  public int getWeaponDamage(RandomGenerator g) {
    return g.getNumber(8,12);
  }
}
