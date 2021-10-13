package gear;

import java.util.HashMap;
import java.util.Map;

import player.Player;

/**
 * Creates the Footwear and Helps in getting how much
 * it affects a player's ability. It affects player's dexterity ability.
 */
public class FootWear extends AbstractGear {


  protected FootWear(String gearName) {
    super(gearName);
  }

  @Override
  public Map<String, Integer> getAffectOnPlayerAbility() {
    temp.put("Dexterity", 4);
    return temp;
  }

  @Override
  public Map<String, Integer> getAbilityMap() {
    Map<String, Integer> x = getAffectOnPlayerAbility();
    return x;
  }

  @Override
  public void mountGear(Player p) {
    p.setDexterity(p.getDexterity() + 4);
  }
}
