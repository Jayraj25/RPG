package gear;

import player.Player;

/**
 * Creates the headGear and Helps in getting how much
 * it affects a player's ability. It affects player's constitution ability.
 * */
public class HeadGear implements Gear {

  @Override
  public void mountGear(Player p) {
    p.setConstitution(p.getConstitution() + 5);
  }
}
