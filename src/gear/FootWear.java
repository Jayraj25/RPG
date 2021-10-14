package gear;

import java.util.HashMap;
import java.util.Map;

import player.Player;
import player.PlayerAbilities;

/**
 * Creates the Footwear and Helps in getting how much
 * it affects a player's ability. It affects player's dexterity ability.
 */
public class FootWear extends AbstractGear {

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
  public void mountGear(Player p) {
    p.setDexterity(p.getDexterity() + 4);
  }
}
