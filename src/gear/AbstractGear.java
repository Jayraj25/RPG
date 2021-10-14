package gear;

import player.Player;
import player.PlayerAbilities;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractGear implements Gear {

  protected final String gearName;
  protected Map<PlayerAbilities, Integer> temp = new HashMap<>();
  protected GearCategory gearCategory;

  protected boolean flag = false;

  protected AbstractGear(String gearName) {
    this.gearName = gearName;
  }

  @Override
  public void mountGear(Player p) {
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
  public BeltTypes getBeltType() throws IllegalAccessException {
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
