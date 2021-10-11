package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Class that helps in getting damage caused by flails.
 */
public class Flails implements Weapon {

  @Override
  public int getWeaponDamage(GenerateRandomNumber g) {
    return g.getRandomNumber(8,12);
  }

  @Override
  public String getTypeOfWeapon() {
    return "Flail";
  }
}
