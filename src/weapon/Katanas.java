package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Creates Katanas weapon for battle.
 * */
public class Katanas extends AbstractSword {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(8,12);
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
