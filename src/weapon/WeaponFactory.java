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
  public Weapon createWeapon(String weaponType, SwordTypes weaponSubType) {
    if (weaponType.equals("Axes")) {
      return new Axes();
    }
    else if (weaponType.equals("Flails")) {
      return new Flails();
    }
    else if (weaponType.equals("Swords") && weaponSubType.toString().equals("Katanas")) {
      return new Swords(weaponSubType);
    }
    else if (weaponType.equals("Swords") && weaponSubType.toString().equals("Broad Swords")) {
      return new Swords(weaponSubType);
    }
    else if (weaponType.equals("Swords") && weaponSubType.toString().equals("Two Handed Swords")) {
      return new Swords(weaponSubType);
    }
    return null;
  }
}
