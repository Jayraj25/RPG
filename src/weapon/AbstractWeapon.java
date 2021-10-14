package weapon;

import numbergenerator.GenerateRandomNumber;

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
