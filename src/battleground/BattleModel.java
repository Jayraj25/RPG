package battleground;

import gear.Gear;
import player.Player;

import java.util.List;

/**
 * A place where all the operations regarding battle takes place.
 * */
public class BattleModel implements BattleArena {

  private Player p1;
  private Player p2;
  private Player attacker;
  private Player defender;
  private int player1StrikeCount = 0;
  private int player2StrikeCount = 0;

  public BattleModel(Player p1, Player p2) {
    this.p1 = p1;
    this.p2 = p2;
  }

  @Override
  public void battle() {
    attacker = makeFirstMove();
    if (attacker == p1) {
      defender = p2;
    }
    defender = p1;
    makeMove();
    getTurn();
    while (p1.getPlayerHealth() > 0 && p2.getPlayerHealth() > 0) {
      makeMove();
      getTurn();
      System.out.println("Player 1 health: " + p1.getPlayerHealth());
      System.out.println("Player 2 health: " + p2.getPlayerHealth());
    }

  }

  @Override
  public void getTurn() {
    if (attacker == p1) {
      attacker = p2;
      defender = p1;
    }
    else {
      attacker = p1;
      defender = p2;
    }
  }

  @Override
  public Player getWinner() throws IllegalAccessException {
    if (p1.getPlayerHealth() > 0 && p2.getPlayerHealth() > 0) {
      throw new IllegalAccessException("Game still going on");
    }
    else if (p1.getPlayerHealth() <= 0) {
      return p2;
    }
    return p1;
  }

  @Override
  public Player makeFirstMove() {
    if (p1.getCharisma() > p2.getCharisma()) {
      return p1;
    }
    else {
      return p2;
    }
  }

  @Override
  public boolean isGameOver() {
    return p1.getPlayerHealth() <= 0 || p2.getPlayerHealth() <= 0;
  }

  @Override
  public void makeMove() {
    if (attacker.getStrikingPower() > defender.getAvoidanceAbility()) {
      System.out.println("The striking power of P" + attacker.getPlayerID() + " is " + attacker.getStrikingPower());
      defender.getActualDamage(attacker);
    }
  }
}
