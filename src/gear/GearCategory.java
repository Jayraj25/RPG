package gear;

public enum GearCategory {
  BELT,
  FOOTWEAR,
  HEADGEAR,
  POTION;

  @Override
  public String toString() {
    switch (this) {
      case BELT:
        return "Belt";
      case HEADGEAR:
        return "Headgear";
      case POTION:
        return "Potion";
      case FOOTWEAR:
        return "Footwear";
      default:
        throw new IllegalArgumentException("Unexpected Argument");
    }
  }
}
