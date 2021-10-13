package gear;

import java.util.List;
import java.util.Map;

import player.Player;

/**
 * Create different gears and get the affects of the gear on player's health.
 */
public interface Gear {

  /**
   * get the affect of different gear on player's health.
   * @param p the player
   */
  void mountGear(Player p);

  /**
   * Gets how much the player's ability is affected.
   * @return Ability mapped to its effect by a gear
   * */
  Map<String, Integer> getAffectOnPlayerAbility();

  /**
   * Gets the abilities map after updating.
   * @return Abilities mapped with effect
   * */
  Map<String, Integer> getAbilityMap();

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
   * Gets the type of the belt constructed.
   * @return belt type
   * @throws IllegalAccessException if access is not allowed to that gear object
   */
  BeltTypes getBeltType() throws IllegalAccessException;

  /**
   * Gets the type of the potion created.
   * @return potion type
   * @throws IllegalAccessException if access is not allowed to that gear object
   */
  PotionTypes getPotionType() throws IllegalAccessException;

  /**
   * get the assigned units of that gear.
   * @return the gear unit
   * @throws IllegalAccessException if access is not allowed to that gear object
   */
  int getGearUnit() throws IllegalAccessException;
}
