package player;

import battleground.PlayerModel;
import gear.Gear;
import gear.GearCategory;
import numbergenerator.GenerateRandomNumber;
import weapon.Weapon;
import weapon.WeaponTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Creates the player for the battle with operations to be done on player.
 * */
public class PlayerGenerator implements Player {

  private final String playerName;
  private final GenerateRandomNumber g;
  private List<Gear> equippedGears = new ArrayList<>();
  private final Map<PlayerAbilities,Integer> abilitiesMap = new HashMap<>();
  PlayerModel m = new PlayerModel();
  private Weapon weaponEquipped;
  private WeaponTypes weaponEquippedType;
  Map<PlayerAbilities, Integer> updatedAbilitiesMap = abilitiesMap;
  private int playerHealth;
  private int strikingPower;
  private int avoidanceAbility;
  private int potentialStrikingDamage;
  private int actualDamage;

  /**
   * Constructs a player.
   * @param g the type of random generator to be used
   * */
  public PlayerGenerator(String name, GenerateRandomNumber g) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null");
    }
    this.playerName = name;
    this.g = g;
    this.weaponEquippedType = WeaponTypes.BARE_HANDS;
  }

  @Override
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

  @Override
  public void setStrength(int strength) {
    abilitiesMap.put(PlayerAbilities.STRENGTH,strength);
  }

  @Override
  public void setConstitution(int constitution) {
    abilitiesMap.put(PlayerAbilities.CONSTITUTION,constitution);
  }

  @Override
  public void setDexterity(int dexterity) {
    abilitiesMap.put(PlayerAbilities.DEXTERITY,dexterity);
  }

  @Override
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

  @Override
  public String getPlayerName() {
    return playerName;
  }

  @Override
  public int getStrength() {
    return abilitiesMap.get(PlayerAbilities.STRENGTH);
  }

  @Override
  public int getConstitution() {
    return abilitiesMap.get(PlayerAbilities.CONSTITUTION);
  }

  @Override
  public int getDexterity() {
    return abilitiesMap.get(PlayerAbilities.DEXTERITY);
  }

  @Override
  public int getCharisma() {
    return abilitiesMap.get(PlayerAbilities.CHARISMA);
  }

  @Override
  public String toString() {
    return String.format("(Strength: %d, Constitution: %d, Dexterity: %d, Charisma: %d)",
            getStrength(),getConstitution(),getDexterity(),getCharisma());
  }

  @Override
  public void makeChangesInAbilities() throws IllegalAccessException {
    List<Gear> gearList = equippedGears;
    if (gearList.size() == 0) {
      throw new IllegalAccessException("Access not allowed until gears are not equipped");
    }
    for (Gear gear : gearList) {
      int gearUnit = 1;
      if (gear.getGearCategory().equals(GearCategory.BELT)) {
        gearUnit = gear.getGearUnit();
      }
      Map<PlayerAbilities,Integer> abilityMap = gear.getAbilityMap();
      for (Map.Entry<PlayerAbilities,Integer> m : abilityMap.entrySet()) {
        int x = updatedAbilitiesMap.get(m.getKey());
        x += m.getValue() * gearUnit;
        updatedAbilitiesMap.put(m.getKey(),x);
      }
    }
    computeTotalHealth();
  }

  @Override
  public Map<PlayerAbilities, Integer> getAbilitiesMap() {
    return abilitiesMap;
  }

  @Override
  public Map<PlayerAbilities, Integer> getUpdatedAbilitiesMap() {
    return updatedAbilitiesMap;
  }

  @Override
  public void setEquippedGears(List<Gear> equippedGears) {
    this.equippedGears = equippedGears;
  }

  @Override
  public List<Gear> getEquippedGears() throws IllegalAccessException {
    if (equippedGears.size() == 0) {
      throw new IllegalAccessException("Gears yet not equipped");
    }
    return equippedGears;
  }

  @Override
  public void equipWeapon(List<Weapon> armory) throws IllegalStateException {
    if (armory.size() == 0) {
      throw new IllegalStateException("Armory not created");
    }
    weaponEquipped = m.equipWeapon(armory);
    setWeaponEquippedType(weaponEquipped.getTypeOfWeapon());
  }

  @Override
  public WeaponTypes getWeaponEquipped() {
    return weaponEquippedType;
  }

  private void setWeaponEquippedType(WeaponTypes type) {
    this.weaponEquippedType = type;
  }


  @Override
  public WeaponTypes getWeaponEquippedType() {
    return this.weaponEquippedType;
  }

  private void computeTotalHealth() {
    for (Map.Entry<PlayerAbilities,Integer> m : updatedAbilitiesMap.entrySet()) {
      playerHealth += m.getValue();
    }
  }

  @Override
  public int getPlayerHealth() {
    return this.playerHealth;
  }

  private void computeStrikingPower() {
    strikingPower = updatedAbilitiesMap.get(PlayerAbilities.STRENGTH) + g.getRandomNumber(1,10);
  }

  @Override
  public int getStrikingPower() {
    computeStrikingPower();
    return strikingPower;
  }

  private void computeAvoidanceAbility() {
    avoidanceAbility = updatedAbilitiesMap.get(PlayerAbilities.DEXTERITY) + g.getRandomNumber(1,6);
  }

  @Override
  public int getAvoidanceAbility() {
    computeAvoidanceAbility();
    return avoidanceAbility;
  }

  private void computePotentialStrikingDamage() {
    int damage = weaponEquipped.getWeaponDamage(g);
    if (weaponEquippedType.equals(WeaponTypes.TWO_HANDED_SWORD)
            && updatedAbilitiesMap.get(PlayerAbilities.STRENGTH) <= 14) {
      damage /= 2;
    }
    if (weaponEquippedType.equals(WeaponTypes.FLAIL)
            && updatedAbilitiesMap.get(PlayerAbilities.DEXTERITY) <= 14) {
      damage /= 2;
    }

    potentialStrikingDamage = updatedAbilitiesMap.get(PlayerAbilities.STRENGTH) + damage;
  }

  @Override
  public int getPotentialStrikingDamage() {
    computePotentialStrikingDamage();
    return potentialStrikingDamage;
  }

  private void computeActualDamage(Player p) {
    actualDamage = p.getPotentialStrikingDamage()
            - updatedAbilitiesMap.get(PlayerAbilities.CONSTITUTION);
  }

  @Override
  public int getActualDamage(Player p) {
    computeActualDamage(p);
    if (actualDamage > 0) {
      playerHealth -= actualDamage;
    }
    return actualDamage;
  }

  @Override
  public List<String> sortGears() {
    Collections.sort(equippedGears);
    List<String> gearNamesSortedOrder = new ArrayList<>();
    for (Gear s : equippedGears) {
      gearNamesSortedOrder.add(s.getName());
    }
    return gearNamesSortedOrder;
  }
}
