package gear;

import player.Player;

/**
 * Create different gears and get the affects of the gear on player's health.
 */
public interface Gear {

  /**
   * get the affect of different gear on player's health.
   * @param p the player
   */
  void mountGear(Player p);
}
