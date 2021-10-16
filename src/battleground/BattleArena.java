package battleground;

import player.Player;

import java.util.List;


/**
 * A place where the players will enter the ground and equip
 * themselves with weapons and gears and will fight for the win.
 * */
public interface BattleArena {

  /**
   * Get the winner if the game is over.
   * @return the winner of the battle
   * @throws IllegalStateException if accessed before the game is over.
   */
  Player getWinner() throws IllegalStateException;

  /**
   * Decide which is the player having next turn to attack.
   * @return list containing the attacker and defender name respectively
   * */
  List<String> getTurn();

  /**
   * Check if the battle is over or not.
   * @return true or false based on the result.
   * */
  boolean isGameOver();

  /**
   * The attacker attacks and the defender defends based on the striking power and avoidance
   * abilities and returns attacker name, defender name, striking power, avoidance ability, and
   * the round winner and the actual damage.
   *
   * @return the list of strings
   */
  List<String> makeMove();

  /**
   * Get the current round of battle going on.
   * @return the round number as integer
   * */
  int getTrackRounds();

  /**
   * Equip gears for both the players.
   * @param p the player
   */
  void equipGears(Player p);

  @Override
  String toString();

  /**
   * Return the players participating in the battle.
   * @return the player
   */
  Player getPlayer1();

  /**
   * Return the players participating in the battle.
   * @return the player
   */
  Player getPlayer2();
}
