package battleground;

import gear.Gear;
import player.Player;

import java.util.List;

/**
 * A place where the players will enter the ground and equip
 * themselves with weapons and gears and will fight for the win.
 * */
public interface BattleArena {

  void battle();

  Player getWinner() throws IllegalAccessException;

  void getTurn();

  Player makeFirstMove();

  boolean isGameOver();

  void makeMove();

}
