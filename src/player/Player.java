package player;

import gear.Gear;
import weapon.Weapon;
import weapon.WeaponTypes;

import java.util.List;
import java.util.Map;


/**
 * A player is created and computation regarding player takes place here like generating properties,
 * and computing player's power's during which are required during battle.
 * */
public interface Player {

  /**
   * Create the attributes of the player.
   * */
  void setProperties();

  /**
   * Sets the strength ability of the player.
   * @param strength the strength
   * */
  void setStrength(int strength);

  /**
   * Sets the constitution ability of the player.
   * @param constitution the constitution
   * */
  void setConstitution(int constitution);

  /**
   * Sets the dexterity of the player.
   * @param dexterity the dexterity
   * */
  void setDexterity(int dexterity);

  /**
   * Sets the charisma of the player.
   * @param charisma the charisma
   * */
  void setCharisma(int charisma);

  /**
   * method that returns player's name.
   * @return the name as string
   */
  String getPlayerName();

  /**
   * method that returns player's strength.
   * @return the strength as integer
   */
  int getStrength();

  /**
   * method that return player's constitution.
   * @return the constitution as integer
   */
  int getConstitution();

  /**
   * method that returns player's dexterity.
   * @return the dexterity as integer
   */
  int getDexterity();

  /**
   * method that returns player's charisma.
   * @return the charisma as integer
   */
  int getCharisma();

  /**
   * Makes the changes in abilities once the gears are equipped and after each round.
   * @throws IllegalStateException if gears not equipped
   * */
  void makeChangesInAbilities() throws IllegalStateException;

  /**
   * Return the map consisting of player's abilities and their current values.
   * @return player abilities mapped to value
   */
  Map<PlayerAbilities, Integer> getAbilitiesMap();

  /**
   * Return the map consisting of player's abilities and
   * their current values after equipping gears.
   * @return player abilities mapped to value
   */
  Map<PlayerAbilities, Integer> getUpdatedAbilitiesMap();

  /**
   * assign list of equipped gears to a player.
   * @param equippedGears the list of equipped gears
   */
  void setEquippedGears(List<Gear> equippedGears);

  /** Get the list of equipped gears.
   * @return the list of gears
   * @throws IllegalStateException if getting the list without equipping the gears from bag
   */
  List<Gear> getEquippedGears() throws IllegalStateException;

  /**
   * Randomly pick a weapon from the armory.
   * @param armory the list of weapons
   * */
  void equipWeapon(List<Weapon> armory) throws IllegalStateException;

  /**
   * Get the weapon equipped by the player.
   * @return the weapon
   */
  WeaponTypes getWeaponEquipped();

  /**
   * Get the type of the weapon equipped.
   * @return the weapon type
   * */
  WeaponTypes getWeaponEquippedType();

  /**
   * Compute the total health of a player based on the player's abilities
   * (sum of player's abilities).
   */
  void computeTotalHealth();

  /**
   * Gets the total health computed which is sum of 4 abilities of a player.
   * @return total health
   */
  int getPlayerHealth();


  /**
   * Striking power is the sum of the strength of the player, any of the gear that
   * adds (or subtracts) from strength, and a random number between 1 and 10.
   * @return the striking power
   * */
  int getStrikingPower();

  /**
   * Avoidance ability is the sum of the dexterity of the player, any of the gear that
   * adds (or subtracts) from dexterity, and a random number between 1 and 6.
   * @return the avoidance ability
   * */
  int getAvoidanceAbility();

  /**
   * The potential striking damage is calculated by adding the strength of the attacking player
   * to a random value in the range of the damage that
   * their weapon can inflict (if they have a weapon).
   * @return the potential striking damage
   * */
  int getPotentialStrikingDamage();

  /**
   * Get the actual damage caused when hit by an opponent.
   * @param p the opponent player
   * @return the damage caused
   */
  int getActualDamage(Player p);

  /**
   * Returns the list of gears in sorted order where the order should be all head gears,
   *  all potions, all belts, all footwear.
   * @return list of gears
   * */
  List<String> sortGears();
}
