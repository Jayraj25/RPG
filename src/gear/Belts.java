package gear;


import numbergenerator.RandomGenerator;
import numbergenerator.UnknownRandomGenerator;
import player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates the Belts gear and Helps in getting how much
 * it affects a player's ability. It affects player's dexterity and constitution ability.
 */
public class Belts implements Gear {

  Map<BeltTypes, Integer> beltsTrack = new HashMap<>();

  /**
   * Constructs belts as gear.
   * */
  public Belts() {
    for (BeltTypes b: BeltTypes.values()) {
      beltsTrack.put(b,0);
    }
  }

  private void assignBelts(int num) {
    if (num == 1) {
      int tmp = beltsTrack.get(BeltTypes.SMALL) + 1;
      beltsTrack.put(BeltTypes.SMALL,tmp);
    }
    else if (num == 2) {
      int tmp = beltsTrack.get(BeltTypes.MEDIUM) + 1;
      beltsTrack.put(BeltTypes.MEDIUM,tmp);
    }
    else if (num == 3) {
      int tmp = beltsTrack.get(BeltTypes.LARGE) + 1;
      beltsTrack.put(BeltTypes.LARGE,tmp);
    }
  }

  private void generateBelts() {
    RandomGenerator g = new UnknownRandomGenerator();
    int sum = 0;
    while (sum < 10) {
      int temp = g.getNumber(1, 4);
      while (temp == 3) {
        temp = g.getNumber(1, 4);
      }
      assignBelts(temp);
      sum += temp;
    }
  }

  @Override
  public void mountGear(Player p) {
    generateBelts();
    System.out.println(beltsTrack);
    int totalAffect = 0;
    for (Map.Entry<BeltTypes,Integer> b: beltsTrack.entrySet()) {
      totalAffect += b.getKey().getValue() * b.getValue();
    }
    p.setConstitution(p.getConstitution() + (3 * totalAffect));
    p.setDexterity(p.getDexterity() - (2 * totalAffect));
  }
}
