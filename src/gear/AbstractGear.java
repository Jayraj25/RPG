package gear;

import player.PlayerAbilities;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractGear implements Gear {

  protected final String gearName;
  protected Map<PlayerAbilities, Integer> temp = new HashMap<>();
  protected GearCategory gearCategory;

  protected boolean flag = false;

  protected AbstractGear(String gearName) {
    if (gearName == null) {
      throw new IllegalArgumentException("Gear name cannot be null");
    }
    this.gearName = gearName;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAffectOnPlayerAbility() {
    return null;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAbilityMap() {
    return temp;
  }

  @Override
  public String getName() {
    return gearName;
  }

  @Override
  public BeltTypes getBeltType() throws IllegalStateException {
    //throws an exception if class other than Belt class as only belt has Belt type.
    throw new IllegalStateException("Access not allowed");
  }

  @Override
  public int getGearUnit() throws IllegalStateException {
    //throws an exception if class other than potion and belt class.
    throw new IllegalStateException("Access not allowed");
  }

  @Override
  public boolean getFlag() {
    return flag;
  }

  @Override
  public void setFlag(boolean flag) {
    this.flag = flag;
  }

  protected int compareToHeadGear(HeadGear that) {
    return -1;
  }

  protected int compareToFootwear(FootWear that) {
    return 1;
  }

  protected int compareToBelt(Belts that) {
    return -1;
  }

  protected int compareToPotion(Potions that) {
    return -1;
  }
}
