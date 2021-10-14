package weapon;

/**
 * Types of weapons available in the battle.
 * */
public enum WeaponTypes {
  BARE_HANDS,
  AXE,
  BROADSWORD,
  FLAIL,
  KATANA,
  TWO_HANDED_SWORD;

  @Override
  public String toString() {
    switch (this) {
      case BARE_HANDS:
        return "Bare Hands";
      case AXE:
        return "Axe";
      case FLAIL:
        return "Flail";
      case KATANA:
        return "Katana";
      case BROADSWORD:
        return "Broad Sword";
      case TWO_HANDED_SWORD:
        return "Two Handed Swords";
      default:
        throw new IllegalArgumentException("Unexpected Argument");
    }
  }
}
