package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Creates Broad swords for battle.
 * */
public class BroadSwords extends AbstractSword {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(6,10);
  }

  @Override
  public WeaponTypes getTypeOfWeapon() {
    return WeaponTypes.BROADSWORD;
  }
}
