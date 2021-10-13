package gear;

import numbergenerator.GenerateRandomNumber;
import player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Creates the Potions and Helps in getting how much it affects a player's ability.
 */
public class Potions extends AbstractGear {

  Map<PotionTypes,Integer> potionTrack = new TreeMap<>();
  GenerateRandomNumber g = new GenerateRandomNumber();
  private PotionTypes type;
  private final int potionUnit;
//  boolean flag = false;

  /**
   * Constructs potions with a map that keeps a track of
   * which and how many potions taken by a player.
   * */
  public Potions(String gearName) {
    super(gearName);
    for (PotionTypes p: PotionTypes.values()) {
      potionTrack.put(p,0);
    }
    int temp = g.getRandomNumber(2, 6);
    assignPotions(temp);
    potionUnit = temp;
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
      type = PotionTypes.P2;
      int tmp = potionTrack.get(PotionTypes.P2) + 1;
      potionTrack.put(PotionTypes.P2,tmp);
    }
    else if (num == 3) {
      type = PotionTypes.P3;
      int tmp = potionTrack.get(PotionTypes.P3) + 1;
      potionTrack.put(PotionTypes.P3,tmp);
    }
    else if (num == 4) {
      type = PotionTypes.P4;
      int tmp = potionTrack.get(PotionTypes.P4) + 1;
      potionTrack.put(PotionTypes.P4,tmp);
    }
    else if (num == 5) {
      type = PotionTypes.P5;
      int tmp = potionTrack.get(PotionTypes.P5) + 1;
      potionTrack.put(PotionTypes.P5,tmp);
    }
    else if (num == 6) {
      type = PotionTypes.P6;
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

  @Override
  public Map<String, Integer> getAffectOnPlayerAbility() {
    temp.put("Constitution", g.getRandomNumber(0,5));
    temp.put("Dexterity", g.getRandomNumber(0,4));
    temp.put("Charisma", g.getRandomNumber(2,6));
    temp.put("Strength", g.getRandomNumber(0,8));
    setFlag(true);
    return temp;
  }

  @Override
  public Map<String, Integer> getAbilityMap() {
    if (getFlag()) {
      return temp;
    }
    else {
      Map<String, Integer> x= new HashMap<>();
      x.put("Constitution", g.getRandomNumber(0,5));
      x.put("Dexterity", g.getRandomNumber(0,4));
      x.put("Charisma", g.getRandomNumber(2,6));
      x.put("Strength", g.getRandomNumber(0,8));
      return x;
    }
  }

  @Override
  public PotionTypes getPotionType() {
    return type;
  }

  @Override
  public int getGearUnit() {
    return potionUnit;
  }

  @Override
  public String toString() {
    return String.format("Potion1: %d, Potion2: %d, Potion3: %d, Potion4: %d, Potion5: %d",
            potionTrack.get(PotionTypes.P2),potionTrack.get(PotionTypes.P3),
            potionTrack.get(PotionTypes.P4),potionTrack.get(PotionTypes.P5),
            potionTrack.get(PotionTypes.P6));
  }

}
