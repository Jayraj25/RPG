package gear;

import numbergenerator.GenerateRandomNumber;
import player.Player;

import java.util.Map;
import java.util.TreeMap;

/**
 * Creates the Potions and Helps in getting how much it affects a player's ability.
 */
public class Potions implements Gear {

  Map<PotionTypes,Integer> potionTrack = new TreeMap<>();

  /**
   * Constructs potions with a map that keeps a track of
   * which and how many potions taken by a player.
   * */
  public Potions() {
    for (PotionTypes p: PotionTypes.values()) {
      potionTrack.put(p,0);
    }
  }

  private void generatePotions() {
    GenerateRandomNumber g = new GenerateRandomNumber();
    int sum = 0;
    while (sum < 100) {
      int temp = g.getRandomNumber(2, 6);
      assignPotions(temp);
      sum += temp;
    }
  }

  private void assignPotions(int num) {
    if (num == 2) {
      int tmp = potionTrack.get(PotionTypes.P2) + 1;
      potionTrack.put(PotionTypes.P2,tmp);
    }
    else if (num == 3) {
      int tmp = potionTrack.get(PotionTypes.P3) + 1;
      potionTrack.put(PotionTypes.P3,tmp);
    }
    else if (num == 4) {
      int tmp = potionTrack.get(PotionTypes.P4) + 1;
      potionTrack.put(PotionTypes.P4,tmp);
    }
    else if (num == 5) {
      int tmp = potionTrack.get(PotionTypes.P5) + 1;
      potionTrack.put(PotionTypes.P5,tmp);
    }
    else if (num == 6) {
      int tmp = potionTrack.get(PotionTypes.P6) + 1;
      potionTrack.put(PotionTypes.P6,tmp);
    }
  }

  @Override
  public void mountGear(Player p) {
    generatePotions();
    System.out.println(potionTrack);
    for (Map.Entry<PotionTypes,Integer> b: potionTrack.entrySet()) {
      p.setStrength(p.getStrength() + (b.getKey().getAffectStrength()));
      p.setConstitution(p.getConstitution() + (b.getKey().getAffectConstitution()));
      p.setCharisma(p.getCharisma() + (b.getKey().getAffectCharisma()));
      p.setDexterity(p.getDexterity() + (b.getKey().getAffectDexterity()));
    }

  }
}
