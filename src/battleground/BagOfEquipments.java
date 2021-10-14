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
public class BagOfEquipments {

  List<Gear> equipments = new ArrayList<>();
  GearFactory gf = new GearFactory();
  GenerateRandomNumber g = new GenerateRandomNumber(3);

  private void generateEquipmentSet() {

    String temp;

    int count = 0;
    for (int i = 0; i < 7; i++) {
      temp = "HG" + (i + 1);
      equipments.add(gf.createGears(temp,GearCategory.HEADGEAR));
    }

    for (int i = 0; i < 7; i++) {
      temp = "FW" + (i + 1);
      equipments.add(gf.createGears(temp,GearCategory.FOOTWEAR));
    }

    for (int i = 0; i < 23; i++) {
      temp = "B" + (i + 1);
      equipments.add(gf.createGears(temp,GearCategory.BELT));
    }

    for (int i = 0; i < 30; i++) {
      temp = "P" + (i + 1);
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
          System.out.println("Inside B " + w);
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
            System.out.println("Inside P " + temp.getName() + w);
            count++;
          }
        }
      }
    }
//    for (Gear e: equipments) {
//      System.out.println("Hii" + e.getAbilityMap());
//    }
  }

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
