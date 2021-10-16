package gear;

import player.PlayerAbilities;

import java.util.Map;


/**
 * Creates the Footwear and Helps in getting how much
 * it affects a player's ability. It affects player's dexterity ability.
 */
class FootWear extends AbstractGear {

  protected FootWear(String gearName) {
    super(gearName);
    gearCategory = GearCategory.FOOTWEAR;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAffectOnPlayerAbility() {
    temp.put(PlayerAbilities.DEXTERITY, 4);
    return temp;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAbilityMap() {
    Map<PlayerAbilities, Integer> x = getAffectOnPlayerAbility();
    return x;
  }

  @Override
  public GearCategory getGearCategory() {
    return gearCategory;
  }

  @Override
  protected int compareToFootwear(FootWear that) {
    Integer m = Integer.parseInt(that.getName().split(" ")[1]);
    Integer n = Integer.parseInt(this.getName().split(" ")[1]);
    return m.compareTo(n);
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return that.compareToFootwear(this);
    }
    return -1;
  }

  @Override
  public String toString() {
    return "Footwear created successfully.";
  }
}
