package weapon;

import numbergenerator.GenerateRandomNumber;

/**
 * Get Strike power of different types of weapons
 * using random number which will used to monitor player's health.
 * */
public interface Weapon {

  /**
   * Calculates the damage caused by different weapons based on rolling of dice.
   * @return the damage caused by the weapon
   * */
  int getWeaponDamage(GenerateRandomNumber g);

  /**
   * Get what type of weapon is created.
   * @return the type of weapon*/
  String getTypeOfWeapon();
}
