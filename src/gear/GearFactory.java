package gear;

import numbergenerator.GenerateRandomNumber;

/**
 * Factory to make different gears.
 * */
public class GearFactory {

  /**
   * Factory method that creates the gears.
   * @param gearType the type of gear
   * @return the gear
   */
  public Gear createGears(String gearName, GearCategory gearType) {
    if (gearType.equals(GearCategory.HEADGEAR)) {
      return new HeadGear(gearName);
    }
    else if (gearType.equals(GearCategory.FOOTWEAR)) {
      return new FootWear(gearName);
    }
    else if (gearType.equals(GearCategory.BELT)) {
      return new Belts(gearName);
    }
    else if (gearType.equals(GearCategory.POTION)) {
      return new Potions(gearName);
    }
    return null;
  }
}
