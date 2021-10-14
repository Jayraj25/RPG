package battleground;

import gear.Gear;
import gear.GearCategory;
import numbergenerator.GenerateRandomNumber;
import weapon.Weapon;
import weapon.WeaponTypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class from where a player equips gears and picks up a weapon from armory.
 * */
public class PlayerModel {

  BagOfEquipments bag = new BagOfEquipments();
  GenerateRandomNumber g = new GenerateRandomNumber(3);

  private Map<GearCategory,Integer> makeGearMap() {
    Map<GearCategory, Integer> gearMap = new HashMap<>();
    for (GearCategory g: GearCategory.values()) {
      gearMap.put(g,0);
    }
    return gearMap;
  }

  /**
   * Assign gears randomly to a player from bag of equipments.
   * @return List of gears
   * */
  public List<Gear> equipGears() {
    Map<GearCategory, Integer> gearMap = makeGearMap();
    List<Gear> gearList = bag.getEquipments();
    List<Gear> equippedGears = new ArrayList<>();
    int count = 0;
    int beltSum = 0;
    while (count != 20) {
      int temp = g.getRandomNumber(0,gearList.size() - 1);
      if (gearList.get(temp).getGearCategory().equals(GearCategory.HEADGEAR)
              && gearMap.get(GearCategory.HEADGEAR) == 0) {
        gearMap.put(GearCategory.HEADGEAR,1);
        equippedGears.add(gearList.get(temp));
        count++;
      }
      else if (gearList.get(temp).getGearCategory().equals(GearCategory.FOOTWEAR)
              && gearMap.get(GearCategory.FOOTWEAR) == 0) {
        gearMap.put(GearCategory.FOOTWEAR,1);
        equippedGears.add(gearList.get(temp));
        count++;
      }
      else if (gearList.get(temp).getGearCategory().equals(GearCategory.BELT)) {
        if (beltSum <= 10) {
          try {
            beltSum += gearList.get(temp).getGearUnit();
          } catch (IllegalAccessException e) {
            e.printStackTrace();
          }
          equippedGears.add(gearList.get(temp));
          count++;
          int addToMap = gearMap.get(GearCategory.BELT) + 1;
          gearMap.put(GearCategory.BELT,addToMap);
        }
      }
      else {
        equippedGears.add(gearList.get(temp));
        count++;
        int addToMap = gearMap.get(GearCategory.POTION) + 1;
        gearMap.put(GearCategory.POTION,addToMap);
      }
      gearList.remove(temp);
    }
    System.out.println(gearMap);
    return equippedGears;
  }

  /**
   * Player picks up a weapon randomly from armory.
   * @param armory the list of weapons
   * @return the weapon picked by the player.
   */
  public Weapon equipWeapon(List<Weapon> armory) {
    int temp = g.getRandomNumber(0, armory.size());
    Weapon assignedWeapon = armory.get(temp);
    armory.remove(temp);
    return assignedWeapon;
  }
}