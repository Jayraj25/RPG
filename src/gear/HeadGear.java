package gear;

import java.util.HashMap;
import java.util.Map;

import player.Player;

/**
 * Creates the headGear and Helps in getting how much
 * it affects a player's ability. It affects player's constitution ability.
 * */
public class HeadGear extends AbstractGear {

  protected HeadGear(String gearName) {
    super(gearName);
  }

  @Override
  public Map<String, Integer> getAffectOnPlayerAbility() {
    temp.put("Constitution", 5);
    return temp;
  }

  @Override
  public Map<String, Integer> getAbilityMap() {
    Map<String,Integer> x = getAffectOnPlayerAbility();
    return x;
  }

  @Override
  public void mountGear(Player p) {
    p.setConstitution(p.getConstitution() + 5);
  }
}
