package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Creates Two handed swords for battle.
 * */
public class TwoHandedSwords extends AbstractSword {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(8,12);
  }

  @Override
  public String getTypeOfWeapon() {
    return "Two handed sword";
  }
}
