package weapon;

/**
 * Factory that creates different types of weapons.
 * */
public class WeaponFactory {
  /**
   * Method that helps in creating different types of weapons as specified.
   * @param weaponType the weapon type that needs to be created
   * @return new created weapon
   */
  public Weapon createWeapon(String weaponType) {
    if (weaponType.equalsIgnoreCase("Axe")) {
      return new Axes();
    }
    else if (weaponType.equalsIgnoreCase("Flail")) {
      return new Flails();
    }
    else if (weaponType.equalsIgnoreCase("Katana")) {
      return new Katanas();
    }
    else if (weaponType.equalsIgnoreCase("Broad Sword")) {
      return new BroadSwords();
    }
    else if (weaponType.equalsIgnoreCase("Two Handed Sword")) {
      return new TwoHandedSwords();
    }
    return null;
  }
}
