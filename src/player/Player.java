package player;

import battleground.PlayerModel;
import gear.Gear;
import gear.GearCategory;
import numbergenerator.GenerateRandomNumber;
import weapon.Weapon;
import weapon.WeaponTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates the player for the battle.
 * */
public class Player {

  private final int playerID;
  private final GenerateRandomNumber g;
  private List<Gear> equippedGears = new ArrayList<>();
  Map<PlayerAbilities,Integer> abilitiesMap = new HashMap<>();
  PlayerModel m = new PlayerModel();
  private Weapon weaponEquipped;
  private WeaponTypes weaponEquippedType;
  Map<PlayerAbilities, Integer> updatedAbilitiesMap = abilitiesMap;
  private boolean abilitiesUpdated = false;
  private int playerHealth;
  private int strikingPower;
  private int avoidanceAbility;
  private int potentialStrikingDamage;
  private int actualDamage;

  /**
   * Constructs a player.
   * @param g the type of random generator to be used
   * */
  public Player(int ID, GenerateRandomNumber g) {
    this.playerID = ID;
    this.g = g;
    this.weaponEquippedType = WeaponTypes.BARE_HANDS;
//    for (Map.Entry<PlayerAbilities, Integer> m : abilitiesMap.entrySet()) {
//      updatedAbilitiesMap.put(m.getKey(),m.getValue());
//    }
  }

  /**
   * Create the attributes of the player.
   * */
  public void setProperties() {
    for (PlayerAbilities a: PlayerAbilities.values()) {
      abilitiesMap.put(a,generateProperty());
    }
  }

  private int generateProperty() {
    int[] arr = new int[4];
    int result = 0;
    for (int i = 0; i < 4; i++) {
      arr[i] = rollDice(g);
    }
    Arrays.sort(arr);
    for (int i = 1; i < 4; i++) {
      result += arr[i];
    }
    return result;
  }

  /**
   * Sets the strength ability of the player.
   * @param strength the strength
   * */
  public void setStrength(int strength) {
    abilitiesMap.put(PlayerAbilities.STRENGTH,strength);
  }

  /**
   * Sets the constitution ability of the player.
   * @param constitution the constitution
   * */
  public void setConstitution(int constitution) {
    abilitiesMap.put(PlayerAbilities.CONSTITUTION,constitution);
  }

  /**
   * Sets the dexterity of the player.
   * @param dexterity the dexterity
   * */
  public void setDexterity(int dexterity) {
    abilitiesMap.put(PlayerAbilities.DEXTERITY,dexterity);
  }

  /**
   * Sets the charisma of the player.
   * @param charisma the charisma
   * */
  public void setCharisma(int charisma) {
    abilitiesMap.put(PlayerAbilities.CHARISMA,charisma);
  }

  private int rollDice(GenerateRandomNumber g) {
    int temp = g.getRandomNumber(1,6);
    while (temp < 2) {
      temp = g.getRandomNumber(1,6);
    }
    return temp;
  }

  public int getPlayerID() {
    return playerID;
  }

  public int getStrength() {
    return abilitiesMap.get(PlayerAbilities.STRENGTH);
  }

  public int getConstitution() {
    return abilitiesMap.get(PlayerAbilities.CONSTITUTION);
  }

  public int getDexterity() {
    return abilitiesMap.get(PlayerAbilities.DEXTERITY);
  }

  public int getCharisma() {
    return abilitiesMap.get(PlayerAbilities.CHARISMA);
  }

  @Override
  public String toString() {
    return String.format("(Strength: %d, Constitution: %d, Dexterity: %d, Charisma: %d)",
            getStrength(),getConstitution(),getDexterity(),getCharisma());
  }

  /**
   * Equip 20 gears from the bag of equipments.
   * */
  public void equipGears() {
    equippedGears = m.equipGears();
  }

  /**
   * Makes the changes in abilities once the gears are equipped and after each round.
   * @throws IllegalAccessException if gears not equipped
   * */
  public Map<PlayerAbilities, Integer> makeChangesInAbilities() throws IllegalAccessException {
    System.out.println(updatedAbilitiesMap);
    List<Gear> gearList = equippedGears;
    if (gearList.size() == 0) {
      throw new IllegalAccessException("Access not allowed until gears are not equipped");
    }
    for (Gear gear : gearList) {
      int gearUnit = 1;
      if (gear.equals(GearCategory.BELT)) {
        gearUnit = gear.getGearUnit();
      }
      Map<PlayerAbilities,Integer> abilityMap = gear.getAbilityMap();
      for (Map.Entry<PlayerAbilities,Integer> m : abilityMap.entrySet()) {
        int x = updatedAbilitiesMap.get(m.getKey());
        x += m.getValue();
        updatedAbilitiesMap.put(m.getKey(),x * gearUnit);
      }
    }
    abilitiesUpdated = true;
    computeTotalHealth();
    return updatedAbilitiesMap;
  }

  public Map<PlayerAbilities, Integer> getAbilitiesMap() {
    return abilitiesMap;
  }

  public Map<PlayerAbilities, Integer> getUpdatedAbilitiesMap() {
    return updatedAbilitiesMap;
  }

  /** Get the list of equipped gears.
   * @return the list of gears
   * @throws IllegalAccessException if getting the list without equipping the gears from bag
   */
  public List<Gear> getEquippedGears() throws IllegalAccessException {
    if (equippedGears.size() == 0) {
      throw new IllegalAccessException("Gears yet not equipped");
    }
    return equippedGears;
  }

  /**
   * Randomly pick a weapon from the armory.
   * @param armory the list of weapons
   * */
  public void equipWeapon(List<Weapon> armory) throws IllegalStateException {
    if (armory.size() == 0) {
      throw new IllegalStateException("Armory not created");
    }
    weaponEquipped = m.equipWeapon(armory);
    setWeaponEquippedType(weaponEquipped.getTypeOfWeapon());
    System.out.println(weaponEquipped);
  }

  /**
   * Get the weapon equipped by the player.
   * @return the weapon
   */
  public WeaponTypes getWeaponEquipped() {
    return weaponEquippedType;
  }

  private void setWeaponEquippedType(WeaponTypes type) {
    this.weaponEquippedType = type;
  }

  /**
   * Get the type of the weapon equipped.
   * @return the weapon type
   * */
  public WeaponTypes getWeaponEquippedType() {
    return this.weaponEquippedType;
  }

  private void computeTotalHealth() {
    for (Map.Entry<PlayerAbilities,Integer> m : updatedAbilitiesMap.entrySet()) {
      playerHealth += m.getValue();
    }
  }

  /**
   * Gets the total health computed.
   * @return total health
   */
  public int getPlayerHealth() {
    return this.playerHealth;
  }

  private void computeStrikingPower() {
    strikingPower = updatedAbilitiesMap.get(PlayerAbilities.STRENGTH) + g.getRandomNumber(0,10);
  }

  public int getStrikingPower() {
    computeStrikingPower();
    return strikingPower;
  }

  private void computeAvoidanceAbility() {
    avoidanceAbility = updatedAbilitiesMap.get(PlayerAbilities.DEXTERITY) + g.getRandomNumber(0,6);
  }

  public int getAvoidanceAbility() {
    computeAvoidanceAbility();
    return avoidanceAbility;
  }

  private void computePotentialStrikingDamage() {
    potentialStrikingDamage = updatedAbilitiesMap.get(PlayerAbilities.STRENGTH)
            + weaponEquipped.getWeaponDamage(g);
  }

  public int getPotentialStrikingDamage() {
    computePotentialStrikingDamage();
    return potentialStrikingDamage;
  }

  private void computeActualDamage(Player p) {
    actualDamage = p.getPotentialStrikingDamage()
            - updatedAbilitiesMap.get(PlayerAbilities.CONSTITUTION);
  }

  /**
   * Get the actual damage caused when hit by an opponent.
   * @param p the opponent player
   * @return the damage caused
   */
  public int getActualDamage(Player p) {
    computeActualDamage(p);
    if (actualDamage > 0) {
      playerHealth -= actualDamage;
    }
    return actualDamage;
  }
}
