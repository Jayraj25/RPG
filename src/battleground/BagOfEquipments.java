package battleground;

import gear.Gear;
import gear.GearCategory;
import gear.GearFactory;
import numbergenerator.GenerateRandomNumber;
import player.PlayerAbilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A bag containing gears from which a player will be randomly assigned 20 gears.
 * */
public class BagOfEquipments implements Bag {

  private final List<Gear> equipments = new ArrayList<>();
  GearFactory gf = new GearFactory();
  GenerateRandomNumber g = new GenerateRandomNumber(3);
  private final int noOfHeadGears;
  private final int noOfFootwear;
  private final int noOfBelts;
  private final int noOfPotions;

  /**
   * Makes bag of equipments (gears) where the user specifies
   * the number of individual gears to be available in the bag.
   * @param noOfHeadGears number of head gears
   * @param noOfFootwear number of footwear
   * @param noOfBelts number of belts
   * @param noOfPotions number of potions.
   */
  public BagOfEquipments(int noOfHeadGears, int noOfFootwear, int noOfBelts, int noOfPotions)
          throws IllegalArgumentException {
    if (noOfHeadGears < 5 || noOfFootwear < 5 || noOfBelts < 15 || noOfPotions < 15) {
      throw new IllegalArgumentException("Minimum number of head gears are 5, footwear are 5, "
              + "belts is 15 and potions is 15 respectively.");
    }
    this.noOfHeadGears = noOfHeadGears;
    this.noOfFootwear = noOfFootwear;
    this.noOfBelts = noOfBelts;
    this.noOfPotions = noOfPotions;
  }

  private void generateEquipmentSet() {

    String temp;

    for (int i = 0; i < noOfHeadGears; i++) {
      temp = "Head Gear" + (i + 1);
      equipments.add(gf.createGears(temp,GearCategory.HEADGEAR));
    }

    for (int i = 0; i < noOfFootwear; i++) {
      temp = "Footwear " + (i + 1);
      equipments.add(gf.createGears(temp,GearCategory.FOOTWEAR));
    }

    for (int i = 0; i < noOfBelts; i++) {
      temp = "Belt " + (i + 1);
      equipments.add(gf.createGears(temp,GearCategory.BELT));
    }

    for (int i = 0; i < noOfPotions; i++) {
      temp = "Potion " + (i + 1);
      equipments.add(gf.createGears(temp,GearCategory.POTION));
    }
  }

  private void tweakAbilities() {
    int count = 0;
    while (count != (equipments.size() / 4)) {
      int tempGearIndex = g.getRandomNumber(0,equipments.size() - 1);
      Gear temp = equipments.get(tempGearIndex);
      while (temp.getGearCategory().equals(GearCategory.HEADGEAR)
              || temp.getGearCategory().equals(GearCategory.FOOTWEAR)) {
        tempGearIndex = g.getRandomNumber(0,equipments.size() - 1);
        temp = equipments.get(tempGearIndex);
      }
      Map<PlayerAbilities, Integer> w;
      if (temp.getGearCategory().equals(GearCategory.BELT)) {
        if (!temp.getFlag()) {
          w = temp.getAffectOnPlayerAbility();
          int dexterity = w.get(PlayerAbilities.DEXTERITY) * -1;
          w.put(PlayerAbilities.DEXTERITY,dexterity);
//          System.out.println("Inside B " + w);
          count++;
        }
      }
      else if (temp.getGearCategory().equals(GearCategory.POTION)) {
        if (!temp.getFlag()) {
          w = temp.getAffectOnPlayerAbility();
          List<PlayerAbilities> keysAsArray = new ArrayList<>(w.keySet());
          PlayerAbilities f = keysAsArray.get(g.getRandomNumber(0,keysAsArray.size() - 1));
          if (w.get(f) != 0) {
            int affect = w.get(f) * -1;
            w.put(f,affect);
//            System.out.println("Inside P " + temp.getName() + w);
            count++;
          }
        }
      }
    }
//    for (Gear e: equipments) {
//      System.out.println("Hii" + e.getAbilityMap());
//    }
  }

  @Override
  public List<Gear> getEquipments() {
    generateEquipmentSet();
    tweakAbilities();
    return equipments;
  }

  @Override
  public String toString() {
    StringBuilder temp = new StringBuilder();
    for (Gear g: equipments) {
      temp.append("(").append(g.getName()).append(")").append(g.getAbilityMap());
    }
    return temp.toString();
  }
}
