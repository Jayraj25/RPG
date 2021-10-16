package battleground;

import player.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * A place where all the operations regarding battle takes place.
 * */
public class BattleModel implements BattleArena {

  private final Player p1;
  private final Player p2;
  private Player attacker;
  private Player defender;
  private int trackRounds;
  PlayerModel pm = new PlayerModel();

  /**
   * Constructs battle which consists of two players.
   * @param p1 player 1
   * @param p2 player 2
   */
  public BattleModel(Player p1, Player p2) {
    this.p1 = p1;
    this.p2 = p2;
    this.trackRounds = 0;
    this.attacker = p1;
    this.defender = p2;
  }

  @Override
  public List<String> getTurn() {
    if (getTrackRounds() == 0) {
      if (p1.getCharisma() > p2.getCharisma()) {
        setAttacker(p1);
        setDefender(p2);
      }
      else {
        setAttacker(p2);
        setDefender(p1);
      }
    }
    else {
      if (attacker == p1) {
        setAttacker(p2);
        setDefender(p1);
      }
      else {
        setAttacker(p1);
        setDefender(p2);
      }
    }
    int temp = trackRounds + 1;
    setTrackRounds(temp);
    List<String> temp1 = new ArrayList<>();
    temp1.add(attacker.getPlayerName());
    temp1.add(defender.getPlayerName());
    return temp1;
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
  public boolean isGameOver() {
    return p1.getPlayerHealth() <= 0 || p2.getPlayerHealth() <= 0;
  }

  @Override
  public List<String> makeMove() {
    List<String> temp = getTurn();
    int actualDamage = 0;
    temp.add(String.valueOf(attacker.getStrikingPower()));
    temp.add(String.valueOf(defender.getAvoidanceAbility()));
    if (attacker.getStrikingPower() > defender.getAvoidanceAbility()) {
      temp.add(attacker.getPlayerName());
      actualDamage = defender.getActualDamage(attacker);
    }
    else {
      temp.add(defender.getPlayerName());
    }
    temp.add(String.valueOf(actualDamage));
    return temp;
  }

  @Override
  public int getTrackRounds() {
    return trackRounds;
  }

  private void setTrackRounds(int trackRounds) {
    this.trackRounds = trackRounds;
  }

  private void setAttacker(Player attacker) {
    this.attacker = attacker;
  }

  private void setDefender(Player defender) {
    this.defender = defender;
  }

  @Override
  public void equipGears(Player p) {
    pm.equipGears(p);
  }
}
