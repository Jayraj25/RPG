package battleground;

import weapon.Weapon;

import java.util.List;

/**
 * Create a space where different types of weapon will be there
 * and a player will pick one weapon from there.
 */
public interface Armory {

  /**
   * Method that creates an armory which will be available to
   * players for choice of weapon before the battle starts.
   * */
  List<Weapon> generateArmory();

  @Override
  String toString();
}
