package gear;

import player.PlayerAbilities;

import java.util.Map;

/**
 * Create different gears and get the affects of the gear on player's health.
 */
public interface Gear {

  /**
   * Gets how much the player's ability is affected.
   * @return Ability mapped to its effect by a gear
   * */
  Map<PlayerAbilities, Integer> getAffectOnPlayerAbility();

  /**
   * Gets the abilities map after updating.
   * @return Abilities mapped with effect
   * */
  Map<PlayerAbilities, Integer> getAbilityMap();

  /**
   * Returns the flag indicator to check if the player's abilities are updated.
   * @return the boolean value of flag
   * */
  boolean getFlag();

  /**
   * Used to set the value to true once the map is updated.
   * @param flag the value to be used to update
   * */
  void setFlag(boolean flag);

  /**
   * Gets the name of the gear.
   * @return the name of the gear
   * */
  String getName();

  /**
   * Get what of gear it is (Belt, potion, headgear, footwear).
   * @return gear category
   * */
  GearCategory getGearCategory();

  /**
   * Gets the type of the belt constructed.
   * @return belt type
   * @throws IllegalAccessException if access is not allowed to that gear object
   */
  BeltTypes getBeltType() throws IllegalAccessException;

  /**
   * get the assigned units of that gear.
   * @return the gear unit
   * @throws IllegalAccessException if access is not allowed to that gear object
   */
  int getGearUnit() throws IllegalAccessException;
}
