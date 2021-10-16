package gear;


import numbergenerator.GenerateRandomNumber;
import player.PlayerAbilities;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates the Belts gear and Helps in getting how much
 * it affects a player's ability. It affects player's dexterity and constitution ability.
 */
class Belts extends AbstractGear {

  GenerateRandomNumber g = new GenerateRandomNumber(4);
  private BeltTypes size;
  private final int beltUnit;

  /**
   * Constructs belts as gear.
   * @param gearName the name assigned to this gear
   * */
  public Belts(String gearName) {
    super(gearName);
    int temp = g.getRandomNumber(1, 4);
    while (temp == 3) {
      temp = g.getRandomNumber(1, 4);
    }
    assignBelts(temp);
    beltUnit = temp;
    gearCategory = GearCategory.BELT;
  }

  private void assignBelts(int num) {
    if (num == 1) {
      size = BeltTypes.SMALL;
    }
    else if (num == 2) {
      size = BeltTypes.MEDIUM;
    }
    else if (num == 4) {
      size = BeltTypes.LARGE;
    }
  }

  @Override
  public Map<PlayerAbilities, Integer> getAffectOnPlayerAbility() {
    temp.put(PlayerAbilities.CONSTITUTION, 3);
    temp.put(PlayerAbilities.DEXTERITY, 1);
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
      x.put(PlayerAbilities.CONSTITUTION, 3);
      x.put(PlayerAbilities.DEXTERITY, 1);
      return x;
    }
  }

  @Override
  public GearCategory getGearCategory() {
    return gearCategory;
  }

  @Override
  public BeltTypes getBeltType() {
    return size;
  }

  @Override
  public int getGearUnit() {
    return beltUnit;
  }

  @Override
  protected int compareToBelt(Belts that) {
    Integer m = Integer.parseInt(that.getName().split(" ")[1]);
    Integer n = Integer.parseInt(this.getName().split(" ")[1]);
    return m.compareTo(n);
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return that.compareToBelt(this);
    }
    return -1;
  }

  @Override
  public String toString() {
    return "Belt created successfully.";
  }
}
