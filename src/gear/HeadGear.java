package gear;

import java.util.HashMap;
import java.util.Map;

import player.Player;
import player.PlayerAbilities;

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
  public void mountGear(Player p) {
    p.setConstitution(p.getConstitution() + 5);
  }
}
