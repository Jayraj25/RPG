package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * If bare hands are used as weapon in the battle.
 * */
public class BareHands extends AbstractWeapon {
  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(0,5);
  }

  @Override
  public WeaponTypes getTypeOfWeapon() {
    return WeaponTypes.BARE_HANDS;
  }
}
