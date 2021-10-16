package battleground;

import gear.Gear;
import gear.GearCategory;
import numbergenerator.GenerateRandomNumber;
import player.Player;
import weapon.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class from where a player equips gears and picks up a weapon from armory.
 * */
public class PlayerModel {

  BagOfEquipments bag = new BagOfEquipments(7,7,
          23,43);
  GenerateRandomNumber g = new GenerateRandomNumber(7);
  private final List<Gear> gearList = bag.getEquipments();


  private Map<GearCategory,Integer> makeGearMap() {
    Map<GearCategory, Integer> gearMap = new HashMap<>();
    for (GearCategory g: GearCategory.values()) {
      gearMap.put(g,0);
    }
    return gearMap;
  }

  /**
   * Assign gears randomly to a player from bag of equipments.
   * @param p The player
   * */
  public void equipGears(Player p) {
    Map<GearCategory, Integer> gearMap = makeGearMap();
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
        gearList.remove(temp);
      }
      else if (gearList.get(temp).getGearCategory().equals(GearCategory.FOOTWEAR)
              && gearMap.get(GearCategory.FOOTWEAR) == 0) {
        gearMap.put(GearCategory.FOOTWEAR,1);
        equippedGears.add(gearList.get(temp));
        count++;
        gearList.remove(temp);
      }
      else if (gearList.get(temp).getGearCategory().equals(GearCategory.BELT)) {
        try {
          beltSum += gearList.get(temp).getGearUnit();
        } catch (IllegalStateException e) {
          e.printStackTrace();
        }
        if (beltSum <= 10) {
          equippedGears.add(gearList.get(temp));
          int addToMap = gearMap.get(GearCategory.BELT) + 1;
          gearMap.put(GearCategory.BELT,addToMap);
          count++;
          gearList.remove(temp);
        }
      }
      else if (gearList.get(temp).getGearCategory().equals(GearCategory.POTION)) {
        equippedGears.add(gearList.get(temp));
        int addToMap = gearMap.get(GearCategory.POTION) + 1;
        gearMap.put(GearCategory.POTION,addToMap);
        count++;
        gearList.remove(temp);
      }
    }
    p.setEquippedGears(equippedGears);
  }

  /**
   * Player picks up a weapon randomly from armory.
   * @param armory the list of weapons
   * @return the weapon picked by the player.
   */
  public Weapon equipWeapon(List<Weapon> armory) {
    int temp = g.getRandomNumber(0, armory.size() - 1);
    Weapon assignedWeapon = armory.get(temp);
    armory.remove(temp);
    return assignedWeapon;
  }
}