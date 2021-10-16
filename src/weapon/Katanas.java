package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Creates Katanas for battle.
 * */
public class Katanas extends AbstractSword {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(4,6);
  }

  @Override
  public WeaponTypes getTypeOfWeapon() {
    return WeaponTypes.KATANA;
  }

  @Override
  public String toString() {
    return "Katana created successfully.";
  }
}
