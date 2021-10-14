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
  public Weapon createWeapon(WeaponTypes weaponType) {
    if (weaponType.equals(WeaponTypes.BARE_HANDS)) {
      return new BareHands();
    }
    if (weaponType.equals(WeaponTypes.AXE)) {
      return new Axes();
    }
    else if (weaponType.equals(WeaponTypes.FLAIL)) {
      return new Flails();
    }
    else if (weaponType.equals(WeaponTypes.KATANA)) {
      return new Katanas();
    }
    else if (weaponType.equals(WeaponTypes.BROADSWORD)) {
      return new BroadSwords();
    }
    else if (weaponType.equals(WeaponTypes.TWO_HANDED_SWORD)) {
      return new TwoHandedSwords();
    }
    return null;
  }
}
