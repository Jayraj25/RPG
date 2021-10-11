package gear;

/**
 * Enumeration for different types of belts.
 * {@link #SMALL}
 * {@link #MEDIUM}
 * {@link #LARGE}
 * */
public enum BeltTypes {
  SMALL,
  MEDIUM,
  LARGE;

  @Override
  public String toString() {
    switch (this) {
      case SMALL:
        return "Small";
      case MEDIUM:
        return "Medium";
      case LARGE:
        return "Large";
      default:
        throw new IllegalArgumentException("Unexpected Argument");
    }
  }
}
