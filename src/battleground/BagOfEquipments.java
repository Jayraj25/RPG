package battleground;

import gear.Gear;
import gear.GearFactory;
import numbergenerator.GenerateRandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * A bag containing gears from which a player will be randomly assigned 20 gears.
 * */
public class BagOfEquipments {

  List<Gear> equipments = new ArrayList<>();
  GearFactory gf = new GearFactory();
  GenerateRandomNumber g = new GenerateRandomNumber();

  private void generateEquipmentSet() {

    String temp;

    int count = 0;
    for (int i = 0; i < 7; i++) {
      temp = "HG" + (i + 1);
      equipments.add(gf.createGears(temp,"headgear"));
    }

    for (int i = 0; i < 7; i++) {
      temp = "FW" + (i + 1);
      equipments.add(gf.createGears(temp,"footwear"));
    }

    for (int i = 0; i < 23; i++) {
      temp = "B" + (i + 1);
      equipments.add(gf.createGears(temp,"belt"));
    }

    for (int i = 0; i < 30; i++) {
      temp = "P" + (i + 1);
      equipments.add(gf.createGears(temp,"Potion"));
    }
  }

  private void tweakAbilities() {
    int count = 0;
    while (count != (equipments.size() / 4)) {
      int tempGearIndex = g.getRandomNumber(0,equipments.size() - 1);
      Gear temp = equipments.get(tempGearIndex);
      while (temp.getName().contains("HG") || temp.getName().contains("FW")) {
        tempGearIndex = g.getRandomNumber(0,equipments.size() - 1);
        temp = equipments.get(tempGearIndex);
      }
      Map<String, Integer> w;
      if (temp.getName().contains("B")) {
        if (!temp.getFlag()) {
          w = temp.getAffectOnPlayerAbility();
          int dexterity = w.get("Dexterity") * -1;
          w.put("Dexterity",dexterity);
          System.out.println("Inside B " + w);
          count++;
        }
      }
      else if (temp.getName().contains("P")) {
        if (!temp.getFlag()) {
          w = temp.getAffectOnPlayerAbility();
          List<String> keysAsArray = new ArrayList<>(w.keySet());
          String f = keysAsArray.get(g.getRandomNumber(0,keysAsArray.size() - 1));
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
