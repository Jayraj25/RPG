package gear;


import numbergenerator.GenerateRandomNumber;
import player.Player;

import java.util.HashMap;
import java.util.Map;

/**
 * Creates the Belts gear and Helps in getting how much
 * it affects a player's ability. It affects player's dexterity and constitution ability.
 */
public class Belts extends AbstractGear {

  Map<BeltTypes, Integer> beltsTrack = new HashMap<>();
  GenerateRandomNumber g = new GenerateRandomNumber();
  private BeltTypes size;
  private final int beltUnit;

  /**
   * Constructs belts as gear.
   * @param gearName the name assigned to this gear
   * */
  public Belts(String gearName) {
    super(gearName);
    int temp = g.getRandomNumber(1, 4);
    while (temp == 3) {
      temp = g.getRandomNumber(1, 4);
    }
    assignBelts(temp);
    beltUnit = temp;
  }

  private void assignBelts(int num) {
    if (num == 1) {
      size = BeltTypes.SMALL;
//      int tmp = beltsTrack.get(BeltTypes.SMALL) + 1;
//      beltsTrack.put(BeltTypes.SMALL,tmp);
    }
    else if (num == 2) {
      size = BeltTypes.MEDIUM;
//      int tmp = beltsTrack.get(BeltTypes.MEDIUM) + 1;
//      beltsTrack.put(BeltTypes.MEDIUM,tmp);
    }
    else if (num == 4) {
      size = BeltTypes.LARGE;
//      int tmp = beltsTrack.get(BeltTypes.LARGE) + 1;
//      beltsTrack.put(BeltTypes.LARGE,tmp);
    }
    System.out.println("Belt size " + size);
  }

  private void generateBelts() {
    GenerateRandomNumber g = new GenerateRandomNumber();
    int sum = 0;
    while (sum < 10) {
      int temp = g.getRandomNumber(1, 4);
      while (temp == 3) {
        temp = g.getRandomNumber(1, 4);
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
    p.setDexterity(p.getDexterity() - (totalAffect));
  }

  @Override
  public Map<String, Integer> getAffectOnPlayerAbility() {
    temp.put("Constitution", 3);
    temp.put("Dexterity", 1);
    setFlag(true);
    return temp;
  }

  @Override
  public Map<String, Integer> getAbilityMap() {
    if (getFlag()) {
      return temp;
    }
    else {
      Map<String, Integer> x = new HashMap<>();
      x.put("Constitution", 3);
      x.put("Dexterity", 1);
      return x;
    }
//    return temp;
  }

  @Override
  public BeltTypes getBeltType() {
    return size;
  }

  @Override
  public int getGearUnit() {
    return beltUnit;
  }
}
