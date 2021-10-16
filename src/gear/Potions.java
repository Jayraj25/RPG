package gear;

import numbergenerator.GenerateRandomNumber;
import player.PlayerAbilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates the Potions and Helps in getting how much it affects a player's ability.
 */
public class Potions extends AbstractGear {

  GenerateRandomNumber g = new GenerateRandomNumber(2);
  private final int potionUnit;
//  boolean flag = false;

  /**
   * Constructs potions with a map that keeps a track of
   * which and how many potions taken by a player.
   * */
  public Potions(String gearName) {
    super(gearName);
    potionUnit = g.getRandomNumber(2, 6);
    gearCategory = GearCategory.POTION;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAffectOnPlayerAbility() {
    temp.put(PlayerAbilities.CONSTITUTION, g.getRandomNumber(0,5));
    temp.put(PlayerAbilities.DEXTERITY, g.getRandomNumber(0,4));
    temp.put(PlayerAbilities.CHARISMA, g.getRandomNumber(2,6));
    temp.put(PlayerAbilities.STRENGTH, g.getRandomNumber(0,8));
    setFlag(true);
    return temp;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAbilityMap() {
    if (getFlag()) {
      return temp;
    }
    else {
      Map<PlayerAbilities, Integer> x = new HashMap<>();
      x.put(PlayerAbilities.CONSTITUTION, g.getRandomNumber(0,5));
      x.put(PlayerAbilities.DEXTERITY, g.getRandomNumber(0,4));
      x.put(PlayerAbilities.CHARISMA, g.getRandomNumber(2,6));
      x.put(PlayerAbilities.STRENGTH, g.getRandomNumber(0,8));
      return x;
    }
  }

  @Override
  public GearCategory getGearCategory() {
    return gearCategory;
  }

  @Override
  public int getGearUnit() {
    return potionUnit;
  }

  @Override
  protected int compareToPotion(Potions that) {
    Integer m = Integer.parseInt(that.getName().split(" ")[1]);
    Integer n = Integer.parseInt(this.getName().split(" ")[1]);
    return m.compareTo(n);
  }

  @Override
  protected int compareToBelt(Belts that) {
    return 1;
  }


  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return that.compareToPotion(this);
    }
    return -1;
  }

}
