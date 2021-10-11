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
  public Gear createGears(String gearType) {
    if (gearType.equalsIgnoreCase("headgear")) {
      return new HeadGear();
    }
    else if (gearType.equalsIgnoreCase("Footwear")) {
      return new FootWear();
    }
    else if (gearType.equalsIgnoreCase("Belts")) {
      return new Belts();
    }
    else if (gearType.equalsIgnoreCase("Potion")) {
      return new Potions();
    }
    return null;
  }
}
