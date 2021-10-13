package gear;

import java.util.HashMap;
import java.util.Map;

import player.Player;

public class AbstractGear implements Gear {

  protected final String gearName;
  protected Map<String, Integer> temp = new HashMap<>();

  protected boolean flag = false;

  protected AbstractGear(String gearName) {
    this.gearName = gearName;
  }

  @Override
  public void mountGear(Player p) {
  }

  @Override
  public Map<String, Integer> getAffectOnPlayerAbility() {
    return null;
  }

  @Override
  public Map<String, Integer> getAbilityMap() {
    return temp;
  }

  @Override
  public String getName() {
    return gearName;
  }

  @Override
  public BeltTypes getBeltType() throws IllegalAccessException {
    throw new IllegalAccessException("Access not allowed");
  }

  @Override
  public PotionTypes getPotionType() throws IllegalAccessException {
    throw new IllegalAccessException("Access not allowed");
  }

  @Override
  public int getGearUnit() throws IllegalAccessException {
    throw new IllegalAccessException("Access not allowed");
  }

  public boolean getFlag() {
    return flag;
  }

  public void setFlag(boolean flag) {
    this.flag = flag;
  }
}
