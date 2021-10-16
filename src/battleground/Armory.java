package battleground;

import weapon.Weapon;

import java.util.List;

/**
 * Create a space where different types of weapon will be there
 * and a player will pick one weapon from there.
 */
public interface Armory {

  /**
   * Get the number of katanas in the armory.
   * @return the number of katanas
   */
  int getNoOfKatana();

  /**
   * Get the number of broad swords in the armory.
   * @return the number of broad swords.
   */
  int getNoOfBroadSword();

  /**
   * Get the number of Two Handed swords in the armory.
   * @return the number of Two handed swords.
   */
  int getNoOfTwoHandedSword();

  /**
   * Get the number of axes in the armory.
   * @return the number of axes.
   */
  int getNoOfAxe();

  /**
   * Get the number of flails in the armory.
   * @return the number of flails.
   */
  int getNoOfFlail();

  /**
   * Method that creates an armory which will be available to
   * players for choice of weapon before the battle starts.
   * */
  List<Weapon> generateArmory();

  @Override
  String toString();
}
