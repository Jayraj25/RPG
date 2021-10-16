package gear;

import player.PlayerAbilities;

import java.util.Map;


/**
 * Creates the headGear and Helps in getting how much
 * it affects a player's ability. It affects player's constitution ability.
 * */
public class HeadGear extends AbstractGear {

  protected HeadGear(String gearName) {
    super(gearName);
    gearCategory = GearCategory.HEADGEAR;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAffectOnPlayerAbility() {
    temp.put(PlayerAbilities.CONSTITUTION, 5);
    return temp;
  }

  @Override
  public Map<PlayerAbilities, Integer> getAbilityMap() {
    Map<PlayerAbilities,Integer> x = getAffectOnPlayerAbility();
    return x;
  }

  @Override
  public GearCategory getGearCategory() {
    return gearCategory;
  }

  @Override
  protected int compareToHeadGear(HeadGear that) {
    Integer m = Integer.parseInt(that.getName().split(" ")[1]);
    Integer n = Integer.parseInt(this.getName().split(" ")[1]);
    return m.compareTo(n);
  }

  @Override
  protected int compareToFootwear(FootWear that) {
    return 1;
  }

  @Override
  protected int compareToBelt(Belts that) {
    return 1;
  }

  @Override
  protected int compareToPotion(Potions that) {
    return 1;
  }

  @Override
  public int compareTo(Gear o) {
    if (o instanceof AbstractGear) {
      AbstractGear that = (AbstractGear) o;
      return that.compareToHeadGear(this);
    }
    return -1;
  }
}
