package gear;

import player.Player;

/**
 * Creates the Footwear and Helps in getting how much
 * it affects a player's ability. It affects player's dexterity ability.
 */
public class FootWear implements Gear {

  @Override
  public void mountGear(Player p) {
    p.setConstitution(p.getDexterity() + 4);
  }
}
