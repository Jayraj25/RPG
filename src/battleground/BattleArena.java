package battleground;

import player.Player;

/**
 * A place where the players will enter the ground and equip
 * themselves with weapons and gears and will fight for the win.
 * */
public interface BattleArena {

  void equipmentBag();

  int getPlayerHealth();

  int getStrikingPower();

  int getAvoidanceAbility();

  int getPotentialStrikingDamage();

  int actualDamage();

  Player getWinner();

  Player getTurn();

  boolean isGameOver();

  void makeMove();

}
