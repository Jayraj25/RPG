package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Class that helps in getting damage caused by axes.
 * */
public class Axes implements Weapon {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(6,10);
  }

  @Override
  public String getTypeOfWeapon() {
    return "Axe";
  }
}
