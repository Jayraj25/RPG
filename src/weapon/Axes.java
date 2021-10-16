package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Class that helps in getting damage caused by axes.
 * */
public class Axes extends AbstractWeapon {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(6,10);
  }

  @Override
  public WeaponTypes getTypeOfWeapon() {
    return WeaponTypes.AXE;
  }

  @Override
  public String toString() {
    return "Axe created successfully.";
  }
}
