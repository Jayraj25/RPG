package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Abstract class for sword which is in turn extended by Katanas, Two handed and
 * broad swords type respectively.
 * */
abstract class AbstractSword implements Weapon {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return 0;
  }

  @Override
  public WeaponTypes getTypeOfWeapon() {
    return null;
  }
}
