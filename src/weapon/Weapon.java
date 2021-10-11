package weapon;

import numbergenerator.RandomGenerator;

/**
 * Get Strike power of different types of weapons
 * using random number which will used to monitor player's health.
 * */
public interface Weapon {

  /**
   * Calculates the damage caused by different weapons based on rolling of dice.
   * @return the damage caused by the weapon
   * */
  int getWeaponDamage(RandomGenerator g);
}
