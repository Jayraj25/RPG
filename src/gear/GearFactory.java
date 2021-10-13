package gear;

/**
 * Factory to make different gears.
 * */
public class GearFactory {
  /**
   * Factory method that creates the gears.
   * @param gearType the type of gear
   * @return the gear
   */
  public Gear createGears(String gearName, String gearType) {
    if (gearType.equalsIgnoreCase("headgear")) {
      return new HeadGear(gearName);
    }
    else if (gearType.equalsIgnoreCase("Footwear")) {
      return new FootWear(gearName);
    }
    else if (gearType.equalsIgnoreCase("Belt")) {
      return new Belts(gearName);
    }
    else if (gearType.equalsIgnoreCase("Potion")) {
      return new Potions(gearName);
    }
    return null;
  }
}
