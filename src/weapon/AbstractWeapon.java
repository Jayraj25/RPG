package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Abstract class for weapon which can be used for extensibility
 * and to add any new functionalities shared by all child classes.
 */
abstract class AbstractWeapon implements Weapon {

  protected WeaponTypes weaponType = WeaponTypes.BARE_HANDS;

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return 0;
  }

  @Override
  public WeaponTypes getTypeOfWeapon() {
    return weaponType;
  }
}
